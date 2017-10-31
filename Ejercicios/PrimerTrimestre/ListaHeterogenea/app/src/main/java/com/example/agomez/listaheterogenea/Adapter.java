package com.example.agomez.listaheterogenea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by agomez on 30/10/17.
 */

public class Adapter extends ArrayAdapter <Reloj>
{
    private ArrayList<Reloj> relojes;

    public Adapter (Context context, int resource, ArrayList <Reloj> relojes)
    {
        super(context, resource, relojes);
        this.relojes = relojes;
    }

    @Override
    public int getItemViewType (int position)
    {
        int resultado = 0;

        if (getItem(position) instanceof RelojDigital)
        {
            resultado = 0;
        }

        else if (getItem(position) instanceof RelojAnalogico)
        {
            resultado = 1;
        }

        return resultado;
    }

    @Override
    public int getViewTypeCount()
    {
        return 2;
    }

    public View getView (int posicion, View convertView, ViewGroup parent)
    {
        View vista;
        ViewHolderDigital viewHolder = null;
        ViewHolderAnalogico viewHolder2 = null;

        vista = convertView;


        if (vista == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(getItemViewType(posicion) == 0)
            {
                vista = inflater.inflate(R.layout.row_digital, null, true);//super.getView(posicion,view,parent);
                viewHolder = new ViewHolderDigital (vista);
                vista.setTag(viewHolder);
            }

            else if (getItemViewType(posicion) == 1)
            {
                vista = inflater.inflate(R.layout.row_analogico, null, true);//super.getView(posicion,view,parent);
                viewHolder2 = new ViewHolderAnalogico (vista);
                vista.setTag(viewHolder2);
            }

        }

        else
        {
            if (getItemViewType(posicion) == 0) {
                viewHolder = (ViewHolderDigital) vista.getTag();
            }

            else if (getItemViewType(posicion) == 1)
            {
                viewHolder2 = (ViewHolderAnalogico) vista.getTag();
            }

        }



        if (getItemViewType(posicion) == 0)
        {
            RelojDigital reloj = (RelojDigital) relojes.get(posicion);
            TextView txtModelo = viewHolder.getModelo();
            TextView txtMarca = viewHolder.getMarca();
            TextView txtPrecio = viewHolder.getPrecioprecio();
            TextView txtFuente = viewHolder.getFuenteDigito();
            ImageView imgReloj = viewHolder.getPreview();

            txtModelo.setText(reloj.getModelo());
            txtMarca.setText(reloj.getMarca());
            txtPrecio.setText(String.valueOf(reloj.getPrecio()));
            txtFuente.setText(reloj.getFuenteDigito());
            imgReloj.setImageResource(R.drawable.reloj_digital_1);
        }

        else if (getItemViewType(posicion) == 1)
        {
            RelojAnalogico reloj = (RelojAnalogico) relojes.get(posicion);
            TextView txtModelo = viewHolder2.getModelo();
            TextView txtMarca = viewHolder2.getMarca();
            TextView txtPrecio = viewHolder2.getPrecioprecio();
            TextView txtMinutero = viewHolder2.getLongitudMinutero();
            ImageView imgReloj = viewHolder2.getPreview();

            txtModelo.setText(reloj.getModelo());
            txtMarca.setText(reloj.getMarca());
            txtPrecio.setText(String.valueOf(reloj.getPrecio()));
            txtMinutero.setText(reloj.getLongitudMinutero());
            imgReloj.setImageResource(R.drawable.reloj_analogico_1);
        }

        //TextView txtMinutero = viewHolder2.getLongitudMinutero();



        //txtFuente.setText(relojes.get(posicion).getFuenteDigito());



        return (vista);
    }
}
