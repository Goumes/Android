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

    public View getView (int position, View convertView, ViewGroup parent)
    {
        View vista = convertView;
        ViewHolderDigital viewHolder = null;
        ViewHolderAnalogico viewHolder2 = null;
        int tipo = getItemViewType(position);

        switch (tipo)
        {
            case 0:

                if (vista == null)
                {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    vista = inflater.inflate(R.layout.row_digital, null);
                    viewHolder = (ViewHolderDigital) vista.getTag();
                    vista.setTag(viewHolder);
                }

                else
                {
                    viewHolder = (ViewHolderDigital) vista.getTag();
                }

                RelojDigital relojD = (RelojDigital) getItem(position);

                if (relojD != null)
                {
                    TextView txtModelo = viewHolder.getModelo();
                    TextView txtMarca = viewHolder.getMarca();
                    TextView txtPrecio = viewHolder.getPrecioprecio();
                    TextView txtFuente = viewHolder.getFuenteDigito();
                    ImageView imgReloj = viewHolder.getPreview();

                    txtModelo.setText(relojD.getModelo());
                    txtMarca.setText(relojD.getMarca());
                    txtPrecio.setText(String.valueOf(relojD.getPrecio()));
                    txtFuente.setText(relojD.getFuenteDigito());
                    imgReloj.setImageResource(R.drawable.reloj_digital_1);
                }

                break;
            case 1:

                if (vista == null)
                {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    vista = inflater.inflate(R.layout.row_analogico, null);
                    viewHolder2 = (ViewHolderAnalogico) vista.getTag();
                    vista.setTag(viewHolder2);
                }

                else
                {
                    viewHolder2 = (ViewHolderAnalogico) vista.getTag();
                }

                RelojAnalogico relojA = (RelojAnalogico) getItem(position);

                if (relojA != null)
                {
                    TextView txtModelo = viewHolder2.getModelo();
                    TextView txtMarca = viewHolder2.getMarca();
                    TextView txtPrecio = viewHolder2.getPrecioprecio();
                    TextView txtMinutero = viewHolder2.getLongitudMinutero();
                    ImageView imgReloj = viewHolder2.getPreview();

                    txtModelo.setText(relojA.getModelo());
                    txtMarca.setText(relojA.getMarca());
                    txtPrecio.setText(String.valueOf(relojA.getPrecio()));
                    txtMinutero.setText(String.valueOf(relojA.getLongitudMinutero()));
                    imgReloj.setImageResource(R.drawable.reloj_analogico_1);
                }

                break;
        }


        return (vista);
    }
}
