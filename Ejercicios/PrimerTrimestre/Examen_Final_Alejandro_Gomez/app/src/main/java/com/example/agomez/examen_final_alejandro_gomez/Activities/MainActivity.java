package com.example.agomez.examen_final_alejandro_gomez.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.agomez.examen_final_alejandro_gomez.Fragments.FragmentEleccion;
import com.example.agomez.examen_final_alejandro_gomez.Fragments.FragmentInsercion;
import com.example.agomez.examen_final_alejandro_gomez.Fragments.FragmentListado;
import com.example.agomez.examen_final_alejandro_gomez.R;
import com.example.agomez.examen_final_alejandro_gomez.ViewModels.MainActivityVM;

public class MainActivity extends AppCompatActivity
{
    MainActivityVM mViewModel;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainActivityVM.class);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragmentPlaceholder) != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new FragmentEleccion();
            fragmentTransaction.add(R.id.fragmentPlaceholder, fragment);
            fragmentTransaction.commit();
        }

        mViewModel.getOpcion().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                switch (integer)
                {
                    case 1:
                        if (findViewById(R.id.fragmentPlaceholder) != null)
                        {
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragment = new FragmentInsercion();
                            fragmentTransaction.replace(R.id.fragmentPlaceholder, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }

                    break;

                    case 2:
                        if (findViewById(R.id.fragmentPlaceholder) != null) {
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragment = new FragmentListado();
                            fragmentTransaction.replace(R.id.fragmentPlaceholder, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    break;
                }
            }
        });
    }
}
