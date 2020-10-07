package com.example.gotest.rootdagger;

import com.example.gotest.api.inject.ApiModule;
import com.example.gotest.establishment.EstablishmentRepository;
import com.example.gotest.establishment.EstablishmentViewModel;
import com.example.gotest.establishment.inject.EstablishmentModule;
import com.example.gotest.login.LoginActivity;
import com.example.gotest.login.LoginDbRepository;
import com.example.gotest.login.LoginViewModel;
import com.example.gotest.login.inject.LoginModule;
import com.example.gotest.signin.SignInDbRepository;
import com.example.gotest.signin.SignInRepository;
import com.example.gotest.signin.SignInViewModel;
import com.example.gotest.signin.inject.SignInModule;

import javax.inject.Singleton;

import dagger.Component;

/**Indicar los modulos de los cuales depende el componente*/
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, EstablishmentModule.class, ApiModule.class, SignInModule.class})
public interface ApplicationComponent {

    /**Clases inyectadas*/
    void inject(LoginActivity target);
    void inject(EstablishmentRepository establishmentRepository);
    void inject(EstablishmentViewModel establishmentViewModel);
    void inject(SignInRepository signInRepository);
    void inject(SignInDbRepository signInDbRepository);
    void inject(SignInViewModel signInViewModel);
    void inject(LoginDbRepository loginDbRepository);
    void inject(LoginViewModel loginViewModel);
}
