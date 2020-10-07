package com.example.gotest.login;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gotest.R;
import com.example.gotest.database.User;
import com.example.gotest.rootdagger.DaggerApplicationComponent;

import java.util.List;

import javax.inject.Inject;


public class LoginViewModel extends AndroidViewModel {

    @Inject
    LoginRepositoryInterface repository;

    private MutableLiveData<Boolean> mutableResult = null;
    private MutableLiveData<String> mutableErrorMsg = null;
    LiveData<List<User>> users = null;
    List<User> usersList = null;

    String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{5,}$";
    String mailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";

    public LoginViewModel(@NonNull Application application) {
        super(application);
        DaggerApplicationComponent.builder().build().inject(this);
        repository.initializeDB(getApplication());

        users = repository.getUsers();
    }

    public LiveData<Boolean> getMutableResult(){
        if(mutableResult == null){
            mutableResult = new MutableLiveData<>();
        }
        return mutableResult;
    }

    public LiveData<String> getMutableErrorMsg(){
        if(mutableErrorMsg == null){
            mutableErrorMsg = new MutableLiveData<>();
        }
        return mutableErrorMsg;
    }

    public void setUserList(List<User> usersList){
        this.usersList = usersList;
    }

    LiveData<List<User>> getUsers(){
        return users;
    }


    void login(String correo, String password){

        if(correo.equals("") || password.equals("")){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_empty_imput));
        }
        else if(!correo.matches(mailRegex)){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_correo_err));
        }
        else if(!password.matches(passRegex)){
            mutableErrorMsg.setValue(getApplication().getResources().getString(R.string.signin_password_err));
        }
        else{
            for (User user : usersList) {
                if(user.getCorreo().equals(correo) & user.getPassword().equals(password)){
                    mutableResult.setValue(true);
                }else{
                    mutableResult.setValue(false);
                }
            }
        }
    }


}
