package com.example.agomez.examen2017_alejandrogomez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoProductoModa extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView txtNombre;
    TextView txtDescripcion;
    TextView txtPrecio;
    ImageView img;
    Intent i;
    ProductoModa productoModa;
    Spinner spinnerTallas;
    Spinner spinnerColores;
    ArrayList<Integer> tallas;
    ArrayList<String> colores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_producto_moda);

        i = getIntent();

        productoModa = i.getParcelableExtra("productoModa");


        txtNombre = findViewById(R.id.nombreInfo);
        txtNombre.setText(productoModa.getNombre());

        txtDescripcion = findViewById(R.id.descripcionInfo);
        txtDescripcion.setText(productoModa.getDescripcion());

        txtPrecio = findViewById(R.id.precioInfo);
        txtPrecio.setText((String.valueOf(productoModa.getPrecio())) + " Eur");

        img = findViewById(R.id.fotoInfo);

        tallas = new ArrayList<>();
        colores = new ArrayList<>();

        tallas.add (productoModa.getColoresTallas().get(0).getTalla());
        for (int i = 0; i < productoModa.getColoresTallas().get(0).getColoresFotos().size(); i++) {
            colores.add(productoModa.getColoresTallas().get(0).getColoresFotos().get(i).getColor());
            img.setImageResource(productoModa.getColoresTallas().get(0).getColoresFotos().get(i).getFoto());
        }

        //Spinner tallas
        spinnerTallas=(Spinner)findViewById(R.id.spinnerTalla);

        ArrayAdapter<Integer> aa=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, tallas);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerTallas.setAdapter(aa);

        //Spinner colores
        spinnerColores=(Spinner)findViewById(R.id.spinnerColor);
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
        for (int i = 0; i < productoModa.getColoresTallas().get(0).getColoresFotos().size() && !encontrado; i++) {
            if (spinnerColores.getSelectedItem().toString().equals(productoModa.getColoresTallas().get(0).getColoresFotos().get(i).getColor())) {
                img.setImageResource(productoModa.getColoresTallas().get(0).getColoresFotos().get(i).getFoto());
                encontrado = true;
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void btnAddCesta(View view)
    {
        Intent i = new Intent (InfoProductoModa.this, cestaCompra.class);
        i.putExtra("productoModa", productoModa);
        i.putExtra("color", spinnerColores.getSelectedItem().toString());
        i.putExtra("talla", spinnerTallas.getSelectedItem().toString());
        startActivity (i);
        finish();
    }
}
