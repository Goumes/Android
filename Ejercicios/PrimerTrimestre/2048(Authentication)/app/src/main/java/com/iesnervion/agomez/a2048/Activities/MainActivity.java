package com.iesnervion.agomez.a2048.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.Player;
import com.iesnervion.agomez.a2048.R;

public class MainActivity extends AppCompatActivity {

    JuegoActivityViewModel mViewModel;
    Intent actual;
    Player jugador;
    GoogleSignInAccount account;
    Button btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.btnLogOut);

        actual = getIntent();

        if (actual.hasExtra("cuenta"))
        {
            account = actual.getParcelableExtra("cuenta");
        }


        if (account != null)
        {
            btnLogOut.setEnabled(true);
        }


    }

    public void clickJugar(View view)
    {
        Intent i = new Intent (this, JuegoActivity.class);
        if (actual.hasExtra("cuenta"))
        {
            i.putExtra("cuenta", account);
        }
        startActivity(i);
    }

    public void clickPuntuaciones(View view)
    {
        Intent i = new Intent (this, PuntuacionesActivity.class);
        startActivity(i);
    }

    public void clickCerrarSesion(View view)
    {
        Intent i = new Intent(this, IniciarSesionActivity.class);
        i.putExtra("cerrar", true);
        startActivity(i);
        finish();
    }
}
