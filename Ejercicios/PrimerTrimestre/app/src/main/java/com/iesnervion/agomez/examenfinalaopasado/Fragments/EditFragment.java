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
import android.widget.Switch;
import android.widget.Toast;

import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivityVM;
import com.iesnervion.agomez.examenfinalaopasado.AsyncTasks.MyAsyncTask;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.R;

/**
 * Created by aleja on 20/02/2018.
 */

public class EditFragment extends Fragment
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
    Switch aSwitch;
    Contact contactSeleccionado;

    public static EditFragment newInstance (Contact contact)
    {
        EditFragment f = new EditFragment();
        Bundle args = new Bundle();
        args.putParcelable("contact", contact);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.edit_fragment, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);

        contactSeleccionado = this.getArguments().getParcelable("contact");

        nombre = view.findViewById(R.id.editEditNombre);
        nombre.setText(contactSeleccionado.getName());
        edad = view.findViewById(R.id.editEditEdad);
        edad.setText(String.valueOf(contactSeleccionado.getAge()));
        telefono = view.findViewById(R.id.editEditTelefono);
        telefono.setText(contactSeleccionado.getPhone());
        bHombre = view.findViewById(R.id.editRadioHombre);
        bMujer = view.findViewById(R.id.editRadioMujer);
        aSwitch = view.findViewById(R.id.switchEditar);

        if (contactSeleccionado.getGender().equals("Hombre"))
        {
            bHombre.setChecked(true);
        }

        else
        {
            bMujer.setChecked(true);
        }

        btnAceptar = view.findViewById(R.id.editBtnAceptar);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setEnabled(aSwitch.isChecked());
                edad.setEnabled(aSwitch.isChecked());
                telefono.setEnabled(aSwitch.isChecked());
                bHombre.setEnabled(aSwitch.isChecked());
                bMujer.setEnabled(aSwitch.isChecked());
                btnAceptar.setEnabled(aSwitch.isChecked());
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (aSwitch.isChecked())
                {
                    if (!nombre.getText().equals("") && !edad.getText().equals("") && !telefono.getText().equals("") && (bHombre.isChecked() || bMujer.isChecked()))
                    {
                        contactSeleccionado.setName(nombre.getText().toString());
                        contactSeleccionado.setAge(Integer.valueOf(edad.getText().toString()));
                        contactSeleccionado.setPhone(telefono.getText().toString());
                        if (bHombre.isChecked())
                        {
                            genero = "Hombre";
                        }

                        else
                        {
                            genero = "Mujer";
                        }

                        contactSeleccionado.setGender(genero);

                        myAsyncTask = new MyAsyncTask(mViewModel,contactSeleccionado, getActivity(), "update");
                        myAsyncTask.execute();
                    }

                    else
                    {
                        Toast.makeText(getActivity(), "Por favor, rellena todos los campos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        return view;
    }
}
