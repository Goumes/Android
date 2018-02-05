package com.iesnervion.agomez.badat_nba.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Fragments.DetailsFragment;
import com.iesnervion.agomez.badat_nba.R;

public class DatosActivity extends FragmentActivity {
    Intent intent;
    Equipo equipo;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_equipo);

        intent = getIntent();

        equipo = intent.getParcelableExtra("equipo");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = DetailsFragment.newInstance(equipo);
        fragmentTransaction.add(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();

    }
}
