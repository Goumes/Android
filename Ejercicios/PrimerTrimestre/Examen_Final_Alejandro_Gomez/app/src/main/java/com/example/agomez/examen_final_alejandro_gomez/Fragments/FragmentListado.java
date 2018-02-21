package com.example.agomez.examen_final_alejandro_gomez.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.agomez.examen_final_alejandro_gomez.Adapter.MyAdapter;
import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.R;
import com.example.agomez.examen_final_alejandro_gomez.ViewModels.MainActivityVM;

import java.util.List;

/**
 * Created by agomez on 21/02/18.
 */

public class FragmentListado extends Fragment
{
    ListView lista;
    MyAdapter adaptador;
    List<Futbolista> futbolistas;
    MainActivityVM mViewModel;
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_listado, null);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        lista = (ListView) mView.findViewById(R.id.listaFutbolistas);

        /*
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                mViewModel.setEquipoSeleccionado(futbolistas.get(position));
            }
        });
        */
        subscribeUiTeams(); //Actualiza

        return mView;
    }

    private void subscribeUiTeams() {
        mViewModel.getFutbolistas().observe(getActivity(), new Observer<List<Futbolista>>() {
            @Override
            public void onChanged(@NonNull final List<Futbolista> futbolistas) {
                showTeamsInUi(futbolistas);
            }
        });
    }

    private void showTeamsInUi(final @NonNull List<Futbolista> equipos2) {
        futbolistas = equipos2;
        adaptador = new MyAdapter(mView.getContext(),R.layout.fragment_listado_row, futbolistas);
        lista.setAdapter(adaptador);
    }
}
