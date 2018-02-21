package com.example.agomez.examen_final_alejandro_gomez.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agomez.examen_final_alejandro_gomez.AsyncTasks.MyAsyncTask;
import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;
import com.example.agomez.examen_final_alejandro_gomez.R;
import com.example.agomez.examen_final_alejandro_gomez.ViewModels.MainActivityVM;

/**
 * Created by agomez on 21/02/18.
 */

public class FragmentInsercion extends Fragment
{
    MainActivityVM mViewModel;
    EditText nombre;
    EditText apellido;
    Button btnAceptar;
    LinearLayout linear;
    CheckBox checkBox;
    ListView listaCheckboxes;
    MyAsyncTask myAsyncTask;
    View mView;
    Posicion [] posiciones;
    CheckBox checkboxDEL;
    CheckBox checkboxPOR;
    CheckBox checkboxCEN;
    CheckBox checkboxDEF;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_insercion, null);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityVM.class);
        nombre = mView.findViewById(R.id.editNombre);
        apellido = mView.findViewById(R.id.editApellido);
        btnAceptar = mView.findViewById(R.id.btnAceptar);
        posiciones = new Posicion[10];

        checkboxCEN = mView.findViewById(R.id.checkboxCEN);
        checkboxDEL = mView.findViewById(R.id.checkboxDEL);
        checkboxPOR = mView.findViewById(R.id.checkboxPOR);
        checkboxDEF = mView.findViewById(R.id.checkboxDEF);

        //CheckBox checkBox = new CheckBox(getActivity());
        //checkBox.setLayoutParams(new LinearLayout.LayoutParams(R.id.linearCheckboxes));

        checkboxCEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Esto esta hecho de este metodo porque estoy trabajando con Arrays en vez de
                // ArrayList. Si hubiera arreglado ese problema no lo habria hecho asi.
                //Leer la clase FutbolistaTypeConverter para mas informacion de por que no utilizo un ArrayList.
                boolean salir = false;

                for (int i = 0; i < posiciones.length && !salir; i++)
                {
                    if (checkboxCEN.isChecked() && posiciones[i] == null)
                    {
                        posiciones[i] = new Posicion(" CEN ");
                        salir = true;
                    }
                }
            }
        });

        checkboxDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Esto esta hecho de este metodo porque estoy trabajando con Arrays en vez de ArrayList. Si hubiera arreglado ese problema no lo habria hecho asi.
                boolean salir = false;

                for (int i = 0; i < posiciones.length && !salir; i++)
                {
                    if (checkboxDEL.isChecked() && posiciones[i] == null)
                    {
                        posiciones[i] = new Posicion(" DEL ");
                        salir = true;
                    }
                }
            }
        });

        checkboxPOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Esto esta hecho de este metodo porque estoy trabajando con Arrays en vez de ArrayList. Si hubiera arreglado ese problema no lo habria hecho asi.
                boolean salir = false;

                for (int i = 0; i < posiciones.length && !salir; i++)
                {
                    if (checkboxPOR.isChecked() && posiciones[i] == null)
                    {
                        posiciones[i] = new Posicion(" POR ");
                        salir = true;
                    }
                }
            }
        });

        checkboxDEF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Esto esta hecho de este metodo porque estoy trabajando con Arrays en vez de ArrayList. Si hubiera arreglado ese problema no lo habria hecho asi.
                boolean salir = false;

                for (int i = 0; i < posiciones.length && !salir; i++)
                {
                    if (checkboxDEF.isChecked() && posiciones[i] == null)
                    {
                        posiciones[i] = new Posicion(" DEF ");
                        salir = true;
                    }
                }
            }
        });

        //listaCheckboxes = mView.findViewById(R.id.listCheckboxes);

        //Aqui recogeria las posiciones de la badat, y se las añadiria a los Checkboxes
        //He optado por hacer una lista porque no conseguia crear los Checkboxes y meterlos
        //en un layout por codigo. Si lo hubiera arreglado lo habria hecho asi.

        /*
        mViewModel.getPosiciones().observe(getActivity(), new Observer<List<Posicion>>() {
            @Override
            public void onChanged(@Nullable List<Posicion> posiciones) {
                listaCheckboxes.setAdapter(new AdapterCheckbox(mView.getContext(), R.layout.checkbox_row,  posiciones));
            }
        });
        */

        /*
        listaCheckboxes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkbox = (CheckBox) listaCheckboxes.getItemAtPosition(position);
                checkbox.setText("Le has hecho click");
                //Aqui recojo los datos del checkbox, pero no he conseguido que funcione
            }
        });
        */

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!nombre.getText().toString().equals("") && !apellido.getText().toString().equals("") && posiciones != null)
                {
                    Futbolista futbolista = new Futbolista();
                    futbolista.setNombre(nombre.getText().toString());
                    futbolista.setApellido(apellido.getText().toString());
                    futbolista.setPosiciones(posiciones);
                    myAsyncTask = new MyAsyncTask(mViewModel, getActivity(), futbolista);
                    myAsyncTask.execute();

                    nombre.setText("");
                    apellido.setText("");
                    checkboxCEN.setChecked(false);
                    checkboxPOR.setChecked(false);
                    checkboxDEF.setChecked(false);
                    checkboxCEN.setChecked(false);
                }

                else
                {
                    Toast.makeText(getActivity(), "Rellene todos los campos, por favor", Toast.LENGTH_LONG).show();
                }

            }
        });

        return mView;
    }
}
