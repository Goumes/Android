package com.example.agomez.listaheterogenea;

/**
 * Created by agomez on 30/10/17.
 */

public class RelojAnalogico extends Reloj {
    private int longitudMinutero;

    public RelojAnalogico ()
    {
        super ();
        longitudMinutero = 0;
    }

    public RelojAnalogico (int id, String modelo, String marca, double precio, int longitudMinutero)
    {
        super (id, modelo, marca, longitudMinutero);
        this.longitudMinutero = longitudMinutero;
    }

    public int getLongitudMinutero ()
    {
        return longitudMinutero;
    }

    public void setLongitudMinutero (int longitudMinutero)
    {
        this.longitudMinutero = longitudMinutero;
    }
}
