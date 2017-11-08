package com.example.agomez.examen2016;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 8/11/17.
 */

public class ViewHolder
{
    TextView equipo;
    ImageView logo;

    public ViewHolder (View view)
    {
        this.equipo = view.findViewById(R.id.nombreEquipo);
        this.logo = view.findViewById(R.id.logo);
    }

    public TextView getEquipo ()
    {
        return equipo;
    }

    public void setEquipo (TextView equipo)
    {
        this.equipo = equipo;
    }

    public ImageView getLogo () {
        return logo;
    }

    public void setLogo (ImageView logo)
    {
        this.logo = logo;
    }
}
