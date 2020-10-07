package com.example.gotest.signin.inject;


import com.example.gotest.signin.SignInDbRepository;
import com.example.gotest.signin.SignInRepositoryInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class SignInModule {

    @Provides
    public SignInRepositoryInterface provideSignInRepository(){
        return new SignInDbRepository();
    }
}
