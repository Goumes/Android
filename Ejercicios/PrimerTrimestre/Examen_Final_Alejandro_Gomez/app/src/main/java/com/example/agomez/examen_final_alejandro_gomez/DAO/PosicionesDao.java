package com.example.agomez.examen_final_alejandro_gomez.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by agomez on 21/02/18.
 */

@Dao
public interface PosicionesDao
{
    @Query("SELECT * FROM posiciones")
    public LiveData<List<Posicion>> cargarTodasPosiciones ();

    @Insert(onConflict = REPLACE)
    void insertPosicion(Posicion posicion);

    @Query("DELETE FROM posiciones")
    void deleteAll();
}
