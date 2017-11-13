package com.example.agomez.intent_ejercicio1;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enviar = (Button) findViewById(R.id.btn1);

        enviar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                Intent i = new Intent ();
                i.setComponent(new ComponentName("com.example.agomez.ejerciciorandom", "com.example.agomez.ejerciciorandom.MainActivity"));
                startActivity(i);
            }
        });



    }

}
