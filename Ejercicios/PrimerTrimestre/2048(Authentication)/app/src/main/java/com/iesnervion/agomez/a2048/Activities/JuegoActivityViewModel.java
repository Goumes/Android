package com.iesnervion.agomez.a2048.Activities;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.media.AudioRecord;

import com.iesnervion.agomez.a2048.Database.AppDatabase;
import com.iesnervion.agomez.a2048.Entities.Tablero;
import com.iesnervion.agomez.a2048.Repositories.TableroRepository;

/**
 * Created by aleja on 08/02/2018.
 */

public class JuegoActivityViewModel extends AndroidViewModel
{
    private AppDatabase mDb;
    private LiveData<Tablero> tablero;
    TableroRepository mRepositorio;

    public JuegoActivityViewModel(Application application)
    {
        super(application);

        mRepositorio = new TableroRepository(application);
        this.tablero = mRepositorio.getTablero();
    }

    public void createDb() {
        mDb = AppDatabase.getDatabase(this.getApplication());
    }

    public void updateTablero (Tablero tablero)
    {
        mRepositorio.updateTablero(this.getApplication(), tablero);
    }

    public LiveData<Tablero> getTablero() {
        return tablero;
    }

    public void setTablero(LiveData<Tablero> tablero) {
        this.tablero = tablero;
    }
}
