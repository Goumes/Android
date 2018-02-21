package com.example.agomez.examen_final_alejandro_gomez.Repositorio;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.agomez.examen_final_alejandro_gomez.DAO.FutbolistaDao;
import com.example.agomez.examen_final_alejandro_gomez.DAO.PosicionesDao;
import com.example.agomez.examen_final_alejandro_gomez.Database.AppDatabase;
import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;

import java.util.List;

/**
 * Created by agomez on 21/02/18.
 */

public class Repositorio
{
    private FutbolistaDao mFutbolistaDao;
    private PosicionesDao mPosicionesDao;
    private LiveData<List<Futbolista>> mTodosFutbolistas;
    private LiveData<List<Posicion>> mTodasPosiciones;


    public Repositorio(Application application)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        mFutbolistaDao = db.futbolistaDao();
        mPosicionesDao = db.posicionesDao();
        mTodosFutbolistas = mFutbolistaDao.cargarTodosFutbolistas ();
        mTodasPosiciones = mPosicionesDao.cargarTodasPosiciones();
    }

    public LiveData<List<Futbolista>> getFutbolistas()
    {
        return mTodosFutbolistas;
    }

    public LiveData<List<Posicion>> getmTodasPosiciones() {
        return mTodasPosiciones;
    }

    public void insertFutbolista (Application application, Futbolista futbolista)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        db.futbolistaDao().insertFutbolista(futbolista);
    }
}
