package com.example.agomez.listaheterogenea;

/**
 * Created by agomez on 30/10/17.
 */

public class Reloj {
    private int id;
    private String modelo;
    private String marca;
    private double precio;

    public Reloj ()
    {
        this.id = 0;
        this.modelo = " ";
        this.marca = " ";
        this.precio = 0.0;
    }

    public Reloj (int id, String modelo, String marca, double precio)
    {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getModelo ()
    {
        return modelo;
    }

    public void setModelo (String modelo)
    {
        this.modelo = modelo;
    }

    public String getMarca ()
    {
        return marca;
    }

    public void setMarca (String marca)
    {
        this.marca = marca;
    }

    public double getPrecio ()
    {
        return precio;
    }

    public void setPrecio (double precio)
    {
        this.precio = precio;
    }
}
