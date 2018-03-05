package com.iesnervion.agomez.a2048.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.games.Player;
import com.iesnervion.agomez.a2048.R;

public class MainActivity extends AppCompatActivity {

    JuegoActivityViewModel mViewModel;
    Intent actual;
    Player jugador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actual = getIntent();
        jugador = actual.getParcelableExtra("jugador");


    }

    public void clickJugar(View view)
    {
        Intent i = new Intent (this, JuegoActivity.class);
        i.putExtra("jugador", jugador);
        //i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
    }

    public void clickPuntuaciones(View view)
    {
        Intent i = new Intent (this, PuntuacionesActivity.class);
        //i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
    }
}
