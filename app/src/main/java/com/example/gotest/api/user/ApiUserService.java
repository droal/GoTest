package com.example.gotest.api.user;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiUserService {

    @POST("client/registre/")
    Observable<ResponseUser> createUser();
    /*Observable<ResponseUser> createUser(@Query("tipoDocumento") String tipoDoc,
                                        @Query("numeroIdentificacion") Integer numDoc,
                                        @Query("nombres") String nombres,
                                        @Query("apellidos") String apellidos,
                                        @Query("telefonoMovil") String telefono,
                                        @Query("correo") String correo,
                                        @Query("password") String password);*/
}
