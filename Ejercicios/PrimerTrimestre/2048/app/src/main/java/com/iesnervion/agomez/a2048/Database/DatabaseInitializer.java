package com.iesnervion.agomez.a2048.Database;

/**
 * Created by aleja on 21/01/2018.
 */

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.a2048.Entities.Tablero;
import com.iesnervion.agomez.a2048.R;

import java.util.Random;

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Tablero addTablero(AppDatabase db, int id, String [][] tabla) {
        Tablero tablero = new Tablero();
        tablero.setId(id);
        tablero.setTabla(tabla);
        db.tableroDAO().insertTablero(tablero);
        return tablero;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.tableroDAO().deleteAll ();

        /*
        String [][] tabla =  {
                {String.valueOf(0), String.valueOf(2), String.valueOf(64), String.valueOf(512)},
                {String.valueOf(8), String.valueOf(4), String.valueOf(32), String.valueOf(8)},
                {String.valueOf(4), String.valueOf(8), String.valueOf(128), String.valueOf(16)},
                {String.valueOf(2), String.valueOf(16), String.valueOf(256), String.valueOf(2)}
        };
        */

        String [][] tabla =  {
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)}
        };

        Random random = new Random();
        int numeroAleatorio = 0;
        int contador = 0;
        boolean generar = false;



        for (int i = 0; i < tabla.length && contador < 2; i++)
        {
            for (int j = 0; j <tabla[0].length && contador < 2; j++)
            {
                generar = Math.random() < 0.3;

                if (tabla[i][j].equals("0") && generar)
                {
                    numeroAleatorio = (Math.random() >= .9 ? 4 : 2); //Crea un aleatorio ya sea 2 o 4 con un 90% de probabilidad de que sea un 2
                    tabla[i][j] = String.valueOf(numeroAleatorio);
                    contador++;
                }

                if (i == 3 && j == 3 && contador < 2)
                {
                    i = 0;
                    j = 0;
                }
            }
        }


        addTablero(db, 0, tabla);

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}