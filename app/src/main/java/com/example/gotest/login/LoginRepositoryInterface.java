package com.example.gotest.login;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.gotest.database.User;


import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface LoginRepositoryInterface {

    LiveData<List<User>> getUsers();
    void initializeDB(Application application);
}
