package es.iesnervion.agomez.ejercicio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiarImagen(View view)
    {
        int boton = view.getId();
        ImageView imagen = (ImageView) findViewById(R.id.imagen);
        int [] ids = {
                R.drawable.android4,
                R.drawable.android5,
                R.drawable.android6
                    };

        switch (boton)
        {
            case R.id.boton1:
                imagen.setImageResource(R.drawable.android4);
                break;
            case R.id.boton2:
                imagen.setImageResource(R.drawable.android6);
                break;
        }
    }
}
