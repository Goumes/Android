package com.iesnervion.agomez.a2048.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iesnervion.agomez.a2048.Entities.OnSwipeTouchListener;
import com.iesnervion.agomez.a2048.Entities.Tablero;
import com.iesnervion.agomez.a2048.R;

import java.util.ArrayList;
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
    Tablero tablero;
    TextView [][] textos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        myTableLayout = findViewById(R.id.tableJuego);

        tablero = new Tablero();

        tablero.rellenarTablero();

        overridePendingTransition(0, 0);

        textos = new TextView[4][4]; //Creo un array bidimensional de TextViews para poder refrescar la UI con facilidad

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

        reiniciarUI();


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
                        tablero.getTabla()[i][j] = String.valueOf(0);
                        tablero.getTabla()[i][j + 1] = tablero.getTabla()[i][j + 1] + "*";
                        i = 0;
                        j = 3;

                        //Si la casilla actual ha sido mergeada, la siguiente no puede sumarse
                    }

                    else if (tablero.getTabla()[i][j + 1].equals(String.valueOf(0)))
                    {
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
                    if ((!tablero.getTabla()[i][j - 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j - 1])))
                    {
                        tablero.getTabla()[i][j - 1] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
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
                    if ((!tablero.getTabla()[i - 1][j].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i - 1][j])))
                    {
                        tablero.getTabla()[i - 1][j] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
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
                    if ((!tablero.getTabla()[i + 1][j].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i + 1][j])))
                    {
                        tablero.getTabla()[i + 1][j] = String.valueOf(Integer.valueOf(tablero.getTabla()[i][j]) * 2);
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
        /*
        row00.setText(String.valueOf(tablero.getTabla()[0][0]));
        row01.setText(String.valueOf(tablero.getTabla()[0][1]));
        row02.setText(String.valueOf(tablero.getTabla()[0][2]));
        row03.setText(String.valueOf(tablero.getTabla()[0][3]));
        row10.setText(String.valueOf(tablero.getTabla()[1][0]));
        row11.setText(String.valueOf(tablero.getTabla()[1][1]));
        row12.setText(String.valueOf(tablero.getTabla()[1][2]));
        row13.setText(String.valueOf(tablero.getTabla()[1][3]));
        row20.setText(String.valueOf(tablero.getTabla()[2][0]));
        row21.setText(String.valueOf(tablero.getTabla()[2][1]));
        row22.setText(String.valueOf(tablero.getTabla()[2][2]));
        row23.setText(String.valueOf(tablero.getTabla()[2][3]));
        row30.setText(String.valueOf(tablero.getTabla()[3][0]));
        row31.setText(String.valueOf(tablero.getTabla()[3][1]));
        row32.setText(String.valueOf(tablero.getTabla()[3][2]));
        row33.setText(String.valueOf(tablero.getTabla()[3][3]));
        */

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (tablero.getTabla()[i][j].equals("0"))
                {
                    textos[i][j].setText("");
                }

                else
                {
                    switch (tablero.getTabla()[i][j].length())
                    {
                        case 1: case2:
                            textos[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
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
                generar = random.nextBoolean();

                if (tablero.getTabla()[i][j].equals("0") && generar)
                {
                    numeroAleatorio = (Math.random() >= .9 ? 4 : 2); //Crea un aleatorio ya sea 2 o 4 con un 90% de probabilidad de que sea un 2
                    tablero.getTabla()[i][j] = String.valueOf(numeroAleatorio);
                    generado = true;
                }
            }
        }
    }
}
