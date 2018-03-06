package com.iesnervion.agomez.a2048.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.iesnervion.agomez.a2048.Adapters.AdapterHighscore;
import com.iesnervion.agomez.a2048.Database.RetrofitClient;
import com.iesnervion.agomez.a2048.Entities.MyQuickSort;
import com.iesnervion.agomez.a2048.Entities.Usuario;
import com.iesnervion.agomez.a2048.Interfaces.RestClient;
import com.iesnervion.agomez.a2048.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuntuacionesActivity extends AppCompatActivity
{
    AdapterHighscore adapter;
    ListView lista;
    ArrayList<Usuario> usuarios;
    RestClient restClient;
    MyQuickSort quickSort;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);

        restClient = RetrofitClient.getClient().create(RestClient.class);

        usuarios = new ArrayList<>();
        lista = findViewById(R.id.listPuntuaciones);

        //String user = "holaGomes"
        //String pass = "ripamigo"
        //String base = user+ ":"+ pass;
        //String authHeader = "Basic "+ Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        loadUsers();
    }

    /*
    public void sendPost(String id, int highscore) {
        restClient.savePost(id, highscore).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                if(response.isSuccessful()) {
                    Log.i("API", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("API", "Unable to submit post to API.");
            }
        });
    }
    */

    public void loadUsers() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        Call<ArrayList<Usuario>> call2 = restClient.getData();
        quickSort = new MyQuickSort();
        call2.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                if (mProgressDialog.isShowing())mProgressDialog.dismiss();
                usuarios = response.body();
                quickSort.sort(usuarios);
                cambiarNombres ();
                adapter = new AdapterHighscore(PuntuacionesActivity.this, R.layout.puntuaciones_row, usuarios);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                call.cancel();
                if (mProgressDialog.isShowing())mProgressDialog.dismiss();
                Toast.makeText(PuntuacionesActivity.this, "Hubo un problema cargando las puntuaciones", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cambiarNombres ()
    {
        String nombreActual = "";
        String [] nombre;
        char inicial = ' ';

        for (int i = 0; i < usuarios.size(); i++)
        {
            nombreActual = usuarios.get(i).getId();
            nombre = nombreActual.split(" ");

            if (nombre[0] != null)
            {
                nombreActual = nombre[0];
            }

            if (1 < nombre.length && nombre[1] != null)
            {
                inicial = Character.toUpperCase(nombre[1].charAt(0));
                nombreActual = nombreActual + " " + inicial + ".";
            }

            if ( 2 < nombre.length && nombre[2] != null)
            {
                inicial = Character.toUpperCase(nombre[2].charAt(0));
                nombreActual = nombreActual + " " + inicial + ".";
            }

            usuarios.get(i).setId(nombreActual);
        }
    }

}
