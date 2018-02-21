package com.example.agomez.examen_final_alejandro_gomez.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.R;

import java.util.List;

/**
 * Created by agomez on 21/02/18.
 */

public class MyAdapter extends ArrayAdapter<Futbolista>
{
    private List<Futbolista> futbolistas;

    public MyAdapter(Context context, int resource, List<Futbolista> futbolistas) {
        super(context, resource, futbolistas);
        this.futbolistas = futbolistas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.fragment_listado_row, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Futbolista futbolista = getItem(position);

        TextView nombreEquipo = view.findViewById(R.id.nombreFutbolistaFila);
        TextView posiciones = view.findViewById(R.id.posicionFila);

        nombreEquipo.setText(futbolista.getNombre());
        posiciones.setText("");
        if (futbolista.getPosiciones() != null)
        {
            for (int i = 0; i < futbolista.getPosiciones().length; i++)
            {
                if (futbolista.getPosiciones()[i] != null)
                {
                    posiciones.setText(posiciones.getText().toString() + futbolista.getPosiciones()[i].getNombre());
                }
            }
        }

        return view;
    }
}
