package com.iesnervion.agomez.badat_nba.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.iesnervion.agomez.badat_nba.Adapter.Adapter;
import com.iesnervion.agomez.badat_nba.Database.AppDatabase;
import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Fragments.DetailsFragment;
import com.iesnervion.agomez.badat_nba.Interfaces.Comunicador;
import com.iesnervion.agomez.badat_nba.R;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements Comunicador{
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void responder(Equipo equipo) {

        FrameLayout frameDetalles = findViewById(R.id.FrameDetalles);

        if (frameDetalles != null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = DetailsFragment.newInstance(equipo);
            fragmentTransaction.add(R.id.FrameDetalles, fragment);
            fragmentTransaction.commit();
        }

        else
        {
            Intent myIntent = new Intent (this, DatosActivity.class);
            myIntent.putExtra("equipo", equipo);
            startActivity (myIntent);
        }
    }
}