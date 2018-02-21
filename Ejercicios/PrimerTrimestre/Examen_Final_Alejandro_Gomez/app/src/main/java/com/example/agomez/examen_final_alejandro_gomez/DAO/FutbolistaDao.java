package com.example.agomez.examen_final_alejandro_gomez.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by agomez on 21/02/18.
 */

@Dao
public interface FutbolistaDao
{
    @Query("SELECT * FROM futbolistas")
    public LiveData<List<Futbolista>> cargarTodosFutbolistas ();

    @Insert(onConflict = REPLACE)
    void insertFutbolista(Futbolista futbolista);

    @Query("DELETE FROM futbolistas")
    void deleteAll();
}
