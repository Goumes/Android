package com.iesnervion.agomez.examenfinalaopasado.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivity;
import com.iesnervion.agomez.examenfinalaopasado.Activities.MainActivityVM;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;

/**
 * Created by aleja on 20/02/2018.
 */

public class MyAsyncTask extends AsyncTask<Void, Void, Void>
{
    private MainActivityVM mViewModel;
    private Contact contact;
    private Context context;
    private String tarea;

    public MyAsyncTask (MainActivityVM mViewModel, Contact contact, Context context, String tarea)
    {
        this.mViewModel = mViewModel;
        this.contact = contact;
        this.context = context;
        this.tarea = tarea;
    }

    @Override
    protected Void doInBackground(Void... params) {

        if (tarea.equals("insert"))
        {
            mViewModel.insertContact(contact);
        }

        else if (tarea.equals("update"))
        {
            mViewModel.updateContact(contact);
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        if (tarea.equals("insert"))
        {
            Toast.makeText(context, "Contacto añadido!", Toast.LENGTH_LONG).show();
        }

        else if (tarea.equals("update"))
        {
            Toast.makeText(context, "Contacto modificado!", Toast.LENGTH_LONG).show();
        }
    }
}
