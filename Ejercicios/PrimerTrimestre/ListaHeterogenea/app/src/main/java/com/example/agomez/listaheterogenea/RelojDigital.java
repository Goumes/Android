package com.example.agomez.listaheterogenea;

/**
 * Created by agomez on 30/10/17.
 */

public class RelojDigital extends Reloj{
    private String fuenteDigito;

    public RelojDigital ()
    {
        super ();
        fuenteDigito = " ";
    }

    public RelojDigital (int id, String modelo, String marca, double precio, String fuenteDigito)
    {
        super (id, modelo, marca, precio);

        this.fuenteDigito = fuenteDigito;
    }

    public String getFuenteDigito ()
    {
        return fuenteDigito;
    }

    public void setFuenteDigito (String fuenteDigito)
    {
        this.fuenteDigito = fuenteDigito;
    }
}
