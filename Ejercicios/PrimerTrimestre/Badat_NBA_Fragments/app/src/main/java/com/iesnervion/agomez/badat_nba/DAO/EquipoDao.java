package com.iesnervion.agomez.badat_nba.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by aleja on 16/01/2018.
 */

@Dao
public interface EquipoDao
{
    @Query("SELECT * FROM equipos")
    public LiveData<List<Equipo>> cargarTodosEquipos (); //LiveData para que la UI cambie en el momento que esta lista cambie.

    @Insert(onConflict = REPLACE)
    void insertEquipo(Equipo equipo);

    @Query("DELETE FROM equipos")
    void deleteAll();
}
