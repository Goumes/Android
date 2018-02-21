package com.example.agomez.examen_final_alejandro_gomez.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by agomez on 21/02/18.
 */

@Entity(tableName = "futbolistas", indices = {@Index("id")})
public class Futbolista
{
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int id;
    private String nombre;
    private String apellido;
    private Posicion [] posiciones;
    //Leer la clase FutbolistaTypeConverter para mas informacion de por que no utilizo un ArrayList

    public Futbolista(String nombre, String apellido, Posicion [] posiciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posiciones = posiciones;
    }

    public Futbolista()
    {
        this.nombre = "pepe";
        this.apellido = "garcia";
        this.posiciones = new Posicion [10];
        this.posiciones[0] = new Posicion(" DEL ");
        //this.posiciones[0] = new Posicion(" DEL ");
        //this.posiciones[1] = new Posicion(" POR ");
        //this.posiciones[2] = new Posicion(" DEF ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Posicion [] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(Posicion [] posiciones) {
        this.posiciones = posiciones;
    }
}
