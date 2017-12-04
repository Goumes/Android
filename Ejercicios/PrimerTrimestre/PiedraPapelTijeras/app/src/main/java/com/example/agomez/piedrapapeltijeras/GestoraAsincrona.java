package com.example.agomez.piedrapapeltijeras;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by aleja on 04/12/2017.
 */

public class GestoraAsincrona extends AsyncTask <Void, Void, Void> // El primer parametro es el tipo que recibe el doInBackground, el segundo el Progress y el tercero el onPostExecute
{

    private ImageView imagen;
    private TextView texto;
    private long tiempo;
    private int id;
    private String cadena;

    public GestoraAsincrona ()
    {
        this.imagen = null;
        this.texto = null;
        this.tiempo = 0;
        this.id = 0;
        this.cadena = "";
    }

    public GestoraAsincrona (ImageView imagen, int id, long tiempo)
    {
        this.imagen = imagen;
        this.tiempo = tiempo;
        this.id = id;
        this.texto = null;
        this.cadena = null;
    }

    public GestoraAsincrona (TextView texto, String cadena, long tiempo)
    {
        this.texto = texto;
        this.tiempo = tiempo;
        this.imagen = null;
        this.id = 0;
        this.cadena = cadena;
    }


    @Override
    protected Void doInBackground(Void... voids)
    {
        try
        {
            Thread.sleep(this.tiempo);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        //super.onPostExecute(aVoid);
        if (this.imagen == null)
        {
            texto.setText(cadena);
        }

        else if (this.texto == null)
        {
            imagen.setImageResource(this.id);
        }

    }


    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
        this.texto = null;
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
        this.imagen = null;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
