package com.iesnervion.agomez.a2048.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by aleja on 08/02/2018.
 */

@Entity(tableName = "tableros", indices = {@Index("id")})
public class Tablero
{
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "tabla")
    private String[][] tabla;

    public Tablero()
    {
        this.tabla = new String[4][4];
        this.id = 0;
    }

    public Tablero(String[][] tabla)
    {
        this.tabla = new String[tabla.length][tabla[0].length];
        for (int i = 0; i < tabla.length; i++)
        {
            for (int j = 0; j < tabla[0].length; j++)
            {
                this.tabla[i][j] = tabla[i][j];
            }
        }
    }

    public String[][] getTabla() {
        return tabla;
    }

    public void setTabla(String[][] tabla) {
        this.tabla = tabla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = true;

        if (obj != null && obj instanceof  Tablero)
        {
            Tablero tablero = (Tablero) obj;

            if ((tablero.getTabla().length == this.getTabla().length) && (tablero.getTabla()[0].length == this.getTabla()[0].length))
            {
                for (int i = 0; i < tablero.getTabla().length && resultado; i++)
                {
                    for (int j = 0; j < tablero.getTabla()[0].length && resultado; j++)
                    {
                        if (!tablero.getTabla()[i][j].equals(this.getTabla()[i][j]))
                        {
                            resultado = false;
                        }
                    }
                }
            }
        }

        return resultado;
    }

    public void rellenarTablero ()
    {
        String [][] tabla =  {
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)},
                {String.valueOf(0), String.valueOf(0), String.valueOf(0), String.valueOf(0)}
        };

        Random random = new Random();
        int numeroAleatorio = 0;
        int contador = 0;
        boolean generar = false;

        for (int i = 0; i < tabla.length && contador < 2; i++)
        {
            for (int j = 0; j <tabla[0].length && contador < 2; j++)
            {
                generar = Math.random() < 0.3;

                if (tabla[i][j].equals("0") && generar)
                {
                    numeroAleatorio = (Math.random() >= .9 ? 4 : 2); //Crea un aleatorio ya sea 2 o 4 con un 90% de probabilidad de que sea un 2
                    tabla[i][j] = String.valueOf(numeroAleatorio);
                    contador++;
                }

                if (i == 3 && j == 3 && contador < 2)
                {
                    i = 0;
                    j = 0;
                }
            }
        }

        this.tabla = tabla;
    }
}