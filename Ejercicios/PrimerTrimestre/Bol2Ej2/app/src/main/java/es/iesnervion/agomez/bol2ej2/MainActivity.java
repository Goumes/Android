package es.iesnervion.agomez.bol2ej2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onClick(View view) {
            int id = view.getId();
            EditText num1 = (EditText) findViewById(R.id.num1);
            EditText num2 = (EditText) findViewById(R.id.num2);
            TextView resultado = (TextView) findViewById(R.id.resultado);
            double operacion = 0;

            switch (id) {
                case (R.id.sumar):
                    operacion = (Double.parseDouble(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()));
                    resultado.setText(String.valueOf(operacion));
                    break;
                case (R.id.restar):
                    operacion = (Double.parseDouble(num1.getText().toString()) - Integer.parseInt(num2.getText().toString()));
                    resultado.setText(String.valueOf(operacion));
                    break;
                case (R.id.multiplicar):
                    operacion = (Double.parseDouble(num1.getText().toString()) * Integer.parseInt(num2.getText().toString()));
                    resultado.setText(String.valueOf(operacion));
                    break;
                case (R.id.dividir):
                    operacion = (Double.parseDouble(num1.getText().toString()) / Integer.parseInt(num2.getText().toString()));
                    resultado.setText(String.valueOf(operacion));
                    break;
            }
        }
    }
