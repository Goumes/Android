package com.iesnervion.agomez.badat_nba.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;

import java.util.ArrayList;

/**
 * Created by aleja on 16/01/2018.
 */

@Dao
public interface MyDao
{
    @Query("SELECT * FROM equipos")
    public ArrayList<Equipo> cargarTodosEquipos ();
}
