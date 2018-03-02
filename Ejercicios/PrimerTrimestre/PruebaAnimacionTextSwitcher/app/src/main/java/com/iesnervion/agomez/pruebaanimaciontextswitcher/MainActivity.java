package com.iesnervion.agomez.pruebaanimaciontextswitcher;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextSwitcher switcher1;
    TextSwitcher switcher2;
    TextSwitcher switcher3;
    TextSwitcher switcher4;
    TextSwitcher switcher5;
    TextSwitcher switcher6;
    TextSwitcher switcher7;
    TextSwitcher switcher8;
    TextSwitcher switcher9;
    TextSwitcher switcher10;
    TextSwitcher switcher11;
    TextSwitcher switcher12;
    TextSwitcher switcher13;
    TextSwitcher switcher14;
    TextSwitcher switcher15;
    TextSwitcher switcher16;

    TextSwitcher [][] switchers;
    String [][] tablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchers = new TextSwitcher[4][4];
        tablero = new String[4][4];

        switcher1 =findViewById(R.id.txt_0_0);
        switchers[0][0] = switcher1;
        switcher2 =findViewById(R.id.txt_0_1);
        switchers[0][1] = switcher2;
        switcher3 =findViewById(R.id.txt_0_2);
        switchers[0][2] = switcher3;
        switcher4 =findViewById(R.id.txt_0_3);
        switchers[0][3] = switcher4;

        switcher5 =findViewById(R.id.txt_1_0);
        switchers[1][0] = switcher5;
        switcher6 =findViewById(R.id.txt_1_1);
        switchers[1][1] = switcher6;
        switcher7 =findViewById(R.id.txt_1_2);
        switchers[1][2] = switcher7;
        switcher8 =findViewById(R.id.txt_1_3);
        switchers[1][3] = switcher8;

        switcher9 =findViewById(R.id.txt_2_0);
        switchers[2][0] = switcher9;
        switcher10 =findViewById(R.id.txt_2_1);
        switchers[2][1] = switcher10;
        switcher11 =findViewById(R.id.txt_2_2);
        switchers[2][2] = switcher11;
        switcher12 =findViewById(R.id.txt_2_3);
        switchers[2][3] = switcher12;

        switcher13 =findViewById(R.id.txt_3_0);
        switchers[3][0] = switcher13;
        switcher14 =findViewById(R.id.txt_3_1);
        switchers[3][1] = switcher14;
        switcher15 =findViewById(R.id.txt_3_2);
        switchers[3][2] = switcher15;
        switcher16 =findViewById(R.id.txt_3_3);
        switchers[3][3] = switcher16;


        tablero[0][0] = "2";
        tablero[0][1] = "";
        tablero[0][2] = "";
        tablero[0][3] = "";

        tablero[1][0] = "2";
        tablero[1][1] = "";
        tablero[1][2] = "";
        tablero[1][3] = "";

        tablero[2][0] = "2";
        tablero[2][1] = "";
        tablero[2][2] = "";
        tablero[2][3] = "";

        tablero[3][0] = "2";
        tablero[3][1] = "";
        tablero[3][2] = "";
        tablero[3][3] = "";

        /*
        switcher1.setCurrentText("2");
        switcher2.setCurrentText("");
        switcher3.setCurrentText("");
        switcher4.setCurrentText("");
        */

        crearUI();

        switcher1.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher1.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher2.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher2.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher3.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher3.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher4.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher4.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher5.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher5.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher6.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher6.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher7.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher7.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher8.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher8.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher9.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher9.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher10.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher10.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher11.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher11.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher12.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher12.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher13.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher13.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher14.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher14.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher15.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher15.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher16.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher16.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
    }

    public void click(View view) {
        tablero[0][0] = "";
        tablero[0][1] = "";
        tablero[0][2] = "";
        tablero[0][3] = "";

        tablero[1][0] = "";
        tablero[1][1] = "";
        tablero[1][2] = "";
        tablero[1][3] = "";

        tablero[2][0] = "2";
        tablero[2][1] = "";
        tablero[2][2] = "";
        tablero[2][3] = "";

        tablero[3][0] = "2";
        tablero[3][1] = "";
        tablero[3][2] = "";
        tablero[3][3] = "";

        crearUI();

        int delay = 0;
        int counter = 0;

        /*
         if (!(tablero.getTabla()[i][j + 1].equals(String.valueOf(0))) && (tablero.getTabla()[i][j].equals(tablero.getTabla()[i][j + 1])) && ((!tablero.getTabla()[i][j].contains("*")) && ((!tablero.getTabla()[i][j + 1].contains("*")))))
                    {
                        if (contador == 1)
                        {
                            delay = 40;
                        }

                        else if (contador == 2)
                        {
                            delay = 80;
                        }

                        else if (contador == 3)
                        {
                            delay = 120;
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

                        i = 0;
                        j = -1;
        */


        //Con la J yendo en su sentido natural

        /*
        int delayAcumulado = 0;
        for (int i = 0; i < switchers.length; i++)
        {
            for (int j = 0; j < switchers[0].length; j++)
            {
                if ((j + 1 < switchers[0].length))
                {
                    Log.d("i", String.valueOf(i));
                    Log.d("j", String.valueOf(j));

                    if (contador == 1)
                    {
                        delay = 40;

                    } else if (contador == 2)
                    {
                        delay = 80;
                    }

                    else if (contador == 3)
                    {
                        delay = 120;
                    }
                    delayAcumulado = delayAcumulado + delay;
                    Log.d("delayAcumulado", String.valueOf(delayAcumulado));

                    tablero[i][j + 1] = "2";
                    tablero[i][j] = "";

                    switchers[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                    switchers[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
                    switchers[i][j + 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                    switchers[i][j + 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));


                    new Handler().postDelayed(new Runnable()
                    {
                        int i;
                        int j;
                        String textoActual;
                        String textoSiguiente;
                        int delay;

                        @Override
                        public void run()
                        {
                            //reiniciarUI(i, j, textoActual, textoSiguiente, 'r');
                            Log.d("iAsync", String.valueOf(i));
                            Log.d("jAsync", String.valueOf(j));
                            Log.d("delayAsync", String.valueOf(delay));
                            actualizarUI(i, j, textoActual, textoSiguiente);
                        }

                        public Runnable init(int i, int j, String textoActual, String textoSiguiente, int delay)
                        {
                            this.i = i;
                            this.j = j;
                            this.textoActual = textoActual;
                            this.textoSiguiente = textoSiguiente;
                            this.delay = delay;
                            return (this);
                        }
                    }.init(i, j, tablero[i][j], tablero[i][j + 1], delayAcumulado), delay);
                    contador++;
                }
            }

            contador = 0;
            delay = 0;
        }
        */
        for (int i = 0; i < switchers.length; i++)
        {
            for (int j = 0; j < switchers[0].length; j++)
            {
                if ((j + 1 < switchers[0].length))
                {
                    if (counter == 1)
                    {
                        delay = 200;
                    }

                    else if (counter == 2)
                    {
                        delay = 400;
                    }

                    else if (counter == 3)
                    {
                        delay = 600;
                    }

                    tablero[i][j + 1] = "2";
                    tablero[i][j] = "0";

                    switchers[i][j].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                    switchers[i][j].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
                    switchers[i][j + 1].setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
                    switchers[i][j + 1].setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));


                    new Handler().postDelayed(new Runnable()
                    {
                        int i;
                        int j;
                        String currentText;
                        String nextText;

                        @Override
                        public void run()
                        {
                            reiniciarUI(i, j, currentText, nextText, 'r');
                        }

                        public Runnable init(int i, int j, String currentText, String nextText)
                        {
                            this.i = i;
                            this.j = j;
                            this.currentText = currentText;
                            this.nextText = nextText;
                            return (this);
                        }
                    }.init(i, j, tablero[i][j], tablero[i][j + 1]), delay);
                    counter++;
                }
            }

            counter = 0;
            delay = 0;
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

    public void configurarCasilla(int i, int j, String valorActual, String tipo)
    {
        if (valorActual.equals("0") && tipo.equals("reiniciar"))
        {
            //((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
            ((TextView)switchers[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_0);
            switchers[i][j].setText("");

        }

        else if (valorActual.equals("0") && tipo.equals("crear"))
        {
            ((TextView)switchers[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_0);
            switchers[i][j].setCurrentText("");
        }

        else
        {
            switch (valorActual.length())
            {
                case 1:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    break;

                //Poniendo case1: case2: me petaba, y los he tenido que separar
                case 2:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    break;

                case 3:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    break;

                case 4:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    break;

                case 5:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    break;

                case 6:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    break;

                //A ver quien es el listo que llega aquí lol
                case 7:
                    ((TextView)switchers[i][j].getChildAt(0)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    ((TextView)switchers[i][j].getChildAt(1)).setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    break;

            }

            if (Integer.valueOf(valorActual) <= 2048) {

                switch (Integer.valueOf(valorActual)) {

                    case 2:

                        if (tipo.equals("crear"))
                        {
                            ((TextView)switchers[i][j].getCurrentView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)switchers[i][j].getCurrentView()).setBackgroundResource(R.drawable.background_tile_1);
                        }
                        else
                        {
                            ((TextView)switchers[i][j].getNextView()).setTextColor(getResources().getColor(R.color.fuenteNegra));
                            ((TextView)switchers[i][j].getNextView()).setBackgroundResource(R.drawable.background_tile_1);
                        }

                        break;

                    case 4:
                        //((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_2);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_2);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
                        break;

                    case 8:
                        //((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_3);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_3);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 16:
                       // ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_4);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_4);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 32:
                        //((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_5);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_5);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 64:
                       // ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_6);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_6);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 128:
                       // ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_7);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_7);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 256:
                      //  ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_8);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_8);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 512:
                      //  ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_9);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_9);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 1024:
                       // ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_10);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_10);
                        ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;

                    case 2048:
                     //   ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_11);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_11);
                        ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                        break;
                }
            }

            else
            {
              //  ((TextView)switchers[i][j].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_12);
                ((TextView)switchers[i][j].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
                ((TextView)switchers[i][j].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_12);
                ((TextView)switchers[i][j].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteBlanca));
            }

            if (tipo.equals("crear"))
            {
                switchers[i][j].setCurrentText(valorActual);
            }
            else if (tipo.equals("reiniciar"))
            {
                switchers[i][j].setText(valorActual);
            }
        }
    }


    public void crearUI ()
    {
        switchers[0][0].setCurrentText(tablero[0][0]);
        switchers[0][1].setCurrentText(tablero[0][1]);
        switchers[0][2].setCurrentText(tablero[0][2]);
        switchers[0][3].setCurrentText(tablero[0][3]);

        switchers[1][0].setCurrentText(tablero[1][0]);
        switchers[1][1].setCurrentText(tablero[1][1]);
        switchers[1][2].setCurrentText(tablero[1][2]);
        switchers[1][3].setCurrentText(tablero[1][3]);

        switchers[2][0].setCurrentText(tablero[2][0]);
        switchers[2][1].setCurrentText(tablero[2][1]);
        switchers[2][2].setCurrentText(tablero[2][2]);
        switchers[2][3].setCurrentText(tablero[2][3]);

        switchers[3][0].setCurrentText(tablero[3][0]);
        switchers[3][1].setCurrentText(tablero[3][1]);
        switchers[3][2].setCurrentText(tablero[3][2]);
        switchers[3][3].setCurrentText(tablero[3][3]);

        switchers[0][0].setText(tablero[0][0]);
        switchers[0][1].setText(tablero[0][1]);
        switchers[0][2].setText(tablero[0][2]);
        switchers[0][3].setText(tablero[0][3]);

        switchers[1][0].setText(tablero[1][0]);
        switchers[1][1].setText(tablero[1][1]);
        switchers[1][2].setText(tablero[1][2]);
        switchers[1][3].setText(tablero[1][3]);

        switchers[2][0].setText(tablero[2][0]);
        switchers[2][1].setText(tablero[2][1]);
        switchers[2][2].setText(tablero[2][2]);
        switchers[2][3].setText(tablero[2][3]);

        switchers[3][0].setText(tablero[3][0]);
        switchers[3][1].setText(tablero[3][1]);
        switchers[3][2].setText(tablero[3][2]);
        switchers[3][3].setText(tablero[3][3]);

        ((TextView)switchers[0][0].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[0][0].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_1);
        ((TextView)switchers[0][0].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[0][0].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_1);

        ((TextView)switchers[0][3].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
        ((TextView)switchers[0][3].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_0);

        ((TextView)switchers[1][0].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[1][0].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_1);
        ((TextView)switchers[1][0].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[1][0].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_1);

        ((TextView)switchers[1][3].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
        ((TextView)switchers[1][3].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_0);

        ((TextView)switchers[2][0].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[2][0].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_1);
        ((TextView)switchers[2][0].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[2][0].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_1);

        ((TextView)switchers[2][3].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
        ((TextView)switchers[2][3].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_0);

        ((TextView)switchers[3][0].getChildAt(0)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[3][0].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_1);
        ((TextView)switchers[3][0].getChildAt(1)).setTextColor(getResources().getColor(R.color.fuenteNegra));
        ((TextView)switchers[3][0].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_1);

        ((TextView)switchers[3][3].getChildAt(0)).setBackgroundResource(R.drawable.background_tile_0);
        ((TextView)switchers[3][3].getChildAt(1)).setBackgroundResource(R.drawable.background_tile_0);
    }

    public void updateUI (int i, int j, String currentText, String nextText)
    {
        int aux = 0;
        //aux = j;
        //j = i;
        //i = aux;
        /*
        for (int i = 0; i < switchers.length; i++)
        {
            for (int j = 0; j < switchers[0].length; j++)
            {
                //if (j + 1 < switchers[0].length) {
                    //if (!((TextView) (switchers[i][j].getNextView())).getText().toString().equals(((TextView) (switchers[i][j].getCurrentView())).getText().toString())) {
                        switchers[i][j].setText(tablero[i][j]);
                    //}
                //}

            }
        }
        */
        switchers[i][j].setText(currentText);
        switchers[i][j + 1].setText(nextText);

        /*
        switchers[0][0].setText(tablero[0][0]);
        switchers[0][1].setText(tablero[0][1]);
        switchers[0][2].setText(tablero[0][2]);
        switchers[0][3].setText(tablero[0][3]);

        switchers[1][0].setText(tablero[1][0]);
        switchers[1][1].setText(tablero[1][1]);
        switchers[1][2].setText(tablero[1][2]);
        switchers[1][3].setText(tablero[1][3]);
        */

    }
}
