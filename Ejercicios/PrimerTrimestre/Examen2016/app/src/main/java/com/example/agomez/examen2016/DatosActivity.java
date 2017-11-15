package com.example.agomez.examen2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);
        Team team;

        textView = (TextView) findViewById(R.id.infoEquipo);
        imageView = (ImageView) findViewById(R.id.imgEquipo);

        intent = getIntent();
        team = intent.getParcelableExtra("equipo");

        textView.setText(team.getNombre());
        imageView.setImageResource(team.getLogo());


    }
}
