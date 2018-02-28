package com.iesnervion.agomez.a2048.AsyncTasks;

import android.os.AsyncTask;

import com.iesnervion.agomez.a2048.Activities.JuegoActivityViewModel;
import com.iesnervion.agomez.a2048.Entities.Tablero;

/**
 * Created by aleja on 28/02/2018.
 */

public class MyAsyncTask extends AsyncTask<Void, Void,Void>
{
    private JuegoActivityViewModel mViewModel;
    private Tablero tablero;

    public MyAsyncTask (JuegoActivityViewModel mViewModel, Tablero tablero)
    {
        this.mViewModel = mViewModel;
        this.tablero = tablero;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        mViewModel.updateTablero(tablero);
        return null;
    }
}
