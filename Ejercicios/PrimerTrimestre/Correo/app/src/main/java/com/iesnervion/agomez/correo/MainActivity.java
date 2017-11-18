package com.iesnervion.agomez.correo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText titulo;
    EditText destinatario;
    EditText correo;
    Intent intentCorreo;
    Uri uri;
    String uriText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnEnviar);
        titulo = (EditText) findViewById(R.id.titulo);
        destinatario = (EditText) findViewById(R.id.destinatario);
        correo = (EditText) findViewById(R.id.correo);
    }

    public void click(View view)
    {
        uriText =
                "mailto:"+destinatario.getText().toString()+
                        "?subject=" + Uri.encode(titulo.getText().toString()) +
                        "&body=" + Uri.encode(correo.getText().toString());

        //Al parecer el putExtra no funciona con ACTION_SENDTO asi que hay que usar una uri directamente y añadirla en el setData.

        uri = Uri.parse(uriText);
        intentCorreo = new Intent(Intent.ACTION_SENDTO);
        intentCorreo.setData(uri);
        /*
        intentCorreo.setType("text/plain");
        intentCorreo.putExtra(Intent.EXTRA_EMAIL, destinatario.getText().toString());
        intentCorreo.putExtra(Intent.EXTRA_SUBJECT, titulo.getText().toString());
        intentCorreo.putExtra(Intent.EXTRA_TEXT, correo.getText().toString());
        */

        if (intentCorreo.resolveActivity(getPackageManager()) != null)
        {
            startActivity (intentCorreo);
        }
    }
}
