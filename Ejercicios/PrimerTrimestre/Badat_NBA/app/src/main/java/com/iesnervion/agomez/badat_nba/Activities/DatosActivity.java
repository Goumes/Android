package com.iesnervion.agomez.badat_nba.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

public class DatosActivity extends AppCompatActivity {

    TextView nombre;
    TextView fundacion;
    TextView colores;
    TextView propietario;
    TextView entrenador;
    TextView estadio;
    TextView ubicacion;
    ImageView logo;

    Equipo equipo;
    Intent intent;

    View rectangulo;
    View rectanguloDatos;
    View rectanguloInstalaciones;

    TextView instalaciones;
    TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_equipo);

        intent = getIntent();

        equipo = intent.getParcelableExtra("equipo");

        nombre = findViewById(R.id.nombre_equipo);
        fundacion = findViewById(R.id.fundacion_txt);
        colores = findViewById(R.id.colores_txt);
        propietario = findViewById(R.id.presidente_txt);
        entrenador = findViewById(R.id.entrenador_txt);
        estadio = findViewById(R.id.estadio_txt);
        ubicacion = findViewById(R.id.ubicacion_txt);
        logo = findViewById(R.id.logo);
        rectangulo = findViewById(R.id.rectangulo);
        rectanguloDatos = findViewById(R.id.rectangulo_datos);
        rectanguloInstalaciones = findViewById(R.id.rectangulo_instalaciones);
        instalaciones = findViewById(R.id.instalaciones);
        datos = findViewById(R.id.datos);

        nombre.setText(equipo.getNombre());
        fundacion.setText(String.valueOf(equipo.getFundacion()));
        colores.setText(equipo.getColor1() + " y "+equipo.getColor2());
        propietario.setText(equipo.getPresidente());
        entrenador.setText(equipo.getEntrenador());
        estadio.setText(equipo.getEstadio());
        ubicacion.setText(equipo.getUbicacion());
        logo.setImageResource(equipo.getLogo());

        rectangulo.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));
        rectanguloDatos.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));
        rectanguloInstalaciones.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));

        nombre.setTextColor(Color.parseColor(equipo.getColor2Hex()));
        datos.setTextColor(Color.parseColor(equipo.getColor2Hex()));
        instalaciones.setTextColor(Color.parseColor(equipo.getColor2Hex()));


        //Cambiar el color de la barra de notificaciones
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(equipo.getColor1Hex()));
        }


    }
}
