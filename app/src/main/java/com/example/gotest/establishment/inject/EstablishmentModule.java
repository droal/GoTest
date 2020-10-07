package com.example.gotest.establishment.inject;

import com.example.gotest.establishment.EstablishmentRepository;
import com.example.gotest.establishment.EstablishmentRepositoryInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class EstablishmentModule {

    @Provides
    public EstablishmentRepositoryInterface provideRepository(){
        return new EstablishmentRepository();
    }
}
