package com.iesnervion.agomez.badat_nba.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

/**
 * Created by aleja on 05/02/2018.
 */

public class DetailsFragment extends Fragment
{

    TextView nombre;
    TextView fundacion;
    TextView colores;
    TextView propietario;
    TextView entrenador;
    TextView estadio;
    TextView ubicacion;
    ImageView logo;

    Equipo equipo;
    Intent intent;

    View rectangulo;
    View rectanguloDatos;
    View rectanguloInstalaciones;

    TextView instalaciones;
    TextView datos;

    public static DetailsFragment newInstance (Equipo equipo)
    {
        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("equipo", equipo);
        f.setArguments(args);
        return f;
    }

    /*
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
    //En google ponia que esto es necesario porque sino viene el objeto a null, pero funciona poniendolo en el onCreateView.
        super.onCreate(savedInstanceState);
        equipo = this.getArguments().getParcelable("equipo");
    }
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View mView = inflater.inflate(R.layout.fragment_details, null);

        equipo = this.getArguments().getParcelable("equipo");


        nombre = mView.findViewById(R.id.nombre_equipo);
        fundacion = mView.findViewById(R.id.fundacion_txt);
        colores = mView.findViewById(R.id.colores_txt);
        propietario = mView.findViewById(R.id.presidente_txt);
        entrenador = mView.findViewById(R.id.entrenador_txt);
        estadio = mView.findViewById(R.id.estadio_txt);
        ubicacion = mView.findViewById(R.id.ubicacion_txt);
        logo = mView.findViewById(R.id.logo);
        rectangulo = mView.findViewById(R.id.rectangulo);
        rectanguloDatos = mView.findViewById(R.id.rectangulo_datos);
        rectanguloInstalaciones = mView.findViewById(R.id.rectangulo_instalaciones);
        instalaciones = mView.findViewById(R.id.instalaciones);
        datos = mView.findViewById(R.id.datos);

        nombre.setText(equipo.getNombre());
        fundacion.setText(String.valueOf(equipo.getFundacion()));
        colores.setText(equipo.getColor1() + " y "+equipo.getColor2());
        propietario.setText(equipo.getPresidente());
        entrenador.setText(equipo.getEntrenador());
        estadio.setText(equipo.getEstadio());
        ubicacion.setText(equipo.getUbicacion());
        logo.setImageResource(equipo.getLogo());

        rectangulo.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));
        rectanguloDatos.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));
        rectanguloInstalaciones.setBackgroundColor(Color.parseColor(equipo.getColor1Hex()));

        nombre.setTextColor(Color.parseColor(equipo.getColor2Hex()));
        datos.setTextColor(Color.parseColor(equipo.getColor2Hex()));
        instalaciones.setTextColor(Color.parseColor(equipo.getColor2Hex()));



        //Cambiar el color de la barra de notificaciones
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(equipo.getColor1Hex()));
        }




        return mView;
    }
}
