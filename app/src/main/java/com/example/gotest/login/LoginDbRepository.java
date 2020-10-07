package com.example.gotest.login;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gotest.database.User;
import com.example.gotest.database.UserDAO;
import com.example.gotest.database.UserDB;

import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class LoginDbRepository implements LoginRepositoryInterface{

    UserDAO userDAO;

    private LiveData<List<User>> users;

    @Inject
    public LoginDbRepository() {
    }



    @Override
    public void initializeDB(Application application){
        UserDB userDB = UserDB.getDatabase(application);
        this.userDAO = userDB.userDao();
        users = userDAO.getUsers();
    }


    @Override
    public LiveData<List<User>> getUsers() {
        return users;
    }

}

