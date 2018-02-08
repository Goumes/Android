package com.iesnervion.agomez.a2048.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.iesnervion.agomez.a2048.Entities.OnSwipeTouchListener;
import com.iesnervion.agomez.a2048.R;

public class JuegoActivity extends AppCompatActivity {

    TableLayout myTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        myTableLayout = findViewById(R.id.tableJuego);

        overridePendingTransition(0, 0);

        myTableLayout.setOnTouchListener(new OnSwipeTouchListener(JuegoActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(JuegoActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(JuegoActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(JuegoActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(JuegoActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
