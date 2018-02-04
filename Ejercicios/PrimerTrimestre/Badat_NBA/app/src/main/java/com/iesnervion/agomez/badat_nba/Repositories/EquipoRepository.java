package com.iesnervion.agomez.badat_nba.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.iesnervion.agomez.badat_nba.DAO.EquipoDao;
import com.iesnervion.agomez.badat_nba.Database.AppDatabase;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;

import java.util.List;

/**
 * Created by agomez on 23/01/18.
 */

public class EquipoRepository
{
    private EquipoDao mEquipoDao;
    private LiveData<List<Equipo>> mTodosEquipos;


    public EquipoRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mEquipoDao = db.equipoDao();
        mTodosEquipos = mEquipoDao.cargarTodosEquipos();
    }

    public LiveData<List<Equipo>> getEquipos() {
        return mTodosEquipos;
    }
}
