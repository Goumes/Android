package com.iesnervion.agomez.examenfinalaopasado.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.examenfinalaopasado.DAO.ContactDao;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;

/**
 * Created by aleja on 16/01/2018.
 */

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ContactDao contactDao (); //No estoy seguro de esto

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
