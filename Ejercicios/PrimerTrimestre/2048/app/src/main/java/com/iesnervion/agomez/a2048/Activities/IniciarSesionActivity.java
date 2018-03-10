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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.iesnervion.agomez.a2048.R;

public class IniciarSesionActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
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

        mAuth = FirebaseAuth.getInstance();



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        if (actual.hasExtra("cerrar")) {
            avanzar = actual.getExtras().getBoolean("cerrar");
            mGoogleSignInClient.signOut();
            FirebaseAuth.getInstance().signOut();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        //GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("nombre", currentUser.getDisplayName());
            startActivity(i);
            finish ();
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

            if (account != null) {
                firebaseAuthWithGoogle (account);
            }

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("GoogleSignIn", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(getApplicationContext(), "Error al iniciar sesión", Toast.LENGTH_SHORT);
        }
    }

    public void clickInvitado(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        //finish();
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("lol", "firebaseAuthWithGoogle:" + acct.getId());
        Log.d("lol", "firebaseAuthWithGoogle:" + acct.getIdToken());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("lol", "signInWithCredential:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("lol", user.getDisplayName());
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("nombre", user.getDisplayName());
                            startActivity(i);
                            finish ();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("lol", "signInWithCredential:failure", task.getException());
                            Toast.makeText(IniciarSesionActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
