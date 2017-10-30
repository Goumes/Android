package com.example.agomez.listviewprueba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 18/10/17.
 */

public class Adaptador extends ArrayAdapter <String>
{
    private final Activity actividad;
    private final String [] nombres;
    private final Integer [] imagenes;

    public Adaptador (Activity actividad, String [] nombres, Integer [] imagenes)
    {
        super(actividad, R.layout.row, nombres);
        this.actividad = actividad;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    public View getView (int posicion, View view, ViewGroup parent)
    {
        View vista = view;//super.getView(posicion,view,parent);

        if (vista == null)
        {
            LayoutInflater inflater = actividad.getLayoutInflater();
        }


        ViewHolder viewHolder;
        //En el null se le pasa la id de otro linear layout del que es hijo el layout a usar. En este caso no es ninguno.
        //El true o false sirve para indicar si queremos que se usen las propiedades del padre. False sólo coge las propiedades
        //y true mete el objeto entero dentro del padre.

        TextView txtView = (TextView) vista.findViewById(R.id.texto);
        ImageView imgView = (ImageView) vista.findViewById(R.id.imagen);

        txtView.setText(nombres[posicion]);
        imgView.setImageResource(imagenes[posicion]);

        return vista;
        }
}
