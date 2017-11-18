package com.iesnervion.agomez.googlemaps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private static final Ciudad[] ciudades={new Ciudad ("Seleccione una ciudad", null, null),
                                            new Ciudad ("Sevilla", "37.3914105", "-5.9591776"),
                                            new Ciudad ("Madrid", "40.4893538", "-3.6827461"),
                                            new Ciudad ("Valladolid", "41.6522966", "-4.7285413"),
                                              new Ciudad ("Almería", "36.7725091", "-2.4277821")};
    Uri gmmIntentUri;
    Intent mapIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin=(Spinner)findViewById(R.id.miSpinner);
        spin.setOnItemSelectedListener(this);
        spin.setSelection(0);

        ArrayAdapter<Ciudad> aa=new ArrayAdapter<Ciudad>(this, android.R.layout.simple_spinner_item, ciudades);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> parent,
                               View v, int position, long id)
    {
        Ciudad ciudad = (Ciudad) parent.getItemAtPosition(position);
        if (ciudad.getLatitud() != null && ciudad.getLongitud() != null) {
            gmmIntentUri = Uri.parse("geo:" + ciudad.getLatitud() + "," + ciudad.getLatitud());
            mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            //mapIntent.setPackage("com.google.android.apps.maps"); //esto hace que simplemente se lanze directamente la aplicación de google maps en vez de darnos a elegir cualquier otra.

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
