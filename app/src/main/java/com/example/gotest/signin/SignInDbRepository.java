package com.example.gotest.signin;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gotest.api.user.UserData;
import com.example.gotest.database.User;
import com.example.gotest.database.UserDAO;
import com.example.gotest.database.UserDB;

import javax.inject.Inject;

public class SignInDbRepository implements SignInRepositoryInterface{

    UserDAO userDAO;

    @Inject
    public SignInDbRepository() {
    }

    @Override
    public void initializeDB(Application application){
        UserDB userDB = UserDB.getDatabase(application);
        this.userDAO = userDB.userDao();
    }

    @Override
    public void createUser(User user) {
        UserDB.databaseWriteExecutor.execute(() -> {
            userDAO.create(user);
        });

    }


}
