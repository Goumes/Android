package com.iesnervion.agomez.a2048.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.iesnervion.agomez.a2048.Entities.Tablero;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by aleja on 10/02/2018.
 */

@Dao
public interface TableroDAO
{
    @Query("SELECT * FROM tableros")
    public LiveData<Tablero> cargarTablero (); //LiveData para que la UI cambie en el momento que esta lista cambie.

    @Insert(onConflict = REPLACE)
    void insertTablero(Tablero tablero);

    @Query("DELETE FROM tableros")
    void deleteAll();


    /*
    @Query("UPDATE tableros SET tabla = :tabla WHERE id = :id")
    void updateTablero (String [][] tabla, int id);
    */
    @Update
    void updateTablero (Tablero tablero);
}
