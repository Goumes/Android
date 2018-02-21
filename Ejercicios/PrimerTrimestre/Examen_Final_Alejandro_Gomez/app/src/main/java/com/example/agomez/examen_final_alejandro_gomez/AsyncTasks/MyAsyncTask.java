package com.example.agomez.examen_final_alejandro_gomez.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.agomez.examen_final_alejandro_gomez.Models.Futbolista;
import com.example.agomez.examen_final_alejandro_gomez.ViewModels.MainActivityVM;

/**
 * Created by agomez on 21/02/18.
 */

public class MyAsyncTask extends AsyncTask <Void, Void, Void>
{
    private MainActivityVM mViewModel;
    private Futbolista futbolista;
    private Context context;

    public MyAsyncTask(MainActivityVM mViewModel, Context context, Futbolista futbolista) {
        super();
        this.mViewModel = mViewModel;
        this.context = context;
        this.futbolista = futbolista;
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        mViewModel.insertFutbolista(futbolista);
        return null;
    }

    @Override
    protected void onPostExecute(Void o) {
        super.onPostExecute(o);
        Toast.makeText(context, "Futbolista añadido!", Toast.LENGTH_LONG).show();
    }
}
