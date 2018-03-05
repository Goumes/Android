package com.iesnervion.agomez.a2048.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.iesnervion.agomez.a2048.R;

public class IniciarSesionActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    boolean avanzar;
    final int RC_SIGN_IN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciarsesion_activity);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        Intent actual = getIntent();



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        if (actual.hasExtra("cerrar"))
        {
            avanzar = actual.getExtras().getBoolean("cerrar");
            mGoogleSignInClient.signOut();
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            // PlayersClient cliente = Games.getPlayersClient(this, account);

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("cuenta", account);
            startActivity(i);
            finish();
        /*
        Task<Player> task = cliente.getCurrentPlayer();
        task.addOnCompleteListener(this, new OnCompleteListener<Player>() {
            @Override
            public void onComplete(@NonNull Task<Player> task) {
                if (task.isSuccessful())
                {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("jugador", task.getResult());
                    startActivity(i);
                }
            }
        });
        */
            }

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            //PlayersClient cliente = Games.getPlayersClient(this, account);

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("cuenta", account);
            startActivity(i);
            finish();


            /*
            Task<Player> task = cliente.getCurrentPlayer();
            task.addOnCompleteListener(this, new OnCompleteListener<Player>() {
                @Override
                public void onComplete(@NonNull Task<Player> task) {
                    if (task.isSuccessful())
                    {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("jugador", task.getResult());
                        startActivity(i);
                    }
                }
            });
*/
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("GoogleSignIn", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(getApplicationContext(), "Error al iniciar sesión", Toast.LENGTH_SHORT);
        }
    }

    public void clickInvitado(View view)
    {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
