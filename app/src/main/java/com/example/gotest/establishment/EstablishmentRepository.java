package com.example.gotest.establishment;

import com.example.gotest.api.establishment.ApiEstablishmentService;
import com.example.gotest.api.establishment.Establishment;
import com.example.gotest.api.establishment.ResponseList;
import com.example.gotest.rootdagger.DaggerApplicationComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

public class EstablishmentRepository implements EstablishmentRepositoryInterface {

    private static final long CACHE_LIFETIME = 60 * 100; //Teimpo para actualización de la caché (60 segundos)
    private long lastTimestamp;

    //Datos recuperados (de BD o Servicio)
    private List<Establishment> results;

    @Inject
    ApiEstablishmentService establishmentApiService;

    public EstablishmentRepository() {
        //Inyectar la clase
        DaggerApplicationComponent.builder().build().inject(this);

        //Tomar tiempo última actualización
        this.lastTimestamp = System.currentTimeMillis();
        //Inicializar arrays
        this.results = new ArrayList<>();
    }


    @Override
    public Observable<Establishment> getAllEstablishment() {
        //Si el método getEstablishmentFromDB retorna un Observable vacío
        // (el tiempo estipulado para actualizar datos ha vencido / no se han obtenido datos por primera vez)
        //=> se obtienen datos del servicio
        return getEstablishmentFromDB().switchIfEmpty(getEstablishmentFromNetwork());
    }


    //Si se encuentra dentro del rango para actualización retorna la información de la BD
    //de lo contrario retorna un objeto vacío (forzando consump de servicio)
    public Observable<Establishment> getEstablishmentFromDB() {
        if(isUpdated()){
            return Observable.fromIterable(results);
        }
        else{
            lastTimestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    //Validar si los datos en BD están actualizados
    //(si está dentro del tiempo de actualización)
    public boolean isUpdated(){
        return (System.currentTimeMillis() - lastTimestamp) < CACHE_LIFETIME;
    }


    //Consumir servicio
    public Observable<Establishment> getEstablishmentFromNetwork() {
        Observable<ResponseList> establishmentObservable = establishmentApiService.getAllEstablishment();

        return establishmentObservable
                .concatMap(new Function<ResponseList, ObservableSource<Establishment>>() {
                    @Override
                    public ObservableSource<Establishment> apply(ResponseList responseList) throws Throwable {
                        return Observable.fromIterable(responseList.getData());
                    }
                })
                .doOnNext(new Consumer<Establishment>() {
                    @Override
                    public void accept(Establishment establishment) throws Throwable {
                        results.add(establishment);
                    }
                });
    }



}
