package es.iesnervion.agomez.ejercicio2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiarColor(View view)
    {
        int id = view.getId();

        EditText texto = (EditText) findViewById(R.id.cajon);

        switch (id)
        {
            case R.id.amarillo:
                texto.setTextColor(Color.YELLOW);
                break;
            case R.id.azul:
                texto.setTextColor(Color.BLUE);
                break;
            case R.id.rojo:
                texto.setTextColor(Color.RED);
                break;
        }
    }
}
