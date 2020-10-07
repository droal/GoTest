package com.example.gotest.establishment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.gotest.api.establishment.Establishment;
import com.example.gotest.rootdagger.DaggerApplicationComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EstablishmentViewModel extends AndroidViewModel {

    @Inject
    EstablishmentRepositoryInterface repository;

    private Disposable subscription = null;

    private MutableLiveData<List<Establishment>> mutableEstablishment = null;

    private List<Establishment> establishmentList = new ArrayList<>();


    public EstablishmentViewModel(Application application) {
        super(application);
        DaggerApplicationComponent.builder().build().inject(this);
    }


    public LiveData<List<Establishment>> getMutableLivedataEstablishment(){
        if(mutableEstablishment == null){
            mutableEstablishment = new MutableLiveData<>();
        }
        return mutableEstablishment;
    }


    public void loadData() {
        establishmentList.clear();

        subscription = repository.getAllEstablishment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Establishment>() {
                    @Override
                    public void onNext(Establishment establishment) {
                        establishmentList.add(establishment);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        mutableEstablishment.setValue(establishmentList);
                    }
                });
    }


}
