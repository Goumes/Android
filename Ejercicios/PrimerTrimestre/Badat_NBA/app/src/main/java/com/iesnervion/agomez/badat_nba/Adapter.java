package com.iesnervion.agomez.badat_nba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aleja on 10/01/2018.
 */

public class Adapter extends ArrayAdapter<Equipo> {
    private ArrayList<Equipo> equipos;

    public Adapter(Context context, int resource, ArrayList<Equipo> equipos) {
        super(context, resource, equipos);
        this.equipos = equipos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.row_equipo, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Equipo equipo = getItem(position);

        TextView nombreEquipo = view.findViewById(R.id.nombre_equipo_lista);
        ImageView logo = view.findViewById(R.id.logoLista);

        nombreEquipo.setText(equipo.getNombre());
        logo.setImageResource(Integer.parseInt(String.valueOf(equipo.getLogo())));

        return view;
    }
}