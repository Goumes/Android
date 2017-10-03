package com.iesnervion.agomez.ejercicio5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int size = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiarTamano(View view)
    {
        int id = view.getId();
        EditText texto = (EditText) findViewById(R.id.texto);

        switch (id)
        {
            case R.id.boton1:
                size--;
                texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
                break;

            case R.id.boton2:
                size++;
                texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
                break;

        }
    }
}
