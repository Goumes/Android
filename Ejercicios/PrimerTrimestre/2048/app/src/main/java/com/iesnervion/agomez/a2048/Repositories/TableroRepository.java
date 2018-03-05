package com.iesnervion.agomez.a2048.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.iesnervion.agomez.a2048.DAO.TableroDAO;
import com.iesnervion.agomez.a2048.Database.AppDatabase;
import com.iesnervion.agomez.a2048.Entities.Tablero;

/**
 * Created by agomez on 23/01/18.
 */

public class TableroRepository
{
    private TableroDAO mTableroDao;
    private LiveData<Tablero> mTablero;


    public TableroRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mTableroDao = db.tableroDAO();
        mTablero = mTableroDao.cargarTablero();
    }

    public void updateTablero (Application application, Tablero tablero)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        db.tableroDAO().updateTablero(tablero);
    }

    public LiveData<Tablero> getTablero() {
        return mTablero;
    }
}
