package com.iesnervion.agomez.examenfinalaopasado.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivityVM;
import com.iesnervion.agomez.examenfinalaopasado.AsyncTasks.MyAsyncTask;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.R;

/**
 * Created by aleja on 20/02/2018.
 */

public class AddFragment extends Fragment
{
    EditText nombre;
    EditText edad;
    EditText telefono;
    RadioButton bHombre;
    RadioButton bMujer;
    String genero;
    Button btnAceptar;
    MyAsyncTask myAsyncTask;
    MainActivityVM mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.add_fragment, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        nombre = view.findViewById(R.id.addEditNombre);
        edad = view.findViewById(R.id.addEditEdad);
        telefono = view.findViewById(R.id.addEditTelefono);
        bHombre = view.findViewById(R.id.radioHombre);
        bMujer = view.findViewById(R.id.radioMujer);
        btnAceptar = view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!nombre.getText().equals("") && !edad.getText().equals("") && !telefono.getText().equals("") && (bHombre.isChecked() || bMujer.isChecked()))
                {
                    if (bHombre.isChecked())
                    {
                        genero = "Hombre";
                    }

                    else
                    {
                        genero = "Mujer";
                    }


                    myAsyncTask = new MyAsyncTask(mViewModel, new Contact(nombre.getText().toString(), telefono.getText().toString(), Integer.valueOf(edad.getText().toString()), genero), getActivity(), "insert");
                    myAsyncTask.execute();


                }

                else
                {
                    Toast.makeText(getActivity(), "Por favor, rellena todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });



        return view;
    }

}
