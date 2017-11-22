package com.iesnervion.agomez.examenantiguo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    TextView txtNombre;
    RadioButton radioSelected;
    RadioGroup group;
    int id;
    Spinner spinnerAltura;
    Spinner spinnerPeso;
    Double [] alturas;
    Double [] pesos;
    Jugador jugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_jugador);

        /*
        alturas = new Double[15];
        pesos = new Double[15];

        for (int i = 70; i<alturas.length;i++)
        {
            alturas[i] = (i + 0.5);
        }


        spinnerAltura = findViewById(R.id.SpinnerAltura);

        ArrayAdapter<Double> aa=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                alturas);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerAltura.setAdapter(aa);

        spinnerPeso = findViewById(R.id.SpinnerAltura);

        ArrayAdapter<Double> aa2=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                pesos);

        aa2.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerPeso.setAdapter(aa);

        txtNombre = findViewById(R.id.textInfoNombre);
        group = findViewById(R.id.radioGroup);
        id = group.getCheckedRadioButtonId();
        radioSelected = group.findViewById(id);



        Intent i = getIntent();

        jugador = new Jugador (txtNombre.getText().toString(), radioSelected.getText().toString(), R.drawable.jugador1, 0.0, 0.0);

        i.putExtra("jugador", jugador);
        setResult(MainActivity.RESULT_OK, i);
        finish();

        */

    }
}
