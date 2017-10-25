package com.example.agomez.reproductormusica;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    private String [] titulos = {"Never 2 Far", "Almost Famous", "I'm Shady", "Underground", "Open Mic", "Wicked Ways", "Evil Twin", "Never Enough", "Space Bound", "Remember Me?"};
    private String [] autores = {"Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem", "Eminem"};
    private String [] albumes = {"Infinite", "Recovery", "The Slim Shady LP", "Relapse", "Infinite", "The Marshall Mathers LP2", "The Marshall Mathers LP2", "Encore", "Recovery", "The Marshall Mathers LP"};
    private String [] duraciones = {"3:14", "3:45", "2:54", "4:50", "3:43", "3:14", "3:45", "2:54", "4:50", "3:43"};
    private Integer [] portadas = {R.drawable.portada1};
    */

    private Cancion [] canciones = {new Cancion("Never 2 Far", "Eminem", "Infinite", "3:14", R.drawable.portada1),
                                    new Cancion ("Almost Famous", "Eminem", "Recovery", "3:45", R.drawable.portada1),
                                    new Cancion ("I'm Shady", "Eminem", "The Slim Shady LP", "2:54", R.drawable.portada1),
                                    new Cancion ("Underground", "Eminem", "Relapse", "4:50", R.drawable.portada1),
                                    new Cancion ("Open Mic", "Eminem", "Infinite", "3:43", R.drawable.portada1),
                                    new Cancion ("Wicked Ways", "Eminem", "The Marshall Mathers LP2", "3:14", R.drawable.portada1),
                                    new Cancion ("Evil Twin", "Eminem", "The Marshall Mathers LP2", "3:45", R.drawable.portada1),
                                    new Cancion ("Never Enough", "Eminem", "Encore", "2:54", R.drawable.portada1),
                                    new Cancion ("Space Bound", "Eminem", "Recovery", "4:50", R.drawable.portada1),
                                    new Cancion ("Remember Me?", "Eminem", "The Marshall Mathers LP", "3:43", R.drawable.portada1)};

    private ListView lista;
    private MediaPlayer mp;
    private SeekBar mSeekBar;
    //private Handler handler;
    //private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        //handler = new Handler ();

        final Adaptador adaptador = new Adaptador(this, canciones);

        lista = (ListView) findViewById(R.id.list);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Cancion cancion = (Cancion) lista.getItemAtPosition(position);

                String txt = cancion.getTitulo();

                if ( txt.equals("Underground"))
                {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.underground);

                    //playCycle();
                    mp.start();
                    int mCurrentPosition = mp.getCurrentPosition() / 1000;
                    mSeekBar.setProgress(mCurrentPosition);
                }

            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                seekBar.setMax(mp.getDuration() / 1000);

                if (fromUser) {
                    mp.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClick(View view) {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.pause();
            } else {
                mp.start();
            }
        }
    }

    /*
    public void playCycle ()
    {
        mSeekBar.setProgress(mp.getCurrentPosition());
        if (mp.isPlaying())
        {
            runnable = new Runnable (){
                @Override
                public void run ()
                {
                    playCycle ();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }
    */
}
