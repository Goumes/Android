package com.iesnervion.agomez.badat_nba.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.iesnervion.agomez.badat_nba.Entities.Equipo;
import com.iesnervion.agomez.badat_nba.Fragments.DetailsFragment;
import com.iesnervion.agomez.badat_nba.R;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FrameLayout frameDetalles;
    Equipo equipo;
    MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        frameDetalles = findViewById(R.id.FrameDetalles);

        mViewModel.getEquipoSeleccionado().observe(this, new Observer<Equipo>() {
            @Override
            public void onChanged(@Nullable Equipo equipo) {
                if (frameDetalles != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragment = DetailsFragment.newInstance(equipo);
                    fragmentTransaction.add(R.id.FrameDetalles, fragment);
                    fragmentTransaction.commit();
                } else {
                    Intent myIntent = new Intent(getApplicationContext(), DatosActivity.class);
                    myIntent.putExtra("equipo", equipo);
                    startActivity(myIntent);
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        //Hago esto para reiniciar el color de la barra de notificaciones, que se queda por defecto con la última selección.
        if (frameDetalles == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            }
        }
    }

}