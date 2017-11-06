package com.example.agomez.ejerciciospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
        private TextView texto;
        private static final String[] items={"hola", "soy", "pepejava",
                "he", "venido",
                "a", "dominaros", "a", "todos", ".", "Luis",
                "escrve", "crma"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto=(TextView)findViewById(R.id.texto);

        Spinner spin=(Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                items);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> parent,
                               View v, int position, long id) {
        texto.setText(items[position]);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        texto.setText("");
    }



}
