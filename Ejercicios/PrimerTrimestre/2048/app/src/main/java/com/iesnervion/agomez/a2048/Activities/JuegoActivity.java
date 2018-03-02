package com.iesnervion.agomez.a2048.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.iesnervion.agomez.a2048.AsyncTasks.MyAsyncTask;
import com.iesnervion.agomez.a2048.Entities.OnSwipeTouchListener;
import com.iesnervion.agomez.a2048.Entities.Tablero;
import com.iesnervion.agomez.a2048.Fragments.DialogFragmentFinPartida;
import com.iesnervion.agomez.a2048.R;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity {

    TableLayout myTableLayout;
    TextSwitcher row00;
    TextSwitcher row01;
    TextSwitcher row02;
    TextSwitcher row03;
    TextSwitcher row10;
    TextSwitcher row11;
    TextSwitcher row12;
    TextSwitcher row13;
    TextSwitcher row20;
    TextSwitcher row21;
    TextSwitcher row22;
    TextSwitcher row23;
    TextSwitcher row30;
    TextSwitcher row31;
    TextSwitcher row32;
    TextSwitcher row33;

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
    TextSwitcher [][] textos;
    TextView score;
    TextView highscore;
    JuegoActivityViewModel mViewModel;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Tablero tableroAuxiliar;

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

        textos = new TextSwitcher[4][4]; //Creo un array bidimensional de TextViews para poder refrescar la UI con facilidad
        linears = new LinearLayout[4][4];

        score = findViewById(R.id.valorPuntuacion);
        highscore = findViewById(R.id.valorHighscore);
        score.setText(String.valueOf(sharedPref.getInt("score", 0)));
        highscore.setText(String.valueOf(sharedPref.getInt("highscore", 0)));

        row00 = findViewById(R.id.txt_0_0);
        textos[0][0] = row00;
        row01 = findViewById(R.id.txt_0_1);
        textos[0][1] = row01;
        row02 = findViewById(R.id.txt_0_2);
        textos[0][2] = row02;
        row03 = findViewById(R.id.txt_0_3);
        textos[0][3] = row03;
        row10 = findViewById(R.id.txt_1_0);
        textos[1][0] = row10;
        row11 = findViewById(R.id.txt_1_1);
        textos[1][1] = row11;
        row12 = findViewById(R.id.txt_1_2);
        textos[1][2] = row12;
        row13 = findViewById(R.id.txt_1_3);
        textos[1][3] = row13;
        row20 = findViewById(R.id.txt_2_0);
        textos[2][0] = row20;
        row21 = findViewById(R.id.txt_2_1);
        textos[2][1] = row21;
        row22 = findViewById(R.id.txt_2_2);
        textos[2][2] = row22;
        row23 = findViewById(R.id.txt_2_3);
        textos[2][3] = row23;
        row30 = findViewById(R.id.txt_3_0);
        textos[3][0] = row30;
        row31 = findViewById(R.id.txt_3_1);
        textos[3][1] = row31;
        row32 = findViewById(R.id.txt_3_2);
        textos[3][2] = row32;
        row33 = findViewById(R.id.txt_3_3);
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

        mViewModel.getTablero().observe(this, new Observer<Tablero>() {
            @Override
            public void onChanged(@Nullable Tablero tablero2) {
                if (tablero2 != null) {
                    tablero = tablero2;
                    crearUI();
                }
            }
        });

        //reiniciarUI();
        myTableLayout.setOnTouchListener(new OnSwipeTouchListener(JuegoActivity.this) {
            public void onSwipeTop() {
                tableroAuxiliar = new Tablero(tablero.getTabla());
                moverFilaArriba();
                if (!tableroAuxiliar.equals(tablero))
                {
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            generarNumeroAleatorio ();
                            if (!comprobarContinuar())
                            {
                                acabarPartida();
                            }
                        }

                    }, 150);
                }

                tableroAuxiliar = new Tablero(tablero.getTabla());
            }
            public void onSwipeRight() {
                tableroAuxiliar = new Tablero(tablero.getTabla());
                moverFilaDerecha();
                if (!tableroAuxiliar.equals(tablero))
                {
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            generarNumeroAleatorio ();
                            if (!comprobarContinuar())
                            {
                                acabarPartida();
                            }
                        }

                    }, 150);
                }

                tableroAuxiliar = new Tablero(tablero.getTabla());
            }
            public void onSwipeLeft() {
                tableroAuxiliar = new Tablero(tablero.getTabla());
                moverFilaIzquierda();
                if (!tableroAuxiliar.equals(tablero))
                {
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            generarNumeroAleatorio ();
                            if (!comprobarContinuar())
                            {
                                acabarPartida();
                            }
                        }

                    }, 150);
                }

                tableroAuxiliar = new Tablero(tablero.getTabla());
            }
            public void onSwipeBottom() {
                tableroAuxiliar = new Tablero(tablero.getTabla());
                moverFilaAbajo();
                if (!tableroAuxiliar.equals(tablero))
                {
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            generarNumeroAleatorio ();
                            if (!comprobarContinuar())
                           {
                                acabarPartida();
                            }
                        }

                    }, 150);
                }

                tableroAuxiliar = new Tablero(tablero.getTabla());
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
        int delay = 0;
        int contador = 0;

        for (int i = 0; i < tablero.getTabla().length ; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length; j++)
            {
                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (j + 1 < tablero.getTabla()[0].length))
                {
                    if (!(tablero.getTabla()[i][j + 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j + 1])) && ((!tablero.getTabla()[i][j].contains("*")) && ((!tablero.getTabla()[i][j + 1].contains("*")))))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[i][j + 1] =  String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i][j + 1]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j + 1] + "*";

                        textos[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                        textos[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
                        textos[i][j + 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.empty));
                        textos[i][j + 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.merge_right));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'r');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(i, j, tablero.getTabla()[i][j], tablero.getTabla()[i][j + 1]), delay);
                        contador++;

                        j = -1;

                        //Si la casilla actual ha sido mergeada, la siguiente no puede sumarse
                    }

                    else if (tablero.getTabla()[i][j + 1].equals(String.valueOf(0)))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        textos[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                        textos[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
                        textos[i][j + 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                        textos[i][j + 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'r');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(i, j, tablero.getTabla()[i][j], tablero.getTabla()[i][j + 1]), delay);
                        contador++;

                        j = -1;
                    }
                }

            }

            contador = 0;
            delay = 0;
        }

        eliminarAsteriscos();
    }

    public void moverFilaIzquierda ()
    {
        int delay = 0;
        int contador = 0;

        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = tablero.getTabla()[0].length - 1; j >= 0 ; j--)
            {

                if ((!tablero.getTabla()[i][j].equals(String.valueOf(0))) && (j - 1 >= 0))
                {
                    if ((!tablero.getTabla()[i][j - 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j - 1])) && ((!tablero.getTabla()[i][j].contains("*")) && (!tablero.getTabla()[i][j - 1].contains("*"))))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        
                        tablero.getTabla()[i][j - 1] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[i][j - 1]));
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i][j - 1] = tablero.getTabla()[i][j - 1] + "*";

                        textos[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_in));
                        textos[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_out));
                        textos[i][j - 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.empty));
                        textos[i][j - 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.merge_left));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'l');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(i, j, tablero.getTabla()[i][j], tablero.getTabla()[i][j - 1]), delay);
                        contador++;
                        j = 4;
                    }

                    else if (tablero.getTabla()[i][j - 1].equals(String.valueOf(0)))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[i][j - 1] = tablero.getTabla()[i][j];
                        tablero.getTabla()[i][j] = String.valueOf(0);

                        textos[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_in));
                        textos[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_out));
                        textos[i][j - 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_in));
                        textos[i][j - 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_left_out));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'l');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(i, j, tablero.getTabla()[i][j], tablero.getTabla()[i][j - 1]), delay);
                        contador++;

                        j = 4;
                    }
                }
            }
            delay = 0;
            contador = 0;
        }

        eliminarAsteriscos();
    }

    public void moverFilaArriba ()
    {
        int delay = 0;
        int contador = 0;

        for (int i = 0; i < tablero.getTabla().length; i++)
        {
            for (int j = tablero.getTabla()[0].length - 1; j >= 0; j--)
            {
                if ((!tablero.getTabla()[j][i].equals(String.valueOf(0))) && (j - 1 >= 0))
                {
                    if ((!tablero.getTabla()[j - 1][i].equals(String.valueOf(0))) && (tablero.getTabla()[j][i].equals(tablero.getTabla()[j - 1][i])) && ((!tablero.getTabla()[j][i].contains("*")) && (!tablero.getTabla()[j - 1][i].contains("*"))))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[j - 1][i] = String.valueOf(Integer.valueOf(tablero.getTabla()[j][i]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[j - 1][i]));
                        tablero.getTabla()[j][i] = String.valueOf(0);
                        tablero.getTabla()[j - 1][i] = tablero.getTabla()[j - 1][i] + "*";

                        textos[j][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_in));
                        textos[j][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_out));
                        textos[j - 1][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.merge_up));
                        textos[j - 1][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.empty));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'u');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(j, i, tablero.getTabla()[j][i], tablero.getTabla()[j - 1][i]), delay);
                        contador++;

                        j = 4;
                    }

                    else if (tablero.getTabla()[j - 1][i].equals(String.valueOf(0)))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        
                        tablero.getTabla()[j - 1][i] = tablero.getTabla()[j][i];
                        tablero.getTabla()[j][i] = String.valueOf(0);

                        textos[j][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_in));
                        textos[j][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_out));
                        textos[j - 1][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_in));
                        textos[j - 1][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_up_out));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'u');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(j, i, tablero.getTabla()[j][i], tablero.getTabla()[j - 1][i]), delay);
                        contador++;

                        j = 4;
                    }
                }
            }
            delay = 0;
            contador = 0;
        }

        eliminarAsteriscos();
    }

    public void moverFilaAbajo ()
    {
        int delay = 0;
        int contador = 0;

        for (int i = 0; i < tablero.getTabla().length ; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length  ; j++)
            {
                if ((!tablero.getTabla()[j][i].equals(String.valueOf(0))) && (j + 1 < tablero.getTabla().length))
                {
                    if ((!tablero.getTabla()[j + 1][i].equals(String.valueOf(0))) && (tablero.getTabla()[j][i].equals(tablero.getTabla()[j + 1][i])) && ((!tablero.getTabla()[j][i].contains("*")) && (!tablero.getTabla()[j + 1][i].contains("*"))))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[j + 1][i] = String.valueOf(Integer.valueOf(tablero.getTabla()[j][i]) * 2);
                        aumentarPuntuacion(Integer.valueOf(tablero.getTabla()[j + 1][i]));
                        tablero.getTabla()[j][i] = String.valueOf(0);
                        tablero.getTabla()[j + 1][i] = tablero.getTabla()[j + 1][i] + "*";

                        textos[j][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_in));
                        textos[j][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_out));
                        textos[j + 1][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.merge_down));
                        textos[j + 1][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.empty));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'd');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(j, i, tablero.getTabla()[j][i], tablero.getTabla()[j + 1][i]), delay);
                        contador++;

                        j = -1;

                    }

                    else if (tablero.getTabla()[j + 1][i].equals(String.valueOf(0)))
                    {
                        if (contador == 1)
                        {
                            delay = 50;
                        }

                        else if (contador == 2)
                        {
                            delay = 100;
                        }

                        else if (contador == 3)
                        {
                            delay = 150;
                        }
                        

                        tablero.getTabla()[j + 1][i] = tablero.getTabla()[j][i];
                        tablero.getTabla()[j][i] = String.valueOf(0);

                        textos[j][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_in));
                        textos[j][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_out));
                        textos[j + 1][i].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_in));
                        textos[j + 1][i].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_down_out));

                        new Handler().postDelayed(new Runnable()
                        {
                            int i;
                            int j;
                            String textoActual;
                            String textoSiguiente;

                            @Override
                            public void run()
                            {
                                reiniciarUI(i, j, textoActual, textoSiguiente, 'd');
                            }

                            public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                            {
                                this.i = i;
                                this.j = j;
                                this.textoActual = textoActual;
                                this.textoSiguiente = textoSiguiente;
                                return (this);
                            }
                        }.init(j, i, tablero.getTabla()[j][i], tablero.getTabla()[j + 1][i]), delay);
                        contador++;

                        j = -1;
                    }
                }
            }
            delay = 0;
            contador = 0;
        }

        eliminarAsteriscos();
    }

    public void crearUI ()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                configurarCasilla(i, j, tablero.getTabla()[i][j], "crear");
            }
        }
    }

    public void configurarCasilla(int i, int j, String valorActual, String tipo)
    {
        if (valorActual.equals("0") && tipo.equals("reiniciar"))
        {
            //((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_0);
            textos[i][j].setText("");

        }

        else if (valorActual.equals("0") && tipo.equals("crear"))
        {
            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_0);
            textos[i][j].setCurrentText("");
        }

        else
        {
            switch (valorActual.length())
            {
                case 1:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    break;

                    //Poniendo case1: case2: me petaba, y los he tenido que separar
                case 2:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    break;

                case 3:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    break;

                case 4:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    break;

                case 5:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    break;

                case 6:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    break;

                //A ver quien es el listo que llega aquí lol
                case 7:
                    ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    break;

            }

            if (Integer.valueOf(valorActual) <= 2048) {

                switch (Integer.valueOf(valorActual)) {

                    case 2:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_1);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_1);
                        }
                        break;

                    case 4:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_2);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_2);
                        }
                        break;

                    case 8:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_3);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_3);
                        }
                        break;

                    case 16:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_4);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_4);
                        }
                        break;

                    case 32:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_5);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_5);
                        }
                        break;

                    case 64:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_6);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_6);
                        }
                        break;

                    case 128:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_7);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_7);
                        }
                        break;

                    case 256:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_8);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_8);
                        }
                        break;

                    case 512:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_9);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_9);
                        }
                        break;

                    case 1024:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_10);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_10);
                        }
                        break;

                    case 2048:
                        if (tipo.equals("crear"))
                        {
                            ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_11);
                        }
                        else
                        {
                            ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                            ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_11);
                        }
                        break;
                }
            }

            else
            {
                if (tipo.equals("crear"))
                {
                    ((TextView)textos[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                    ((TextView)textos[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_12);
                }
                else
                {
                    ((TextView)textos[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                    ((TextView)textos[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_12);
                }
            }

            if (tipo.equals("crear"))
            {
                textos[i][j].setCurrentText(valorActual);
            }
            else if (tipo.equals("reiniciar"))
            {
                textos[i][j].setText(valorActual);
            }
        }
    }

    public void reiniciarUI (int i, int j, String valorActual, String valorSiguiente, char direccion)
    {
        int valorI = 0;
        int valorJ = 0;


        if (valorActual.contains("*") || valorSiguiente.contains("*"))
        {
            valorActual = valorActual.replace("*", "");
            valorSiguiente = valorSiguiente.replace("*", "");
        }

        configurarCasilla(i, j, valorActual, "reiniciar");

        switch (direccion)
        {
            case 'l':
                valorI = i;
                valorJ = j - 1;
                break;

            case 'r':
                valorI = i;
                valorJ = j + 1;
                break;

            case 'u':
                valorI = i - 1;
                valorJ = j;
                break;

            case 'd':
                valorI = i + 1;
                valorJ = j;
                break;
        }

        configurarCasilla(valorI, valorJ, valorSiguiente, "reiniciar");
    }

    public void generarNumeroAleatorio ()
    {
        Random random = new Random();
        int numeroAleatorio = 0;
        boolean generado = false;
        boolean generar = false;
        boolean ending = false;

        for (int i = 0; i < tablero.getTabla().length && !generado; i++)
        {
            for (int j = 0; j < tablero.getTabla()[0].length && !generado; j++)
            {
                generar = Math.random() < 0.3;

                if ((tablero.getTabla()[i][j].equals("0") && generar) || ((tablero.getTabla()[i][j].equals("0") && ending)))
                {
                    numeroAleatorio = (Math.random() >= .9 ? 4 : 2); //Crea un aleatorio ya sea 2 o 4 con un 90% de probabilidad de que sea un 2
                    tablero.getTabla()[i][j] = String.valueOf(numeroAleatorio);

                    animarAparicion(i, j, tablero.getTabla()[i][j]);

                    generado = true;
                }

                if (i == 3 && j == 3 && !generado)
                {
                    i = 0;
                    j = -1;
                    ending = true;
                }
            }
        }
    }

    public void animarAparicion (int i, int j, String valorActual)
    {
        ((TextView)textos[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        ((TextView)textos[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);

        switch (Integer.valueOf(valorActual))
        {
            case 2:
                ((TextView)textos[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                ((TextView)textos[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_1);
                ((TextView)textos[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                ((TextView)textos[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_1);
                break;

            case 4:
                ((TextView)textos[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_2);
                ((TextView)textos[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                ((TextView)textos[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_2);
                ((TextView)textos[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                break;
        }

        textos[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.expand_in));
        textos[i][j].setText(valorActual);

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
        crearUI();
    }

    public void actualizarTablero ()
    {
        MyAsyncTask myAsyncTask = new MyAsyncTask(mViewModel, tablero);
        myAsyncTask.execute();
    }

    public void eliminarAsteriscos ()
    {
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

    public boolean comprobarContinuar ()
    {
        boolean continuar = false;

        //Comprobar movimiento derecha
        for (int i = 0; i < tablero.getTabla().length && !continuar; i++)
        {
            for (int j = 0; j < tablero.getTabla().length && !continuar; j++)
            {
                if (((j + 1 < tablero.getTabla()[0].length) && tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j + 1])) || tablero.getTabla()[i][j].equals("0"))
                {
                    continuar = true;
                }

            }
        }

        //Comprobar movimiento izquierda
        for (int i = 0; i < tablero.getTabla().length && !continuar; i++)
        {
            for (int j = 0; j < tablero.getTabla().length && !continuar; j++)
            {
                if (((j - 1 >= 0) && tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j - 1])) || tablero.getTabla()[i][j].equals("0"))
                {
                    continuar = true;
                }

            }
        }

        //Comprobar movimiento arriba
        for (int i = 0; i < tablero.getTabla().length && !continuar; i++)
        {
            for (int j = 0; j < tablero.getTabla().length && !continuar; j++)
            {
                if (((i - 1 >= 0) && tablero.getTabla()[i][j].equals(tablero.getTabla()[i - 1][j])) || tablero.getTabla()[i][j].equals("0"))
                {
                    continuar = true;
                }

            }
        }

        //Comprobar movimiento abajo
        for (int i = 0; i < tablero.getTabla().length && !continuar; i++)
        {
            for (int j = 0; j < tablero.getTabla().length && !continuar; j++)
            {
                if (((i + 1 < tablero.getTabla().length) && tablero.getTabla()[i][j].equals(tablero.getTabla()[i + 1][j])) || tablero.getTabla()[i][j].equals("0"))
                {
                    continuar = true;
                }

            }
        }



        return continuar;
    }

    public void acabarPartida ()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        DialogFragmentFinPartida dialogFragment = DialogFragmentFinPartida.newInstance (sharedPref.getInt("score", 0));
        dialogFragment.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                tablero.rellenarTablero();
                actualizarTablero();
                editor.putInt("score", 0);
                editor.commit();
                score.setText(String.valueOf(sharedPref.getInt("score", 0)));
                highscore.setText(String.valueOf(sharedPref.getInt("highscore", 0)));
                crearUI();
            }
        });
        dialogFragment.show(ft, "dialog");
    }
}
