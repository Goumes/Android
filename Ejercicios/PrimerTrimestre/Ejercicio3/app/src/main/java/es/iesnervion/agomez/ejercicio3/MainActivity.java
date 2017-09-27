package es.iesnervion.agomez.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void alinear(View view)
    {
        int boton = view.getId();
        EditText texto = (EditText) findViewById(R.id.texto);

        switch (boton)
        {
            case R.id.boton1:
                texto.setGravity(Gravity.LEFT);
                break;
            case R.id.boton2:
                texto.setGravity(Gravity.END);
                break;
        }
    }
}
