package com.iesnervion.agomez.examenantiguo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Jugador> jugadores;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador1", "posicion1", R.drawable.jugador1, 1.92, 82.3));
        jugadores.add(new Jugador("Jugador2", "posicion2", R.drawable.jugador2, 1.72, 52.3));
        jugadores.add(new Jugador("Jugador3", "posicion3", R.drawable.jugador1, 1.96, 82.3));
        jugadores.add(new Jugador("Jugador1", "posicion1", R.drawable.jugador1, 1.92, 82.3));
        jugadores.add(new Jugador("Jugador2", "posicion2", R.drawable.jugador2, 1.72, 52.3));
        jugadores.add(new Jugador("Jugador3", "posicion3", R.drawable.jugador1, 1.96, 82.3));
        jugadores.add(new Jugador("Jugador1", "posicion1", R.drawable.jugador1, 1.92, 82.3));
        jugadores.add(new Jugador("Jugador2", "posicion2", R.drawable.jugador2, 1.72, 52.3));
        jugadores.add(new Jugador("Jugador3", "posicion3", R.drawable.jugador1, 1.96, 82.3));


        lista = (ListView) findViewById(R.id.listView);
        JugadorAdapter adaptador = new JugadorAdapter(this, R.layout.row, jugadores);
        lista.setAdapter(adaptador);
    }

    public void clickAdd(View view)
    {
        Intent i = new Intent(getApplicationContext(), Info.class);
        startActivity(i);
    }
}
