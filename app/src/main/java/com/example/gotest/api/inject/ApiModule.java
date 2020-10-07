package com.example.gotest.api.inject;

import com.example.gotest.api.establishment.ApiEstablishmentService;
import com.example.gotest.api.user.ApiUserService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    public final String URL_BASE = "https://apiprueba.gopass.com.co/";


    @Provides
    public OkHttpClient provideHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
    }


    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    public ApiUserService provideApiUserService(){
        return provideRetrofit(URL_BASE, provideHttpClient()).create(ApiUserService.class);
    }

    @Provides
    public ApiEstablishmentService provideApiEstablishmentService(){
        return provideRetrofit(URL_BASE, provideHttpClient()).create(ApiEstablishmentService.class);
    }
}
