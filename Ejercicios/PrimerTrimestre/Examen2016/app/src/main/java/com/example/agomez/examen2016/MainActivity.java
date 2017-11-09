package com.example.agomez.examen2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Team> teams ;
    ArrayList<String> items;
    ListView lista;
    ArrayAdapter<String> adapter;
    Spinner spinner;
    Adapter adaptador;
    AutoCompleteTextView autoComplete;
    int contador;
    Button button;
    Gestora gestora;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams = new ArrayList<Team>();
        items = new ArrayList<String>();
        button = (Button) this.findViewById(R.id.addBtn);
        gestora = new Gestora();


        teams.add(new Team (1, "Blazzers", R.drawable.blazzers));
        teams.add(new Team (2, "Bucks", R.drawable.bucks));
        teams.add(new Team (3, "Bulls", R.drawable.bulls));
        teams.add(new Team (4, "Cavaliers", R.drawable.cavaliers));
        teams.add(new Team (5, "Celtics", R.drawable.celtics));
        teams.add(new Team (6, "Clippers", R.drawable.clippers));
        teams.add(new Team (7, "Ers", R.drawable.ers));
        teams.add(new Team (8, "Grizzlies", R.drawable.grizzlies));
        teams.add(new Team (9, "Hawks", R.drawable.hawks));
        teams.add(new Team (10, "Heat", R.drawable.heat));
        teams.add(new Team (11, "Hornets", R.drawable.hornets));
        teams.add(new Team (12, "Jazz", R.drawable.jazz));
        teams.add(new Team (13, "Kings", R.drawable.kings));
        teams.add(new Team (14, "Knicks", R.drawable.knicks));
        teams.add(new Team (15, "Lakers", R.drawable.lakers));
        teams.add(new Team (16, "Magic", R.drawable.magic));
        teams.add(new Team (17, "Maverics", R.drawable.mavericks));
        teams.add(new Team (18, "Nets", R.drawable.nets));
        teams.add(new Team (19, "Nuggets", R.drawable.nuggets));
        teams.add(new Team (20, "Pacers", R.drawable.pacers));
        teams.add(new Team (21, "Pelicans", R.drawable.pelicans));
        teams.add(new Team (22, "Pistons", R.drawable.pistons));
        teams.add(new Team (23, "Raptors", R.drawable.raptors));
        teams.add(new Team (24, "Rockets", R.drawable.rockets));
        teams.add(new Team (25, "Spurs", R.drawable.spurs));
        teams.add(new Team (26, "Suns", R.drawable.suns));
        teams.add(new Team (27, "Thunders", R.drawable.thunders));
        teams.add(new Team (28, "Warriors", R.drawable.warriors));
        teams.add(new Team (29, "Wizards", R.drawable.wizards));
        teams.add(new Team (30, "Wolves", R.drawable.wolves));

        lista = (ListView) findViewById(R.id.list);
        adaptador = new Adapter(this, R.layout.row, teams);
        lista.setAdapter(adaptador);

        contador = 0;


        spinner = (Spinner) this.findViewById(R.id.spinner);

        aa=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, TEAMS);
        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        autoComplete.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String txtEquipo = autoComplete.getText().toString();

                if (contador < 4) {

                    if (!gestora.comprobarNombreEquipo (txtEquipo, teams))
                    {
                        Toast.makeText(getApplicationContext(), "Este equipo no existe", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        items.add(txtEquipo);

                        /*

                        aa = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, items);
                        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(aa);

                        */ //NO ES NECESARIO CRACK

                        contador++;
                    }
                }

                else
                {
                    button.setClickable(false);
                }
            }
        });


        //Creo que lo que hay que hacer es crear el spinner y buscar el autocompletetextview dentro de un listener
        //En vez de en un onClick ();


    }

    private static final String[] TEAMS = new String[] {
            "Blazzers", "Bucks","Bulls","Cavaliers", "Celtics", "Clippers", "Ers", "Grizzlies", "Hawks",
            "Heat",  "Hornets",  "Jazz", "Kings", "Knicks",  "Lakers", "Magic", "Maverics",  "Nets",
            "Nuggets", "Pacers", "Pelicans", "Pistons", "Raptors", "Rockets", "Spurs", "Suns",
            "Thunders",  "Warriors", "Wizards", "Wolves"
    };
}
