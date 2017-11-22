package com.example.agomez.examen2017_alejandrogomez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class cestaCompra extends AppCompatActivity {

    ProductoMueble productoMueble;
    ProductoModa productoModa;
    String color;
    String talla;
    ListaProductos listaProductos;
    ListView miListView;
    ArrayList<Producto> productos;
    Intent i;
    ArrayList<ColoresTallas> coloresTallas;
    ArrayList<ColoresFotos> coloresFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cesta_compra);



        //listaProductos = new ListaProductos();
        //listaProductos.onCreate();

         i = getIntent();

        if (i.hasExtra("productoModa"))
        {
            productoModa = i.getParcelableExtra("productoModa");
            color = i.getStringExtra("color");
            talla = i.getStringExtra("talla");
            ListaProductos.getInstance().getProductos().add (productoModa);
        }

        else if (i.hasExtra("productoMueble"))
        {
            productoMueble = i.getParcelableExtra("productoMueble");
            color = i.getStringExtra("color");
            ListaProductos.getInstance().getProductos().add (productoMueble);
        }

        /* Aqui viene una prueba para comprobar que la lista heterogenea funciona perfectamente

        productos = new ArrayList<>();

        //Producto 1
        coloresTallas = new ArrayList<>();
        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.zapato_negro));
        coloresFotos.add(new ColoresFotos("Marron", R.drawable.zapato_marron));
        coloresFotos.add(new ColoresFotos("Gris", R.drawable.zapato_gris));
        coloresTallas.add(new ColoresTallas(37, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.zapato_negro));
        coloresFotos.add(new ColoresFotos("Gris", R.drawable.zapato_gris));
        coloresTallas.add(new ColoresTallas(42, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.zapato_negro));
        coloresTallas.add(new ColoresTallas(45, coloresFotos));

        productos.add(new ProductoModa("Zapato", 20.0, "Zapato de diversos colores", coloresTallas));

        //Item 2
        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Rojiza", R.drawable.mesa_rojiza));
        coloresFotos.add(new ColoresFotos("Beige", R.drawable.mesa_beige));
        productos.add(new ProductoMueble("Mesa", 100.20, "Mesa de distintos colores", coloresFotos));
        */

        miListView = findViewById(R.id.listView);

        Adapter adaptador = new Adapter(this, R.layout.row_moda, ListaProductos.getInstance().getProductos()/*productos*/);
        miListView.setAdapter(adaptador);

    }

    public void btnSeguirComprando(View view)
    {
        finish ();
    }
}
