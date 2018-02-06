package com.iesnervion.agomez.badat_nba.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Fragments.DetailsFragment;
import com.iesnervion.agomez.badat_nba.Interfaces.Comunicador;
import com.iesnervion.agomez.badat_nba.R;

public class MainActivity extends AppCompatActivity  implements Comunicador{
    Fragment fragment;
    FrameLayout frameDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        //Hago esto para reiniciar el color de la barra de notificaciones, que se queda por defecto con la última selección.
        if (frameDetalles == null)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            }
        }
    }


    @Override
    public void responder(Equipo equipo) {

        frameDetalles = findViewById(R.id.FrameDetalles);

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