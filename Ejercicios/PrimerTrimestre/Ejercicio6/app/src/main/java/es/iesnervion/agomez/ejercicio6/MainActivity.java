package es.iesnervion.agomez.ejercicio6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageButton imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = (ImageButton) findViewById(R.id.imagen);
        imagen.setOnClickListener (this);
    }



    @Override
    public void onClick(View view)
    {
        if ((String) imagen.getTag() == "nice")
        {
            imagen.setImageResource(R.drawable.nice2);
            imagen.setTag("nice2");
        }

        else
        {
            imagen.setImageResource(R.drawable.nice);
            imagen.setTag("nice");
        }
    }
}
