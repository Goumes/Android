package com.example.agomez.examen2017_alejandrogomez;

import android.app.Application;
import android.content.res.Configuration;

import java.util.ArrayList;

/**
 * Created by agomez on 22/11/17.
 */

public class ListaProductos extends Application {
    private ArrayList<Producto> productos;
    private static ListaProductos singleton;

    public ListaProductos ()
    {
        this.productos = new ArrayList<>();
    }

    public ListaProductos (ArrayList<Producto> productos)
    {
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos ()
    {
        return productos;
    }

    public void setProductos (ArrayList<Producto> productos)
    {
        this.productos = productos;
    }



    public static ListaProductos getInstance() {
        return singleton;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
