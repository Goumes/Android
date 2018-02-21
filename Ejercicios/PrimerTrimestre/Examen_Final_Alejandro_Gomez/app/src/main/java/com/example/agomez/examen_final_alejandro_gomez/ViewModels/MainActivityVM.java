package com.example.agomez.examen_final_alejandro_gomez.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;
import com.example.agomez.examen_final_alejandro_gomez.Repositorio.Repositorio;

import java.util.List;

/**
 * Created by agomez on 21/02/18.
 */

public class MainActivityVM extends AndroidViewModel
{
    MutableLiveData<Integer> opcion;
    LiveData<List<Futbolista>> futbolistas;
    Repositorio repositorio;
    LiveData<List<Posicion>> posiciones;

    public LiveData<List<Futbolista>> getFutbolistas() {
        return futbolistas;
    }

    public void setFutbolistas(LiveData<List<Futbolista>> futbolistas) {
        this.futbolistas = futbolistas;
    }

    public MainActivityVM(@NonNull Application application) {
        super(application);
        opcion = new MutableLiveData<>();
        repositorio = new Repositorio(application);

        futbolistas = repositorio.getFutbolistas();
        posiciones = repositorio.getmTodasPosiciones();
    }

    public MutableLiveData<Integer> getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion.setValue(opcion);
    }

    public LiveData<List<Posicion>> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(LiveData<List<Posicion>> posiciones) {
        this.posiciones = posiciones;
    }

    public void insertFutbolista (Futbolista futbolista)
    {
        repositorio.insertFutbolista(getApplication(), futbolista);
    }

}
