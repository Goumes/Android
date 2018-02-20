package com.iesnervion.agomez.examenfinalaopasado.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivityVM;
import com.iesnervion.agomez.examenfinalaopasado.R;

import java.util.ArrayList;

/**
 * Created by aleja on 20/02/2018.
 */

public class MainFragment extends Fragment
{

    ListView lista;
    ArrayList<String> opciones;
    MainActivityVM mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view;
        view = inflater.inflate(R.layout.fragment_main, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        lista = view.findViewById(R.id.list);

        opciones = new ArrayList<>();
        opciones.add("Añadir");
        opciones.add("Buscar");

        lista.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, opciones));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (opciones.get(position).equals("Añadir"))
                {
                    mViewModel.setOpcion(1);
                }

                else
                {
                    mViewModel.setOpcion(2);
                }

            }
        });

        return view;
    }
}
