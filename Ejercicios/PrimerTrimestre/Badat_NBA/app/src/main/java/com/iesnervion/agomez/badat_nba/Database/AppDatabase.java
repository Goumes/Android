package com.iesnervion.agomez.badat_nba.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.iesnervion.agomez.badat_nba.DAO.MyDao;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;

/**
 * Created by aleja on 16/01/2018.
 */

@Database(entities = {Equipo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract MyDao equipoDao (); //No estoy seguro de esto

    private static AppDatabase INSTANCE;

    static AppDatabase getDatabase (final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (AppDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "equipo_database.db").build ();
                }
            }
        }
        return INSTANCE;
    }
}
