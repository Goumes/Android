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
    TextSwitcher [][] switchers;
    String [][] tablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchers = new TextSwitcher[2][4];
        tablero = new String[2][4];
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


        tablero[0][0] = "2";
        tablero[0][1] = "";
        tablero[0][2] = "";
        tablero[0][3] = "";

        tablero[1][0] = "2";
        tablero[1][1] = "";
        tablero[1][2] = "";
        tablero[1][3] = "";

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
    }

    public void click(View view) {
        tablero[0][0] = "2";
        tablero[0][1] = "";
        tablero[0][2] = "";
        tablero[0][3] = "";

        tablero[1][0] = "2";
        tablero[1][1] = "";
        tablero[1][2] = "";
        tablero[1][3] = "";
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
                        delay = 500;
                    } else if (contador == 2)
                    {
                        delay = 1000;
                    }

                    else if (contador == 3)
                    {
                        delay = 1500;
                    }

                    tablero[i][j + 1] = "2";
                    tablero[i][j] = "";

                    new Handler().postDelayed(new Runnable()
                    {
                        int i;
                        int j;

                        @Override
                        public void run()
                        {
                            actualizarUI(i, j);
                        }

                        public Runnable init(int i, int j)
                        {
                            this.i = i;
                            this.j = j;
                            return (this);
                        }
                    }.init(i, j), delay);
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

        switchers[0][0].setText(tablero[0][0]);
        switchers[0][1].setText(tablero[0][1]);
        switchers[0][2].setText(tablero[0][2]);
        switchers[0][3].setText(tablero[0][3]);

        switchers[1][0].setText(tablero[1][0]);
        switchers[1][1].setText(tablero[1][1]);
        switchers[1][2].setText(tablero[1][2]);
        switchers[1][3].setText(tablero[1][3]);
    }

    public void actualizarUI (int i, int j)
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
        switchers[i][j].setText(tablero[i][j]);
        switchers[i][j + 1].setText(tablero[i][j + 1]);

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
