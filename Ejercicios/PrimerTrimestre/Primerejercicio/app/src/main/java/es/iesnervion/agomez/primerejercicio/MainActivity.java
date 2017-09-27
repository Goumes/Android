package es.iesnervion.agomez.primerejercicio;

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

    public void takeMessage(View view)
    {
        EditText editText = (EditText) findViewById (R.id.Cajon);
        String mensaje = editText.getText().toString();

        TextView textView = (TextView) findViewById (R.id.textView2);
        textView.setText(mensaje);

    }
}
