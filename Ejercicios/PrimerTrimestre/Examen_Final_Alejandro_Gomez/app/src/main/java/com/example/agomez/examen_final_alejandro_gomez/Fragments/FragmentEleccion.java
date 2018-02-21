package com.example.agomez.examen_final_alejandro_gomez.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.agomez.examen_final_alejandro_gomez.R;
import com.example.agomez.examen_final_alejandro_gomez.ViewModels.MainActivityVM;

/**
 * Created by agomez on 21/02/18.
 */

public class FragmentEleccion extends Fragment
{
    Button btnListar;
    Button btnInsertar;
    MainActivityVM mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_eleccion, null);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        btnListar = mView.findViewById(R.id.btnListar);
        btnInsertar = mView.findViewById(R.id.btnInsertar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setOpcion(2);
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setOpcion(1);
            }
        });

        return mView;
    }
}
