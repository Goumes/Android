package com.iesnervion.agomez.badat_nba.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesnervion.agomez.badat_nba.Adapter.Adapter;
import com.iesnervion.agomez.badat_nba.Database.AppDatabase;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Adapter adaptador;
    List<Equipo> equipos;
    Intent myIntent;
    Bitmap icon;
    AppDatabase mDb;
    MainActivityViewModel mViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        //mViewModel.createDb();

        //populateDb();

        //rellenarArray();

        lista = (ListView) findViewById(R.id.lista);


        //adaptador = new Adapter(this,R.layout.row_equipo, equipos);
        //lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                myIntent = new Intent(MainActivity.this, DatosActivity.class);
                myIntent.putExtra("equipo", equipos.get(position));
                startActivity (myIntent);
            }
        });

        subscribeUiTeams(); //Actualiza la UI cada vez que se cambian los equipos en el ViewModel.
    }

    private void subscribeUiTeams() {
        mViewModel.getEquipos().observe(this, new Observer<List<Equipo>>() {
            @Override
            public void onChanged(@NonNull final List<Equipo> equipos) {
                showTeamsInUi(equipos);
            }
        });
    }

    private void showTeamsInUi(final @NonNull List<Equipo> equipos2) {
        equipos = equipos2;
        adaptador = new Adapter(this,R.layout.row_equipo, equipos);
        lista.setAdapter(adaptador);
    }

    /*

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    private void rellenarArray() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<Equipo> equipos2 = mDb.equipoDao().cargarTodosEquipos();

        for (int i = 0; i < equipos2.size(); i++)
        {
            equipos.add(equipos2.get(i));
        }
    }
    */
}