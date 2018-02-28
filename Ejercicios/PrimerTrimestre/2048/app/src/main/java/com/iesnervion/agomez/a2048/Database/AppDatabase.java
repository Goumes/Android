package com.iesnervion.agomez.a2048.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.a2048.Converters.TableroConverter;
import com.iesnervion.agomez.a2048.DAO.TableroDAO;
import com.iesnervion.agomez.a2048.Entities.Tablero;

/**
 * Created by aleja on 16/01/2018.
 */

@Database(entities = {Tablero.class}, version = 1)
@TypeConverters({TableroConverter.class})
public abstract class AppDatabase extends RoomDatabase
{
    public abstract TableroDAO tableroDAO ();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase (final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (AppDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "tablero_database.db")
                            //.allowMainThreadQueries() //Esto es para que se puedan hacer querys desde el main
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    DatabaseInitializer.populateAsync(INSTANCE);
                                }
                            })
                            .build ();
                }
            }
        }
        return INSTANCE;
    }
}
