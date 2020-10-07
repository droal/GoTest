package com.example.gotest.establishment;

import com.example.gotest.api.establishment.Establishment;
import io.reactivex.rxjava3.core.Observable;

public interface EstablishmentRepositoryInterface {

    Observable<Establishment> getAllEstablishment();

}
