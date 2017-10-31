package com.example.agomez.listaheterogenea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Reloj> relojes;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relojes = new ArrayList<Reloj>();
        relojes.add(new RelojDigital(1, "modelo1", "marca1", 20.0, "fuente1"));
        relojes.add(new RelojAnalogico (2, "modelo2", "marca2", 20.0, 10));
        relojes.add(new RelojDigital(3, "modelo3", "marca3", 20.0, "fuente2"));
        relojes.add(new RelojDigital(4, "modelo4", "marca4", 20.0, "fuente3"));
        relojes.add(new RelojAnalogico (5, "modelo5", "marca5", 20.0, 10));
        relojes.add(new RelojDigital(6, "modelo6", "marca6", 20.0, "fuente4"));

        final Adapter adaptador = new Adapter(this, R.layout.row_digital, relojes);

        lista = (ListView) findViewById(R.id.list);

        lista.setAdapter(adaptador);

    }


}
