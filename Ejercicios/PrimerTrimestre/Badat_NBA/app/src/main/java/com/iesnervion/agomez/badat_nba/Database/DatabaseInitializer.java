package com.iesnervion.agomez.badat_nba.Database;

/**
 * Created by aleja on 21/01/2018.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

import java.util.Calendar;
import java.util.Date;

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:
    private static Bitmap icon;
    private static Context context;

    public DatabaseInitializer (Context context) //Hago esto para poder pasar el contexto y asi utilizar el getResources.
    {
        this.context = context;
    }

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Equipo addEquipo(final AppDatabase db, final String nombre, final int fundacion, final String color1, final String color2, final String color1Hex, final String color2Hex, final String presidente, final String entrenador,
                                    final String estadio, final String ubicacion, final Bitmap logo) {
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

        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.lakers);
        addEquipo(db, "Los Angeles Lakers", 1946, "Púrpura", "Oro","#5c2f83" , "#Fcb625",  "Magic Johnson", "Luke Walton", "Staples Center", "Los Angeles, California", icon);

        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.clippers);
        addEquipo(db,"Los Angeles Clippers", 1970, "Rojo", "Azul","#ED174C" , "#006BB6",  "Steve Ballmer", "Doc Rivers", "Staples Center", "Los Angeles, California", icon);

        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.hornets);
        addEquipo(db,"Charlotte Hornets", 1970, "Celeste", "Azul","#008CA8" , "#1D1160",  "Michael Jordan", "Steve Clifford", "Spectrum Center", " \tCharlotte, Carolina del Norte", icon);

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