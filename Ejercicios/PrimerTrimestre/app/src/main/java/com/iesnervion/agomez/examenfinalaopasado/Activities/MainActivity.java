package com.iesnervion.agomez.examenfinalaopasado.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iesnervion.agomez.examenfinalaopasado.Fragments.AddFragment;
import com.iesnervion.agomez.examenfinalaopasado.Fragments.EditFragment;
import com.iesnervion.agomez.examenfinalaopasado.Fragments.MainFragment;
import com.iesnervion.agomez.examenfinalaopasado.Fragments.SearchFragment;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    MainActivityVM mViewModel;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainActivityVM.class);
        fragmentManager = getSupportFragmentManager();


        if (findViewById(R.id.container) == null) //No esta horizontal
        {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new MainFragment();
            fragmentTransaction.replace(R.id.placeholderFragment, fragment);
            fragmentTransaction.commit();
        }



        mViewModel.getOpcion().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer)
            {
                if (integer == 1)
                {
                    if (findViewById(R.id.container) != null)
                    {
                        fragment = new AddFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                    else
                    {
                        fragment = new AddFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeholderFragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                }

                else if (integer == 2)
                {
                    if (findViewById(R.id.container) != null) {
                        fragment = new SearchFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else
                    {
                        fragment = new SearchFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeholderFragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                }
            }
        });

        mViewModel.getContactoSeleccionado().observe(this, new Observer<Contact>() {
            @Override
            public void onChanged(@Nullable Contact contact) {
                if (findViewById(R.id.container) != null)
                {
                    fragment = EditFragment.newInstance(contact);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

                else
                {
                    fragment = EditFragment.newInstance(contact);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.placeholderFragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });
    }
}
