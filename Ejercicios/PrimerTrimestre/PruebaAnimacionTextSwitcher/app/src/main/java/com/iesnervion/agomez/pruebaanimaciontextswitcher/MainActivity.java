package com.iesnervion.agomez.pruebaanimaciontextswitcher;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;

public class MainActivity extends AppCompatActivity {
    TextSwitcher switcher1;
    TextSwitcher switcher2;
    TextSwitcher switcher3;
    TextSwitcher switcher4;
    TextSwitcher [] switchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchers = new TextSwitcher[4];
        switcher1 =findViewById(R.id.txt_1);
        switchers[0] = switcher1;
        switcher2 =findViewById(R.id.txt_0);
        switchers[1] = switcher2;
        switcher3 =findViewById(R.id.txt_2);
        switchers[2] = switcher3;
        switcher4 =findViewById(R.id.txt_3);
        switchers[3] = switcher4;

        switcher1.setCurrentText("2");
        switcher2.setCurrentText("");
        switcher3.setCurrentText("");
        switcher4.setCurrentText("");
        switcher1.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher1.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher2.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher2.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher3.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher3.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));

        switcher4.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_in));
        switcher4.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_slide_right_out));
    }

    public void click(View view)
    {
        switcher1.setCurrentText("2");//No relevante
        switcher2.setCurrentText("");//No relevante
        switcher3.setCurrentText("");//No relevante
        switcher4.setCurrentText("");//No relevante
        int delay = 0;
        int contador = 0;

        /*
        //Con la J invertida igual que en el juego
        for (int i = switchers.length - 1; i >= 0; i--)
        {
            if ((i - 1 >= 0))
            {
                if (contador == 1)
                {
                    delay = 80;
                }

                else if (contador == 2)
                {
                    delay = 160;
                }
                new Handler().postDelayed(new Runnable() {
                    int i;
                    @Override
                    public void run() {
                        switchers[i].setText(""); // i     j
                        switchers[i - 1].setText("2"); //i     j + 1
                    }
                    public Runnable init(int i) {
                        this.i = i;
                        return(this);
                    }
                }.init(i), delay);

                contador ++;
            }
        }
*/
        //Con la J yendo en su sentido natural

        for (int j = 0; j < switchers.length; j++)
        {
            if ((j + 1 < switchers.length))
            {
                if (contador == 1)
                {
                    delay = 80;
                }

                else if (contador == 2)
                {
                    delay = 160;
                }
                new Handler().postDelayed(new Runnable() {
                    int j;
                    @Override
                    public void run() {
                        switchers[j].setText(""); // i     j
                        switchers[j + 1].setText("2"); //i     j + 1
                    }
                    public Runnable init(int j) {
                        this.j = j;
                        return(this);
                    }
                }.init(j), delay);

                contador ++;
            }
        }


        /*

        //Primera pasada del bucle
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switcher1.setText(""); // i     j
                switcher2.setText("2"); //i     j + 1
            }
        }, 0);

        //Segunda pasada del bucle
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switcher2.setText(""); //i      j
                switcher3.setText("2");//i      j + 1
            }
        }, 80);

        //Tercera pasada del bucle
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switcher3.setText("");//i       j
                switcher4.setText("2");//i      j + 1
            }
        }, 160);
*/
        /*

        switcher1.setCurrentText("");//No relevante
        switcher2.setCurrentText("2");//No relevante
        switcher3.setCurrentText("");//No relevante
        switcher4.setCurrentText("");//No relevante



        //Primera pasada del bucle
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switcher2.setText(""); // i     j
                switcher3.setText("2"); //i     j + 1
            }
        }, 0);

        //Segunda pasada del bucle
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switcher3.setText(""); //i      j
                switcher4.setText("2");//i      j + 1
            }
        }, 80);
        */
    }
}
