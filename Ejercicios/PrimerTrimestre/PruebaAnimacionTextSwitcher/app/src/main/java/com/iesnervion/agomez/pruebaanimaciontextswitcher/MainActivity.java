package com.iesnervion.agomez.pruebaanimaciontextswitcher;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;

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
        int contador = 0;


        //Con la J yendo en su sentido natural

        for (int i = 0; i < switchers.length; i++)
        {
            for (int j = 0; j < switchers[0].length; j++)
            {
                if ((j + 1 < switchers[0].length))
                {
                    if (contador == 1)
                    {
                        delay = 80;
                    } else if (contador == 2)
                    {
                        delay = 160;
                    }

                    else if (contador == 3)
                    {
                        delay = 240;
                    }

                    tablero[i][j + 1] = "2";
                    tablero[i][j] = "";

                    new Handler().postDelayed(new Runnable()
                    {
                        int i;
                        int j;
                        String textoActual;
                        String textoSiguiente;

                        @Override
                        public void run()
                        {
                            actualizarUI(i, j, textoActual, textoSiguiente);
                        }

                        public Runnable init(int i, int j, String textoActual, String textoSiguiente)
                        {
                            this.i = i;
                            this.j = j;
                            this.textoActual = textoActual;
                            this.textoSiguiente = textoSiguiente;
                            return (this);
                        }
                    }.init(i, j, tablero[i][j], tablero[i][j + 1]), delay);
                    contador++;
                }
            }

            contador = 0;
            delay = 0;
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
    }

    public void actualizarUI (int i, int j, String textoActual, String textoSiguiente)
    {
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
        switchers[i][j].setText(textoActual);
        switchers[i][j + 1].setText(textoSiguiente);

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
