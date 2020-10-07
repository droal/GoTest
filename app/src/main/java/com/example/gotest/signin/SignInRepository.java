package com.example.gotest.signin;

import com.example.gotest.api.user.ApiUserService;
import com.example.gotest.database.User;

import javax.inject.Inject;

public class SignInRepository  {

    //@Inject
    //ApiUserService apiUserService;


    public SignInRepository() {
        //Inyectar la clase
        //DaggerApplicationComponent.builder().build().inject(this);
    }




/*    @Override
    public Observable<UserData> createUser() {
        Observable<ResponseUser> establishmentObservable = apiUserService.createUser();

        return establishmentObservable
                .concatMap(new Function<ResponseUser, ObservableSource<UserData>>() {
                    @Override
                    public ObservableSource<UserData> apply(ResponseUser responseUser) throws Throwable {
                        return Observable.just(responseUser.getData());
                    }
                });

    }*/
}
