package com.iesnervion.agomez.badat_nba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Adapter adaptador;
    ArrayList<Equipo> equipos;
    Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equipos = new ArrayList<>();

        //Simplemente rellenar este array desde la base de datos para completar el ejercicio

        equipos.add(new Equipo("Los Angeles Lakers", 1946, "Púrpura", "Oro","#5c2f83" , "#Fcb625",  "Magic Johnson", "Luke Walton", "Staples Center", "Los Angeles, California", R.drawable.lakers));
        equipos.add(new Equipo("Los Angeles Clippers", 1970, "Rojo", "Azul","#ED174C" , "#006BB6",  "Steve Ballmer", "Doc Rivers", "Staples Center", "Los Angeles, California", R.drawable.clippers));

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
