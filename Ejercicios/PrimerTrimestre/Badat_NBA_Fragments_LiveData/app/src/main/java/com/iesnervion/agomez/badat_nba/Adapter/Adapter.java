package com.iesnervion.agomez.badat_nba.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

import java.util.List;

/**
 * Created by aleja on 10/01/2018.
 */

public class Adapter extends ArrayAdapter<Equipo> {
    private List<Equipo> equipos;

    public Adapter(Context context, int resource, List<Equipo> equipos) {
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
        logo.setImageResource(equipo.getLogo());

        return view;
    }
}