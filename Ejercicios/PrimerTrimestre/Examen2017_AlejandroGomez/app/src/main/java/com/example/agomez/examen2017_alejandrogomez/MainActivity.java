package com.example.agomez.examen2017_alejandrogomez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Spinner spinnerProductos;
    ArrayList<String> nombresProductos;
    ListaProductos listaProductos;
    ArrayList<Producto> productos;
    ArrayList<ColoresTallas> coloresTallas;
    ArrayList<ColoresFotos> coloresFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos la listaProductos con el patron singleton
        listaProductos = new ListaProductos();
        listaProductos.onCreate();


        productos = new ArrayList<Producto> ();

        //Item 1
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
        coloresTallas = new ArrayList<>();
        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.pantalon_negro));
        coloresFotos.add(new ColoresFotos("Caqui", R.drawable.pantalon_caqui));
        coloresFotos.add(new ColoresFotos("Beige", R.drawable.pantalon_beige));
        coloresTallas.add(new ColoresTallas(37, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.pantalon_negro));
        coloresFotos.add(new ColoresFotos("Caqui", R.drawable.pantalon_caqui));
        coloresTallas.add(new ColoresTallas(42, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Beige", R.drawable.pantalon_beige));
        coloresTallas.add(new ColoresTallas(45, coloresFotos));

        productos.add(new ProductoModa("Pantalon", 30.0, "Pantalon de diversos colores", coloresTallas));

        //Item 3
        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Rojiza", R.drawable.mesa_rojiza));
        coloresFotos.add(new ColoresFotos("Beige", R.drawable.mesa_beige));
        productos.add(new ProductoMueble("Mesa", 100.20, "Mesa de distintos colores", coloresFotos));

        //Item 4
        coloresTallas = new ArrayList<>();
        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Negro", R.drawable.camiseta_negra));
        coloresFotos.add(new ColoresFotos("Marron", R.drawable.camiseta_marron));
        coloresFotos.add(new ColoresFotos("Rojo", R.drawable.camiseta_roja));
        coloresTallas.add(new ColoresTallas(37, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Rojo", R.drawable.camiseta_roja));
        coloresFotos.add(new ColoresFotos("Marron", R.drawable.camiseta_marron));
        coloresTallas.add(new ColoresTallas(42, coloresFotos));

        coloresFotos = new ArrayList<>();
        coloresFotos.add(new ColoresFotos("Marron", R.drawable.camiseta_marron));
        coloresTallas.add(new ColoresTallas(45, coloresFotos));

        productos.add(new ProductoModa("Camiseta", 15.0, "Zapato de diversos colores", coloresTallas));

        //Insertamos la lista de productos en la clase que extiende de Application
        //listaProductos.setProductos(productos);

        //Busqueda del spinner y creacion
        nombresProductos = getNombresProductos();
        spinnerProductos=(Spinner)findViewById(R.id.spinnerProductos);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nombresProductos);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerProductos.setAdapter(aa);



    }

    //Metodo dedicado a rellenar el array de String del Spinner con los nombres de los productos.
    public ArrayList<String> getNombresProductos ()
    {
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < productos.size();i++) {
            lista.add(productos.get(i).getNombre());
        }

        return lista;
    }

    //Metodo on click que compara y busca en el contenido del spinner con los objetos producto para recoger el objeto deseado y mandarlo con el intent a la actividad.
    public void clicVerProducto(View view)
    {
        boolean moda = false;
        boolean mueble = false;
        ProductoModa productoModa = null;
        ProductoMueble productoMueble = null;

        for (int i = 0; i < nombresProductos.size();i++)
        {
            if (spinnerProductos.getSelectedItem().toString() == nombresProductos.get(i).toString())
            {
                for (int j = 0; j < productos.size(); j++) {
                    if (productos.get(j).getNombre() == spinnerProductos.getSelectedItem().toString() )
                    {
                        if (productos.get(j) instanceof ProductoModa)
                        {
                            moda = true;
                            productoModa = (ProductoModa) productos.get(j);
                        }

                        else
                        {
                            mueble = true;
                            productoMueble = (ProductoMueble) productos.get(j);
                        }
                    }
                }
            }
        }



        if (moda) {
            Intent i = new Intent(MainActivity.this, InfoProductoModa.class);
            i.putExtra("productoModa", productoModa);
            startActivity(i);
        }

        else if (mueble)
        {
            Intent i = new Intent(MainActivity.this, InfoProductoMueble.class);
            i.putExtra("productoMueble", productoMueble);
            startActivity(i);
        }
    }
}
