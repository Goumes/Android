package com.example.agomez.listviewprueba;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] array = {"Yo", "Soy", "El", "Poderoso", "pepejava"};

    private Integer [] imagenes = {R.drawable.spray,
                                   R.drawable.spray2,
                                   R.drawable.spray3,
                                   R.drawable.spray4,
                                   R.drawable.spray5};
    private ListView lista;

    private SoundPool sp;
    private int idSpray;

    //private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0); //Esta deprecado a partir de la API 21.
        idSpray = sp.load (this, R.raw.sound1, 0);

        //mp = MediaPlayer.create(this, R.raw.sound1);

        Adaptador adaptador = new Adaptador(this, array, imagenes);

        lista = (ListView) findViewById(R.id.list);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = array[position];
                //mp.start();
                sp.play(idSpray, 1, 1, 1, 0, 1);
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
