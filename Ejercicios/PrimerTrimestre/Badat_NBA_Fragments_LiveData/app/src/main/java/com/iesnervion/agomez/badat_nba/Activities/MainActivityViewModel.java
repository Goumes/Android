package com.iesnervion.agomez.badat_nba.Activities;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.iesnervion.agomez.badat_nba.Database.AppDatabase;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Repositories.EquipoRepository;

import java.util.List;

/**
 * Created by agomez on 23/01/18.
 */

public class MainActivityViewModel extends AndroidViewModel //Si no se usa application, esto extiende de ViewModel, no de AndroidViewModel
{
    private LiveData<List<Equipo>> equipos;

    private AppDatabase mDb;

    private EquipoRepository mRepositorio;

    private MutableLiveData<Equipo> equipoSeleccionado;

    public MainActivityViewModel(Application application) {
        super(application);
        //createDb();

        mRepositorio = new EquipoRepository(application);

        // equipos is a LiveData object so updates are observed.
        equipos = mRepositorio.getEquipos ();
        equipoSeleccionado = new MutableLiveData<Equipo>();
    }

    public void createDb() {
        mDb = AppDatabase.getDatabase(this.getApplication());

        // Populate it with initial data
        //DatabaseInitializer.populateAsync(mDb);
    }

    public LiveData<List<Equipo>> getEquipos ()
    {
        return equipos;
    }

    public void setEquipos (LiveData<List<Equipo>> equipos)
    {
        this.equipos = equipos;
    }

    public LiveData<Equipo> getEquipoSeleccionado ()
    {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado (Equipo equipo)
    {
        this.equipoSeleccionado.setValue(equipo);
        //this.equipoSeleccionado = equipoSeleccionado;
    }
}
