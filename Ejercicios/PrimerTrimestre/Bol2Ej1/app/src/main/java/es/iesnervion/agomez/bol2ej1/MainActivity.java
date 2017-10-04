package es.iesnervion.agomez.bol2ej1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkBoxClick(View view)
    {
        int id = view.getId();
        TextView texto = (TextView) findViewById(R.id.texto);
        CheckBox negrita = (CheckBox) findViewById(R.id.negrita);
        CheckBox enrojecer = (CheckBox) findViewById(R.id.enrojecer);
        CheckBox agrandar = (CheckBox) findViewById(R.id.agrandar);
        CheckBox reducir = (CheckBox) findViewById(R.id.reducir);

        switch (id)
        {
            case R.id.negrita:
                if (negrita.isChecked())
                {
                    texto.setTypeface(Typeface.DEFAULT_BOLD);
                }
                else
                {
                    texto.setTypeface(Typeface.DEFAULT);
                }
                break;
            case R.id.agrandar:
                if (agrandar.isChecked())
                {
                    reducir.setChecked(false);
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
                }

                else
                {
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                }

                break;
            case R.id.reducir:
                /*
                if (reducir.isChecked() && !agrandar.isChecked())
                {
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                }
                else if (!reducir.isChecked() && !agrandar.isChecked())
                {
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                }

                else if (!reducir.isChecked() && agrandar.isChecked())
                {
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
                }
                */

                if (reducir.isChecked())
                {
                    agrandar.setChecked(false);
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                }

                else
                {
                    texto.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                }
                break;
            case R.id.enrojecer:
                if (enrojecer.isChecked())
                {
                    texto.setTextColor(Color.RED);
                }
                else
                {
                    texto.setTextColor(Color.BLACK);
                }


                break;
        }
    }
}
