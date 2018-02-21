package com.example.agomez.examen_final_alejandro_gomez.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;
import com.example.agomez.examen_final_alejandro_gomez.R;

import java.util.List;

/**
 * Created by agomez on 21/02/18.
 */

public class AdapterCheckbox extends ArrayAdapter<Posicion>
{
    private List<Posicion> posiciones;

    //Esta clase no es utilizada porque he optado por hacer los checkboxes estaticos ya que
    //no he conseguido recoger los datos de cada checkbox de esta lista.
    //Aunque esta funciona correctamente.

    public AdapterCheckbox(Context context, int resource, List<Posicion> posiciones) {
        super(context, resource, posiciones);
        this.posiciones = posiciones;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.checkbox_row, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Posicion posicion = getItem(position);

        CheckBox posicionCheck = view.findViewById(R.id.checkboxList);

        posicionCheck.setText(posicion.getNombre());


        return view;
    }
}
