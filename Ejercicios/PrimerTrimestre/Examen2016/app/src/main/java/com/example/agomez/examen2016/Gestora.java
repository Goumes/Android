package com.example.agomez.examen2016;

import java.util.ArrayList;

/**
 * Created by aleja on 08/11/2017.
 */

public class Gestora
{
    public boolean comprobarNombreEquipo (String nombreEquipo, ArrayList<Team> teams)
    {
        boolean resultado = false;

        for (int i = 0; i < teams.size() && resultado == false; i++)
        {
            if (teams.get(i).getNombre().equals(nombreEquipo)) resultado = true;
        }

        return resultado;
    }
}
