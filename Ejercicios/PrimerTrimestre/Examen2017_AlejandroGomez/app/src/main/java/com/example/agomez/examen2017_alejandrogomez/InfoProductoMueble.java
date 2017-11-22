package com.example.agomez.examen2017_alejandrogomez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoProductoMueble extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView txtNombre;
    TextView txtDescripcion;
    TextView txtPrecio;
    ImageView img;
    Intent i;
    ProductoMueble productoMueble;
    Spinner spinnerColores;
    ArrayList<String> colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_producto_mueble);

        i = getIntent();

        productoMueble = i.getParcelableExtra("productoMueble");


        txtNombre = findViewById(R.id.nombreInfo2);
        txtNombre.setText(productoMueble.getNombre());

        txtDescripcion = findViewById(R.id.descripcionInfo2);
        txtDescripcion.setText(productoMueble.getDescripcion());

        txtPrecio = findViewById(R.id.precioInfo2);
        txtPrecio.setText((String.valueOf(productoMueble.getPrecio())) + " Eur");

        img = findViewById(R.id.fotoInfo2);

        colores = new ArrayList<>();

        for (int i = 0; i < productoMueble.getColoresFotos().size(); i++)
        {
            colores.add(productoMueble.getColoresFotos().get(i).getColor());
        }

        spinnerColores=(Spinner)findViewById(R.id.spinnerColor2);
        spinnerColores.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa2=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, colores);

        aa2.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerColores.setAdapter(aa2);

    }

    public void onItemSelected(AdapterView<?> parent,
                               View v, int position, long id)
    {
        boolean encontrado = false;
        for (int i = 0; i < productoMueble.getColoresFotos().size() && !encontrado; i++) {
            if (spinnerColores.getSelectedItem().toString().equals(productoMueble.getColoresFotos().get(i).getColor())) {
                img.setImageResource(productoMueble.getColoresFotos().get(i).getFoto());
                encontrado = true;
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void btnAddCesta(View view)
    {
        Intent i = new Intent (InfoProductoMueble.this, cestaCompra.class);
        i.putExtra("productoMueble", productoMueble);
        i.putExtra("color", spinnerColores.getSelectedItem().toString());
        startActivity (i);
        finish();
    }
}
