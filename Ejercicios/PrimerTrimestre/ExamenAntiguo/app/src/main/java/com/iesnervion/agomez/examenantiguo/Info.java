package com.iesnervion.agomez.examenantiguo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_jugador);

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

        i.putExtra("nombre", txtNombre.getText().toString());
        i.putExtra("posicion", radioSelected.getText().toString());
    }
}
