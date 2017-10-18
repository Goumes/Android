package com.example.agomez.ejerciciorandom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String cadena1 = "";
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Si es una ListActivity no es necesario.
    }

    public void onClick(View view) //Dividir en métodos por separado.
    {
        int id = view.getId();
        TextView resultado = (TextView) findViewById(R.id.resultado);
        String resultadoString = resultado.getText().toString();
        Double resultadoOperacion = 0.0;
        int resultadoOperacionInt = 0;

        switch (id)
        {
            case R.id.N1:
                resultado.setText(resultadoString + 1);
                break;

            case R.id.N2:
                resultado.setText(resultadoString + 2);
                break;

            case R.id.N3:
                resultado.setText(resultadoString + 3);
                break;

            case R.id.N4:
                resultado.setText(resultadoString + 4);
                break;

            case R.id.N5:
                resultado.setText(resultadoString + 5);
                break;

            case R.id.N6:
                resultado.setText(resultadoString + 6);
                break;

            case R.id.N7:
                resultado.setText(resultadoString + 7);
                break;

            case R.id.N8:
                resultado.setText(resultadoString + 8);
                break;

            case R.id.N9:
                resultado.setText(resultadoString + 9);
                break;

            case R.id.N0:
                resultado.setText(resultadoString + 0);
                break;

            case R.id.limpiar:
                resultado.setText("");
                cadena1 = "";
                break;

            case R.id.borrar:
                resultado.setText(resultadoString.substring(0, resultadoString.length() - 1));
                break;

            case R.id.dividir:
                //Creo que no hace falta comprobar en el caso de sumar repetidas veces
                cadena1 = resultadoString;
                resultado.setText("");
                operacion = "/";
                break;

            case R.id.multiplicar:
                //Creo que no hace falta comprobar en el caso de sumar repetidas veces
                cadena1 = resultadoString;
                resultado.setText("");
                operacion = "*";

                break;

            case R.id.sumar:
                //Creo que no hace falta comprobar en el caso de sumar repetidas veces
                cadena1 = resultadoString;
                resultado.setText("");
                operacion = "+";
                break;

            case R.id.restar:
                //Creo que no hace falta comprobar en el caso de sumar repetidas veces
                cadena1 = resultadoString;
                resultado.setText("");
                operacion = "-";
                break;

            case R.id.coma:
                resultado.setText(resultadoString + ".");
                break;

            case R.id.igual:

                switch (operacion)
                {
                    case "+":

                        resultadoOperacion = Double.parseDouble(cadena1) + Double.parseDouble(resultadoString);

                        if (String.valueOf (resultadoOperacion).substring(String.valueOf(resultadoOperacion).length() - 2).equals(".0"))
                        {
                            resultadoOperacionInt = resultadoOperacion.intValue();
                            resultado.setText(String.valueOf(resultadoOperacionInt));
                        }

                        else
                        {
                            resultado.setText(String.valueOf(resultadoOperacion));
                        }



                        break;

                    case "-":
                        resultadoOperacion = Double.parseDouble(cadena1) - Double.parseDouble(resultadoString);

                        if (String.valueOf (resultadoOperacion).substring(String.valueOf(resultadoOperacion).length() - 2).equals(".0"))
                        {
                            resultadoOperacionInt = resultadoOperacion.intValue();
                            resultado.setText(String.valueOf(resultadoOperacionInt));
                        }

                        else
                        {
                            resultado.setText(String.valueOf(resultadoOperacion));
                        }

                    case "*":
                        resultadoOperacion = Double.parseDouble(cadena1) * Double.parseDouble(resultadoString);

                        if (String.valueOf (resultadoOperacion).substring(String.valueOf(resultadoOperacion).length() - 2).equals(".0"))
                        {
                            resultadoOperacionInt = resultadoOperacion.intValue();
                            resultado.setText(String.valueOf(resultadoOperacionInt));
                        }

                        else
                        {
                            resultado.setText(String.valueOf(resultadoOperacion));
                        }
                        break;

                    case "/":
                        resultadoOperacion = Double.parseDouble(cadena1) / Double.parseDouble(resultadoString);

                        if (String.valueOf (resultadoOperacion).substring(String.valueOf(resultadoOperacion).length() - 2).equals(".0"))
                        {
                            resultadoOperacionInt = resultadoOperacion.intValue();
                            resultado.setText(String.valueOf(resultadoOperacionInt));
                        }

                        else
                        {
                            resultado.setText(String.valueOf(resultadoOperacion));
                        }

                        break;
                }

                break;
        }
    }
}
