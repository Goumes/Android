package com.iesnervion.agomez.a2048.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.a2048.Entities.Usuario;
import com.iesnervion.agomez.a2048.R;

import java.util.List;

/**
 * Created by aleja on 19/02/2018.
 */

public class AdapterHighscore extends ArrayAdapter<Usuario>
{
    private List<Usuario> usuarios;

    public AdapterHighscore(Context context, int resource, List<Usuario> usuarios) {
        super(context, resource, usuarios);
        this.usuarios = usuarios;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.puntuaciones_row, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Usuario usuario = getItem(position);

        TextView usuarioNombre = view.findViewById(R.id.valorUser);
        TextView usuarioHighscore = view.findViewById(R.id.valorListaHighscore);

        usuarioNombre.setText(usuario.getId());
        usuarioHighscore.setText(String.valueOf(usuario.getHighscore()));

        return view;
    }
}
