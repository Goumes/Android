package com.example.agomez.examen_final_alejandro_gomez.Database;

/**
 * Created by aleja on 21/01/2018.
 */

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Futbolista addFutbolista(AppDatabase db, String nombre, String apellido, Posicion [] posiciones) {
        Futbolista futbolista = new Futbolista();
        futbolista.setNombre(nombre);
        futbolista.setApellido(apellido);
        futbolista.setPosiciones(posiciones);
        db.futbolistaDao().insertFutbolista(futbolista);
        return futbolista;
    }

    private static Posicion addPosicion(AppDatabase db, String nombre) {
        Posicion posicion = new Posicion();
        posicion.setNombre(nombre);
        db.posicionesDao().insertPosicion(posicion);
        return posicion;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.futbolistaDao().deleteAll();
        db.posicionesDao().deleteAll();
        Posicion [] posiciones = new Posicion[10];
        posiciones[0] = new Posicion(" DEL ");
        posiciones[1] = new Posicion(" POR ");
        posiciones[2] = new Posicion(" DEF ");

        addPosicion(db, "DEL");
        addPosicion(db, "POR");
        addPosicion(db, "DEF");

        addFutbolista(db, "nombre", "apellido", posiciones);
        addFutbolista(db, "nombre2", "apellido2", posiciones);
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