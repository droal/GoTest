package com.example.gotest.login.inject;

import com.example.gotest.login.LoginDbRepository;
import com.example.gotest.login.LoginRepositoryInterface;
import com.example.gotest.signin.SignInDbRepository;
import com.example.gotest.signin.SignInRepositoryInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginRepositoryInterface provideLoginRepository(){
        return new LoginDbRepository();
    }

}
