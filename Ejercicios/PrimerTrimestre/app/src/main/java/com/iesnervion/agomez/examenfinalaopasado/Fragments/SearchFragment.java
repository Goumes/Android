package com.iesnervion.agomez.examenfinalaopasado.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivityVM;
import com.iesnervion.agomez.examenfinalaopasado.Adapter.Adapter;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleja on 20/02/2018.
 */

public class SearchFragment extends Fragment
{
    ListView lista;
    Adapter adapter;
    List<Contact> contacts;
    MainActivityVM mViewModel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.search_fragment, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        lista = view.findViewById(R.id.listaContacts);

        mViewModel.getContactos().observe(getActivity(), new Observer<List<Contact>>() {
            @Override
            public void onChanged(@NonNull final List<Contact> contacts2) {
                contacts = contacts2;
                adapter = new Adapter(getActivity(), R.layout.row_contact, contacts);
                lista.setAdapter(adapter);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mViewModel.setContactoSeleccionado(contacts.get(position));
            }
        });

        return view;
    }
}
