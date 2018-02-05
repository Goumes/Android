package com.iesnervion.agomez.badat_nba.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesnervion.agomez.badat_nba.Activities.DatosActivity;
import com.iesnervion.agomez.badat_nba.Activities.MainActivity;
import com.iesnervion.agomez.badat_nba.Activities.MainActivityViewModel;
import com.iesnervion.agomez.badat_nba.Adapter.Adapter;
import com.iesnervion.agomez.badat_nba.Database.AppDatabase;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Interfaces.Comunicador;
import com.iesnervion.agomez.badat_nba.R;

import java.util.List;

/**
 * Created by aleja on 05/02/2018.
 */

public class ListFragment extends Fragment
{

    ListView lista;
    Adapter adaptador;
    List<Equipo> equipos;
    Intent myIntent;
    Bitmap icon;
    AppDatabase mDb;
    MainActivityViewModel mViewModel;
    Comunicador comunicador;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);

        View mView = inflater.inflate(R.layout.fragment_list, null);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        lista = (ListView) mView.findViewById(R.id.lista);

        /*
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                myIntent = new Intent(getActivity(), DatosActivity.class);
                myIntent.putExtra("equipo", equipos.get(position));
                startActivity (myIntent);


                Bundle bundle = new Bundle();
                bundle.putParcelable("equipo", equipos.get(position));

            }
        });
        */

        subscribeUiTeams(); //Actualiza la UI cada vez que se cambian los equipos en el ViewModel

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comunicador = (Comunicador) getActivity();//Esto es para que el comunicador sea la MainActivity, que es la que implementa la interfaz.

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                comunicador.responder(equipos.get(position));
            }
        });
    }

    private void subscribeUiTeams() {
        mViewModel.getEquipos().observe(getActivity(), new Observer<List<Equipo>>() {
            @Override
            public void onChanged(@NonNull final List<Equipo> equipos) {
                showTeamsInUi(equipos);
            }
        });
    }

    private void showTeamsInUi(final @NonNull List<Equipo> equipos2) {
        equipos = equipos2;
        adaptador = new Adapter(getActivity(),R.layout.row_equipo, equipos);
        lista.setAdapter(adaptador);
    }


}
