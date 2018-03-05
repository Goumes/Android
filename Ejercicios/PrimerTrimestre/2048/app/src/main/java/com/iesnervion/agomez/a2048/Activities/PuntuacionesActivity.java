package com.iesnervion.agomez.a2048.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.iesnervion.agomez.a2048.Adapters.AdapterHighscore;
import com.iesnervion.agomez.a2048.Database.RetrofitClient;
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
        Call<ArrayList<Usuario>> call2 = restClient.getData();
        call2.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                usuarios = response.body();
                adapter = new AdapterHighscore(PuntuacionesActivity.this, R.layout.puntuaciones_row, usuarios);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
