package com.iesnervion.agomez.a2048.Activities;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.iesnervion.agomez.a2048.R;

public class MainActivity extends AppCompatActivity {

    JuegoActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickJugar(View view)
    {
        Intent i = new Intent (this, JuegoActivity.class);
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
