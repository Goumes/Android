package com.iesnervion.agomez.badat_nba.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.badat_nba.R;

/**
 * Created by aleja on 10/01/2018.
 */

public class ViewHolder
{

    TextView equipo;
    ImageView logo;

    public ViewHolder (View view)
    {
        this.equipo = view.findViewById(R.id.nombre_equipo_lista);
        this.logo = view.findViewById(R.id.logoLista);
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
