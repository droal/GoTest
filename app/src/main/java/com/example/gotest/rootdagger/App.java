package com.example.gotest.rootdagger;


/**Logica de la clase Apliccation*/

import android.app.Application;

import com.example.gotest.api.inject.ApiModule;
import com.example.gotest.establishment.inject.EstablishmentModule;
import com.example.gotest.login.inject.LoginModule;
import com.example.gotest.signin.inject.SignInModule;


/**Acá se declaran los modulos que requiere la aplicación*/
public class  App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .apiModule(new ApiModule())
                .establishmentModule(new EstablishmentModule())
                .signInModule(new SignInModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
