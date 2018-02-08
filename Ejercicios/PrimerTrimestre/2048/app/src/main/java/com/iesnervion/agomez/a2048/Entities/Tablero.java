package com.iesnervion.agomez.a2048.Entities;

import android.widget.TextView;

/**
 * Created by aleja on 08/02/2018.
 */

public class Tablero
{
    private int[][] tabla;

    public Tablero()
    {
        this.tabla = new int[4][4];
    }

    public Tablero(int[][] tabla) {
        this.tabla = tabla;
    }

    public int[][] getTabla() {
        return tabla;
    }

    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }
}
