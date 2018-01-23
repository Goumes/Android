package com.iesnervion.agomez.badat_nba.Database;

/**
 * Created by aleja on 21/01/2018.
 */

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Equipo addEquipo(AppDatabase db, String nombre, int fundacion, String color1, String color2, String color1Hex, String color2Hex, String presidente, String entrenador,
                                    String estadio, String ubicacion, int logo) {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setFundacion(fundacion);
        equipo.setColor1(color1);
        equipo.setColor2(color2);
        equipo.setColor1Hex(color1Hex);
        equipo.setColor2Hex(color2Hex);
        equipo.setPresidente(presidente);
        equipo.setEntrenador(entrenador);
        equipo.setEstadio(estadio);
        equipo.setUbicacion(ubicacion);
        equipo.setLogo(logo);
        db.equipoDao().insertEquipo(equipo);
        return equipo;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.equipoDao().deleteAll();

        addEquipo(db, "Los Angeles Lakers", 1946, "Púrpura", "Oro","#5c2f83" , "#Fcb625",  "Magic Johnson", "Luke Walton", "Staples Center", "Los Angeles, California", R.drawable.lakers);

        addEquipo(db,"Los Angeles Clippers", 1970, "Rojo", "Azul","#ED174C" , "#006BB6",  "Steve Ballmer", "Doc Rivers", "Staples Center", "Los Angeles, California", R.drawable.clippers);

        addEquipo(db,"Charlotte Hornets", 1970, "Celeste", "Azul","#008CA8" , "#1D1160",  "Michael Jordan", "Steve Clifford", "Spectrum Center", "Charlotte, Carolina del Norte", R.drawable.hornets);

        addEquipo(db,"Boston Celtics", 1946, "Verde", "Blanco","#008040" , "#ffffff",  "Danny Ainge", "Brad Stevens", "TD Garden", "Boston, Massachusetts", R.drawable.celtics);


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