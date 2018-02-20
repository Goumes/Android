package com.iesnervion.agomez.examenfinalaopasado.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.R;

import java.util.List;

/**
 * Created by aleja on 10/01/2018.
 */

public class Adapter extends ArrayAdapter<Contact> {
    private List<Contact> contacts;

    public Adapter(Context context, int resource, List<Contact> contacts) {
        super(context, resource, contacts);
        this.contacts = contacts;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.row_contact, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Contact contact = getItem(position);

        TextView nombre = view.findViewById(R.id.nombre);
        TextView telefono = view.findViewById(R.id.telefono);

        nombre.setText(contact.getName());
        telefono.setText(contact.getPhone());

        return view;
    }
}