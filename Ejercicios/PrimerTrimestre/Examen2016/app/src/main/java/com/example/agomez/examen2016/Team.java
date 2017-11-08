package com.example.agomez.examen2016;

/**
 * Created by agomez on 8/11/17.
 */

public class Team
{
    private int id;
    private String nombre;
    private int logo;

    public Team ()
    {
        this.id = 0;
        this.nombre = "";
        this.logo = 0;
    }

    public Team (int id, String nombre, int logo)
    {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
    }

    public int getId()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public int getLogo ()
    {
        return logo;
    }

    public void setLogo (int logo)
    {
        this.logo = logo;
    }
}
