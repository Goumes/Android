package com.example.agomez.examen_final_alejandro_gomez.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.agomez.examen_final_alejandro_gomez.DAO.FutbolistaDao;
import com.example.agomez.examen_final_alejandro_gomez.DAO.PosicionesDao;
import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;
import com.example.agomez.examen_final_alejandro_gomez.TypeConverters.FutbolistaTypeConverter;

/**
 * Created by aleja on 16/01/2018.
 */

@Database(entities = {Futbolista.class, Posicion.class}, version = 1)
@TypeConverters({FutbolistaTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase
{
    public abstract FutbolistaDao futbolistaDao ();

    public abstract PosicionesDao posicionesDao ();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase (final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (AppDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "equipo_database.db")
                            //.allowMainThreadQueries() //Esto es para que se puedan hacer querys desde el main
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    DatabaseInitializer.populateAsync(INSTANCE);//Simplemente esta para hacer pruebas
                                }
                            })
                            .build ();
                }
            }
        }
        return INSTANCE;
    }
}
