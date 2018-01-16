package com.iesnervion.agomez.badat_nba.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesnervion.agomez.badat_nba.Adapter.Adapter;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Adapter adaptador;
    ArrayList<Equipo> equipos;
    Intent myIntent;
    Bitmap icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equipos = new ArrayList<>();

        //Simplemente rellenar este array desde la base de datos para completar el ejercicio
        icon = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.lakers);
        equipos.add(new Equipo("Los Angeles Lakers", 1946, "Púrpura", "Oro","#5c2f83" , "#Fcb625",  "Magic Johnson", "Luke Walton", "Staples Center", "Los Angeles, California", icon));
        icon = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.clippers);
        equipos.add(new Equipo("Los Angeles Clippers", 1970, "Rojo", "Azul","#ED174C" , "#006BB6",  "Steve Ballmer", "Doc Rivers", "Staples Center", "Los Angeles, California", icon));
        icon = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.hornets);
        equipos.add(new Equipo("Charlotte Hornets", 1970, "Celeste", "Azul","#008CA8" , "#1D1160",  "Michael Jordan", "Steve Clifford", "Spectrum Center", " \tCharlotte, Carolina del Norte", icon));

        lista = (ListView) findViewById(R.id.lista);
        adaptador = new Adapter(this,R.layout.row_equipo, equipos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                myIntent = new Intent(MainActivity.this, DatosActivity.class);
                myIntent.putExtra("equipo", equipos.get(position));
                startActivity (myIntent);
            }
        });
    }
}