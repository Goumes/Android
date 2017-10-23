package com.example.agomez.reproductormusica;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] titulos = {"Never 2 Far", "Almost Famous", "I'm Shady", "Underground", "Open Mic", "Wicked Ways", "Evil Twin", "Never Enough", "Space Bound", "Remember Me?"};
    private String [] autores = {"Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem"};
    private String [] albumes = {"Infinite", "Recovery", "The Slim Shady LP", "Relapse", "Infinite", "The Marshall Mathers LP2", "The Marshall Mathers LP2", "Encore", "Recovery", "The Marshall Mathers LP"};
    private String [] duraciones = {"3:14", "3:45", "2:54", "4:50", "3:43", "3:14", "3:45", "2:54", "4:50", "3:43"};
    private Integer [] portadas = {R.drawable.portada1};

    private ListView lista;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Adaptador adaptador = new Adaptador(this, titulos, autores, albumes, duraciones, portadas);

        lista = (ListView) findViewById(R.id.list);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView txtView =  (TextView) findViewById(R.id.titulo);
            }
        });
    }
}
