package es.iesnervion.agomez.ejercicio1;

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

    public void sumar(View view)
    {
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        String Snum1 = " ";
        String Snum2 = " ";
        String resultados = " ";
        EditText numero1 = (EditText) findViewById(R.id.num1);
        EditText numero2 = (EditText) findViewById(R.id.num2);
        Snum1 = numero1.getText().toString();
        Snum2 = numero2.getText().toString();
        TextView resultado = (TextView) findViewById(R.id.res);

        num1 = Integer.parseInt (Snum1);
        num2 = Integer.parseInt (Snum2);
        res = num1 + num2;
        resultados = Integer.toString(res);

        resultado.setText(resultados);
    }
}
