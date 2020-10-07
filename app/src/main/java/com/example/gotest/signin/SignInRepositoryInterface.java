package com.example.gotest.signin;


import android.app.Application;

import com.example.gotest.database.User;



public interface SignInRepositoryInterface {

    void createUser(User user);
    void initializeDB(Application application);
}
