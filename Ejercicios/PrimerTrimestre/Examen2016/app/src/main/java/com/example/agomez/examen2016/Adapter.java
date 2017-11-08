package com.example.agomez.examen2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by agomez on 8/11/17.
 */

public class Adapter extends ArrayAdapter <Team>
{
    private ArrayList<Team> teams;

    public Adapter (Context context, int resource,  ArrayList<Team> teams)
    {
        super (context, resource, teams);
        this.teams = teams;
    }

    public View getView (int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.row, null);
            viewHolder = (ViewHolder) view.getTag();
            view.setTag(viewHolder);
        }

        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        Team team = getItem(position);

        TextView nombreEquipo = view.findViewById(R.id.nombreEquipo);
        ImageView logo = view.findViewById(R.id.logo);

        nombreEquipo.setText(team.getNombre());
        logo.setImageResource(Integer.parseInt(String.valueOf(team.getLogo())));

        return view;
    }
}
