package com.iesnervion.agomez.a2048.Entities;

import android.widget.TextView;

/**
 * Created by aleja on 08/02/2018.
 */

public class Tablero
{
    private String[][] tabla;

    public Tablero()
    {
        this.tabla = new String[4][4];
    }

    public Tablero(String[][] tabla) {
        this.tabla = tabla;
    }

    public String[][] getTabla() {
        return tabla;
    }

    public void setTabla(String[][] tabla) {
        this.tabla = tabla;
    }

    public void rellenarTablero ()
    {
        String [][] tabla2 =  {
                            {String.valueOf(0), String.valueOf(2), String.valueOf(0), String.valueOf(2)},
                            {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(512)},
                            {String.valueOf(0), String.valueOf(0), String.valueOf(8), String.valueOf(0)},
                            {String.valueOf(0), String.valueOf(512), String.valueOf(0), String.valueOf(0)}
                            };
        /*
        for (int i = 0; i < this.tabla.length; i++)
        {

            for (int j = 0; j < this.tabla[0].length; j++)
            {
                if ((i == 0 && j == 0) || (i == 3 && j == 2))
                this.tabla[i][j] = 2;
            }
        }
        */

        this.tabla = tabla2;
    }
}