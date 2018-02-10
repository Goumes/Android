package com.iesnervion.agomez.a2048.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.iesnervion.agomez.a2048.Entities.OnSwipeTouchListener;
import com.iesnervion.agomez.a2048.Entities.Tablero;
import com.iesnervion.agomez.a2048.R;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity {

    TableLayout myTableLayout;
    TextView row00;
    TextView row01;
    TextView row02;
    TextView row03;
    TextView row10;
    TextView row11;
    TextView row12;
    TextView row13;
    TextView row20;
    TextView row21;
    TextView row22;
    TextView row23;
    TextView row30;
    TextView row31;
    TextView row32;
    TextView row33;

    LinearLayout linearRow00;
    LinearLayout linearRow01;
    LinearLayout linearRow02;
    LinearLayout linearRow03;
    LinearLayout linearRow10;
    LinearLayout linearRow11;
    LinearLayout linearRow12;
    LinearLayout linearRow13;
    LinearLayout linearRow20;
    LinearLayout linearRow21;
    LinearLayout linearRow22;
    LinearLayout linearRow23;
    LinearLayout linearRow30;
    LinearLayout linearRow31;
    LinearLayout linearRow32;
    LinearLayout linearRow33;

    LinearLayout [][] linears;

    Tablero tablero;
    TextView [][] textos;
    TextView score;
    TextView highscore;
    JuegoActivityViewModel mViewModel;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        mViewModel = ViewModelProviders.of(this).get(JuegoActivityViewModel.class);

        sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        //tablero = mViewModel.getTablero().getValue();

        myTableLayout = findViewById(R.id.tableJuego);

        //tablero = new Tablero();

        //tablero.rellenarTablero();

        overridePendingTransition(0, 0);

        textos = new TextView[4][4]; //Creo un array bidimensional de TextViews para poder refrescar la UI con facilidad
        linears = new LinearLayout[4][4];

        score = findViewById(R.id.valorPuntuacion);
        highscore = findViewById(R.id.valorHighscore);
        score.setText(String.valueOf(sharedPref.getInt("score", 0)));
        highscore.setText(String.valueOf(sharedPref.getInt("highscore", 0)));

        row00 = findViewById(R.id.txt_0_0);
        textos[0][0] = row00;
        row01 = findViewById(R.id.txt_0_1);;
        textos[0][1] = row01;
        row02 = findViewById(R.id.txt_0_2);;
        textos[0][2] = row02;
        row03 = findViewById(R.id.txt_0_3);;
        textos[0][3] = row03;
        row10 = findViewById(R.id.txt_1_0);;
        textos[1][0] = row10;
        row11 = findViewById(R.id.txt_1_1);;
        textos[1][1] = row11;
        row12 = findViewById(R.id.txt_1_2);;
        textos[1][2] = row12;
        row13 = findViewById(R.id.txt_1_3);;
        textos[1][3] = row13;
        row20 = findViewById(R.id.txt_2_0);;
        textos[2][0] = row20;
        row21 = findViewById(R.id.txt_2_1);;
        textos[2][1] = row21;
        row22 = findViewById(R.id.txt_2_2);;
        textos[2][2] = row22;
        row23 = findViewById(R.id.txt_2_3);;
        textos[2][3] = row23;
        row30 = findViewById(R.id.txt_3_0);;
        textos[3][0] = row30;
        row31 = findViewById(R.id.txt_3_1);;
        textos[3][1] = row31;
        row32 = findViewById(R.id.txt_3_2);;
        textos[3][2] = row32;
        row33 = findViewById(R.id.txt_3_3);;
        textos[3][3] = row33;

        linearRow00 = findViewById(R.id.linear_0_0);
        linears[0][0] = linearRow00;
        linearRow01 = findViewById(R.id.linear_0_1);
        linears[0][1] = linearRow01;
        linearRow02 = findViewById(R.id.linear_0_2);
        linears[0][2] = linearRow02;
        linearRow03 = findViewById(R.id.linear_0_3);
        linears[0][3] = linearRow03;
        linearRow10 = findViewById(R.id.linear_1_0);
        linears[1][0] = linearRow10;
        linearRow11 = findViewById(R.id.linear_1_1);
        linears[1][1] = linearRow11;
        linearRow12 = findViewById(R.id.linear_1_2);
        linears[1][2] = linearRow12;
        linearRow13 = findViewById(R.id.linear_1_3);
        linears[1][3] = linearRow13;
        linearRow20 = findViewById(R.id.linear_2_0);
        linears[2][0] = linearRow20;
        linearRow21 = findViewById(R.id.linear_2_1);
        linears[2][1] = linearRow21;
        linearRow22 = findViewById(R.id.linear_2_2);
        linears[2][2] = linearRow22;
        linearRow23 = findViewById(R.id.linear_2_3);
        linears[2][3] = linearRow23;
        linearRow30 = findViewById(R.id.linear_3_0);
        linears[3][0] = linearRow30;
        linearRow31 = findViewById(R.id.linear_3_1);
        linears[3][1] = linearRow31;
        linearRow32 = findViewById(R.id.linear_3_2);
        linears[3][2] = linearRow32;
        linearRow33 = findViewById(R.id.linear_3_3);
        linears[3][3] = linearRow33;

        mViewModel.getTablero().observe(this, new Observer<Tablero>() {
            @Override
            public void onChanged(@Nullable Tablero tablero2) {
                if (tablero2 != null) {
                    tablero = tablero2;
                    reiniciarUI();
                }
            }
        });

        //reiniciarUI();


        myTableLayout.setOnTouchListener(new OnSwipeTouchListener(JuegoActivity.this) {
            public void onSwipeTop() {
                //Toast.makeText(JuegoActivity.this, "top", Toast.LENGTH_SHORT).show();
                moverFilaArriba();
                generarNumeroAleatorio ();
                reiniciarUI();
            }
            public void onSwipeRight() {
                //Toast.makeText(JuegoActivity.this, "right", Toast.LENGTH_SHORT).show();
                moverFilaDerecha();
                generarNumeroAleatorio ();
                reiniciarUI();
            }
            public void onSwipeLeft() {
                //Toast.makeText(JuegoActivity.this, "left", Toast.LENGTH_SHORT).show();
                moverFilaIzquierda();
                generarNumeroAleatorio ();
                reiniciarUI();
            }
            public void onSwipeBottom() {
                //Toast.makeText(JuegoActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                moverFilaAbajo();
                generarNumeroAleatorio ();
                reiniciarUI();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        actualizarTablero();

    }

    public void moverFilaDerecha ()
    {
        for (int i = 0; i < tablero.getTabla().length ; i++)
        {
            for (int j = tablero.getTabla()[0].length - 1; j >= 0; j--)
            {
                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (j + 1 < tablero.getTabla()[0].length))
                {
                    if (!(tablero.getTabla()[i][j + 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j + 1])) && (!tablero.getTabla()[i][j].contains("*")))
                    {
                        tablero.getTabla()[i][j + 1] =  String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i][j + 1]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j + 1] + "*";
                        i = 0;
                        j = 3;

                        //Si la casilla actual ha sido mergeada, la siguiente no puede sumarse
                    }

                    else if (tablero.getTabla()[i][j + 1].equals(String.valueOf(0)))
                    {
                        //textos[i][j].startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right));
                        /*
                        linears[i][j].startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right));
                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        textos[i][j + 1].setBackgroundResource(R.drawable.background_tile_1);
                        textos[i][j + 1].setTextColor(getResources().getColor(R.color.fuenteNegra));
                        textos[i][j + 1].setText(tablero.getTabla()[i][j + 1]);
                        i = 0;
                        j = 3;
                        */
                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        i = 0;
                        j = 3;
                    }
                }

            }
        }

        //Eliminar los asteriscos de cada columna
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if (tablero.getTabla()[i][j].contains("*"))
                {
                    tablero.getTabla()[i][j] = tablero.getTabla()[i][j].replace("*", "");
                }
            }
        }
    }

    public void moverFilaIzquierda ()
    {
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (j - 1 >= 0))
                {
                    if ((!tablero.getTabla()[i][j - 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j - 1])) && (!tablero.getTabla()[i][j].contains("*")))
                    {
                        tablero.getTabla()[i][j - 1] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i][j - 1]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i][j - 1] = tablero.getTabla()[i][j - 1] + "*";
                        i = 0;
                        j = 0;
                    }

                    else if (tablero.getTabla()[i][j - 1].equals(String.valueOf(0)))
                    {
                        tablero.getTabla()[i][j - 1] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }

        //Eliminar los asteriscos de cada columna
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if (tablero.getTabla()[i][j].contains("*"))
                {
                    tablero.getTabla()[i][j] = tablero.getTabla()[i][j].replace("*", "");
                }
            }
        }
    }

    public void moverFilaArriba ()
    {
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (i - 1 >= 0))
                {
                    if ((!tablero.getTabla()[i - 1][j].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i - 1][j])) && (!tablero.getTabla()[i][j].contains("*")))
                    {
                        tablero.getTabla()[i - 1][j] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i - 1][j]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i - 1][j] = tablero.getTabla()[i - 1][j] + "*";
                        i = 0;
                        j = 0;
                    }

                    else if (tablero.getTabla()[i - 1][j].equals(String.valueOf(0)))
                    {
                        tablero.getTabla()[i - 1][j] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }

        //Eliminar los asteriscos de cada columna
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if (tablero.getTabla()[i][j].contains("*"))
                {
                    tablero.getTabla()[i][j] = tablero.getTabla()[i][j].replace("*", "");
                }
            }
        }


    }

    public void moverFilaAbajo ()
    {
        for (int i = tablero.getTabla().length - 1; i >= 0 ; i--)
        {
            for (int j = 0; j < tablero.getTabla()[0].length  ; j++)
            {
                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (i + 1 < tablero.getTabla().length))
                {
                    if ((!tablero.getTabla()[i + 1][j].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i + 1][j])) && (!tablero.getTabla()[i][j].contains("*")))
                    {
                        tablero.getTabla()[i + 1][j] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i + 1][j]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i + 1][j] = tablero.getTabla()[i + 1][j] + "*";
                        i = 3;
                        j = 0;

                    }

                    else if (tablero.getTabla()[i + 1][j].equals(String.valueOf(0)))
                    {
                        tablero.getTabla()[i + 1][j] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        i = 3;
                        j = 0;
                    }
                }
            }
        }

        //Eliminar los asteriscos de cada columna
        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if (tablero.getTabla()[i][j].contains("*"))
                {
                    tablero.getTabla()[i][j] = tablero.getTabla()[i][j].replace("*", "");
                }
            }
        }
    }

    public void reiniciarUI ()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (tablero.getTabla()[i][j].equals("0"))
                {
                    textos[i][j].setText("");
                    textos[i][j].setBackgroundResource(R.drawable.background_tile_0);

                }

                else
                {
                    switch (tablero.getTabla()[i][j].length())
                    {
                        case 1: case2:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                            if (Integer.valueOf(tablero.getTabla()[i][j]) == 2)
                            {
                               // textos[i][j].startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right));
                            }
                        break;

                        case 3:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                        break;

                        case 4:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                        break;

                        case 5:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                        break;

                        case 6:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        break;

                        //A ver quien es el listo que llega aquí lol
                        case 7:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        break;

                    }

                    if (Integer.valueOf(tablero.getTabla()[i][j]) <= 2048) {

                        switch (Integer.valueOf(tablero.getTabla()[i][j])) {

                            case 2:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_1);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteNegra));
                                break;

                            case 4:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_2);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteNegra));
                                break;

                            case 8:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_3);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 16:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_4);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 32:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_5);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 64:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_6);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 128:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_7);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 256:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_8);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 512:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_9);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 1024:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_10);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                                break;

                            case 2048:
                                textos[i][j].setBackgroundResource(R.drawable.background_tile_11);
                                textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            break;
                        }
                    }

                    else
                    {
                        textos[i][j].setBackgroundResource(R.drawable.background_tile_12);
                        textos[i][j].setTextColor(getResources().getColor(R.color.fuenteBlanca));
                    }

                    textos[i][j].setText(tablero.getTabla()[i][j]);
                }
            }
        }
    }

    public void generarNumeroAleatorio ()
    {
        Random random = new Random();
        int numeroAleatorio = 0;
        boolean generado = false;
        boolean generar = false;

        for (int i = 0; i < tablero.getTabla().length && !generado; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length && !generado; j++)
            {
                generar = Math.random() < 0.3;

                if (tablero.getTabla()[i][j].equals("0") && generar)
                {
                    numeroAleatorio = (Math.random() >= .9 ? 4 : 2); //Crea un aleatorio ya sea 2 o 4 con un 90% de probabilidad de que sea un 2
                    tablero.getTabla()[i][j] = String.valueOf(numeroAleatorio);
                    generado = true;
                }

                if (i == 3 && j == 3 && !generar)
                {
                    i = 0;
                    j = 0;
                }
            }
        }
    }

    public void aumentarPuntuacion (int aumentar)
    {
        editor.putInt("score", Integer.valueOf(sharedPref.getInt("score", 0)) + aumentar);
        editor.commit();
        score.setText(String.valueOf(sharedPref.getInt("score", 0)));

        Log.d("LogsAndroid", String.valueOf(sharedPref.getInt("score", 0)));

        if (Integer.valueOf(score.getText().toString()) >= Integer.valueOf(highscore.getText().toString()))
        {
            editor.putInt("highscore", sharedPref.getInt("score", 0));
            editor.commit();
            highscore.setText(String.valueOf(sharedPref.getInt("highscore", 0)));
        }
    }

    public void clickReiniciar(View view)
    {
        tablero.rellenarTablero();
        actualizarTablero();
        editor.putInt("score", 0);
        editor.commit();
        score.setText(String.valueOf(sharedPref.getInt("score", 0)));
        highscore.setText(String.valueOf(sharedPref.getInt("highscore", 0)));
        reiniciarUI();
    }

    public void actualizarTablero ()
    {
        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {
                mViewModel.updateTablero(tablero);
                return 1;
            }
        }.execute();
    }
}
