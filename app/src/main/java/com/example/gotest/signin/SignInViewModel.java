package com.example.gotest.signin;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gotest.R;
import com.example.gotest.api.establishment.Establishment;
import com.example.gotest.database.User;
import com.example.gotest.rootdagger.DaggerApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class SignInViewModel extends AndroidViewModel {

    @Inject
    SignInRepositoryInterface repository;

    private MutableLiveData<Boolean> mutableCreateResult = null;

    private MutableLiveData<String> mutableErrorMsg = null;

    String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{5,}$";
    String mailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";

    public SignInViewModel(@NonNull Application application) {
        super(application);
        DaggerApplicationComponent.builder().build().inject(this);
        repository.initializeDB(getApplication());
    }


    public LiveData<Boolean> getMutableCreateResult(){
        if(mutableCreateResult == null){
            mutableCreateResult = new MutableLiveData<>();
        }
        return mutableCreateResult;
    }

    public LiveData<String> getMutableErrorMsg(){
        if(mutableErrorMsg == null){
            mutableErrorMsg = new MutableLiveData<>();
        }
        return mutableErrorMsg;
    }

    public void crearUsuario(String tipoDoc, String numDoc, String nombres, String apellidos, String telefono, String correo, String password){

        if(tipoDoc.equals("") || numDoc.equals("") || nombres.equals("") || apellidos.equals("") || telefono.equals("") || correo.equals("") || password.equals("")){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_empty_imput));
        }
        else if(!correo.matches(mailRegex)){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_correo_err));
        }
        else if(!password.matches(passRegex)){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_password_err));
        }else{
            User user  = new User(tipoDoc, Integer.parseInt(numDoc), nombres, apellidos, telefono, correo, password);
            repository.createUser(user);
            mutableCreateResult.setValue(true);
        }

    }


}
