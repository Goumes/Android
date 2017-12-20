package com.example.agomez.piedrapapeltijeras;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ImageButton ibPiedra;
    ImageButton ibPapel;
    ImageButton ibTijeras;
    ImageView jugador1;
    ImageView jugador2;
    TextView resultado;
    TextView vs;
    TextView ganadas;
    TextView perdidas;
    TextView empatadas;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Random random;
    //Runnable mMyRunnable;
    //Handler myHandler;
    GestoraAsincrona gestoraAsincrona;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibPiedra = findViewById(R.id.Piedra);
        ibPapel = findViewById(R.id.Papel);
        ibTijeras = findViewById(R.id.Tijeras);
        jugador1 =  findViewById(R.id.resultadoJugador1);
        jugador2 = findViewById(R.id.resultadoJugador2);
        resultado = findViewById(R.id.resultado);
        vs = findViewById(R.id.vs);
        random = new Random ();

        sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        ganadas = findViewById(R.id.ganadas);
        perdidas = findViewById(R.id.perdidas);
        empatadas = findViewById(R.id.empatadas);

        jugador1.setImageResource(android.R.color.transparent);
        jugador2.setImageResource(android.R.color.transparent);
        vs.setText("");
        resultado.setText("");
        gestoraAsincrona = new GestoraAsincrona ();

        ganadas.setText(String.valueOf(sharedPreferences.getInt("ganadas", 0)));
        perdidas.setText(String.valueOf(sharedPreferences.getInt("perdidas", 0)));
        empatadas.setText(String.valueOf(sharedPreferences.getInt("empatadas", 0)));

        /*
        myHandler = new Handler();
        mMyRunnable = new Runnable() {
            @Override
            public void run() {
                jugador1.setImageResource(R.drawable.piedra);
            }
        };
*/
    }

    public void seleccionarJugada(View view)
    {
        int numero;
        numero = random.nextInt(3) + 1;
        int id = view.getId();
        int imagen = 0;
        String resultado1 = "";
        String resultado2 = "";
        jugador1.setImageResource(android.R.color.transparent);
        jugador2.setImageResource(android.R.color.transparent);
        vs.setText("");
        resultado.setText("");

        switch (numero)
        {
            case 1:
                imagen = R.drawable.piedra;
                resultado2 = "piedra";
                break;
            case 2:
                imagen = R.drawable.papel;
                resultado2 = "papel";
                break;
            case 3:
                imagen = R.drawable.tijeras;
                resultado2 = "tijeras";
                break;
        }

       // try {

            switch (id) {
                case R.id.Piedra:
                    //Thread.sleep(1000);
                    //myHandler.postDelayed (mMyRunnable, 1000);
                    //Thread.sleep(1000);
                    gestoraAsincrona = new GestoraAsincrona(); //Solo puedes ejecutar una vez una misma tarea asincrona, asi que tengo que crear una nueva cada vez
                    gestoraAsincrona.setImagen(jugador1);
                    gestoraAsincrona.setId(R.drawable.piedra);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setTexto(vs);
                    gestoraAsincrona.setCadena("VS");
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();
                    //AsyncTask
                    //Thread.sleep(1000);

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setImagen(jugador2);
                    gestoraAsincrona.setId(imagen);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    resultado1 = "piedra";
                    break;

                case R.id.Papel:
                    gestoraAsincrona = new GestoraAsincrona(); //Solo puedes ejecutar una vez una misma tarea asincrona, asi que tengo que crear una nueva cada vez
                    gestoraAsincrona.setImagen(jugador1);
                    gestoraAsincrona.setId(R.drawable.papel);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setTexto(vs);
                    gestoraAsincrona.setCadena("VS");
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();
                    //AsyncTask
                    //Thread.sleep(1000);

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setImagen(jugador2);
                    gestoraAsincrona.setId(imagen);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    resultado1 = "papel";
                    break;

                case R.id.Tijeras:
                    gestoraAsincrona = new GestoraAsincrona(); //Solo puedes ejecutar una vez una misma tarea asincrona, asi que tengo que crear una nueva cada vez
                    gestoraAsincrona.setImagen(jugador1);
                    gestoraAsincrona.setId(R.drawable.tijeras);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setTexto(vs);
                    gestoraAsincrona.setCadena("VS");
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();
                    //AsyncTask
                    //Thread.sleep(1000);

                    gestoraAsincrona = new GestoraAsincrona();
                    gestoraAsincrona.setImagen(jugador2);
                    gestoraAsincrona.setId(imagen);
                    gestoraAsincrona.setTiempo(1000);
                    gestoraAsincrona.execute();

                    resultado1 = "tijeras";
                    break;
            }

            if ((resultado1.equals("piedra") && resultado2.equals("papel"))
                    || (resultado1.equals("papel") && resultado2.equals("tijeras"))
                    || (resultado1.equals("tijeras") && resultado2.equals("piedra")))
            {
                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(resultado);
                gestoraAsincrona.setCadena("Has perdido, crack!");
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();

                editor.putInt("perdidas", sharedPreferences.getInt("perdidas", 0) + 1);
                editor.commit ();

                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(perdidas);
                gestoraAsincrona.setCadena(String.valueOf(sharedPreferences.getInt("perdidas", 0)));
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();

            } else if ((resultado1.equals("piedra") && resultado2.equals("tijeras"))
                    || (resultado1.equals("papel") && resultado2.equals("piedra"))
                    || (resultado1.equals("tijeras") && resultado2.equals("papel")))
            {
                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(resultado);
                gestoraAsincrona.setCadena("Has ganado, crack!");
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();

                editor.putInt("ganadas", 1 + sharedPreferences.getInt("ganadas", 0));
                editor.commit ();


                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(ganadas);
                gestoraAsincrona.setCadena(String.valueOf(sharedPreferences.getInt("ganadas", 0)));
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();

            } else if ((resultado1.equals("piedra") && resultado2.equals("piedra"))
                    || (resultado1.equals("papel") && resultado2.equals("papel"))
                    || (resultado1.equals("tijeras") && resultado2.equals("tijeras")))
            {
                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(resultado);
                gestoraAsincrona.setCadena("Has empatado, crack!");
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();

                editor.putInt("empatadas", 1 + sharedPreferences.getInt("empatadas", 0));
                editor.commit ();

                gestoraAsincrona = new GestoraAsincrona();
                gestoraAsincrona.setTexto(empatadas);
                gestoraAsincrona.setCadena(String.valueOf(sharedPreferences.getInt("empatadas", 0)));
                gestoraAsincrona.setTiempo(1000);
                gestoraAsincrona.execute();
            }
       // }

        /*
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }perdidas
*/

    }
}
