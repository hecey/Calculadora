package com.example.katrina.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private boolean resultado = false;
    private boolean decimal = false;
    private String operacion = "";
    String valorEnPantalla;
    String valorIngresado;

    private Double numeroAlmacenado = 0.0;
    BigDecimal bd1, bd2;
    private BigDecimal numeroAlmacenadoBd;
    //BigDecimal bd1 = new BigDecimal(Double.toString(0.9));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = (TextView) findViewById(R.id.text_display);

    }

    public void buttonClicked(View view) {
        int seleccionado = view.getId();
        Button b = (Button) findViewById(seleccionado);

        valorIngresado = b.getText().toString();
        valorEnPantalla = tvDisplay.getText().toString();


        if (resultado == true) {
            tvDisplay.setText("");
            valorEnPantalla = "";
        }

        try {


            switch (valorIngresado) {

                case "1": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "2": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "3": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "4": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "5": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "6": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "7": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "8": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "9": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "0": {
                    valorEnPantalla += valorIngresado;
                    resultado = false;
                    break;
                }
                case "C": {
                    valorEnPantalla = "";
                    numeroAlmacenado = 0.0;
                    resultado = false;
                    break;

                }
                case ".": {
                    if (decimal == false) {
                        valorEnPantalla += valorIngresado;
                        decimal = true;

                    }
                    break;
                }
                case "+": {
                    if (isDouble(valorEnPantalla)) {

                        decimal = false;
                        tvDisplay.setText("");


                        doOperation(operacion);


                        valorEnPantalla = fmt(numeroAlmacenado);


                        operacion = "";
                        resultado = true;

                    }

                    operacion = "+";
                    break;
                }
                case "-": {
                    if (isDouble(valorEnPantalla)) {

                        decimal = false;
                        tvDisplay.setText("");

                        if (numeroAlmacenado == 0.0) {
                            numeroAlmacenado = Double.valueOf(valorEnPantalla);

                            valorEnPantalla = "";


                        } else {


                            doOperation(operacion);

                            valorEnPantalla = fmt(numeroAlmacenado);
                            operacion = "";
                            resultado = true;

                        }
                    }
                    operacion = "-";

                    break;
                }


            }
        } catch (
                Exception e)

        {
            Log.d("Excepcion", "Error: ", e);
        }


        tvDisplay.setText(valorEnPantalla);


    }

    public void doOperation(String operacion) {

        Double tmp = Double.valueOf(valorEnPantalla);

        bd1 = new BigDecimal(Double.toString(numeroAlmacenado));
        bd2 = new BigDecimal(Double.toString(tmp));
        if (operacion == "+") {


            numeroAlmacenado = Double.valueOf(bd1.add(bd2).toString());
        }
        if (operacion == "-")
            numeroAlmacenado = Double.valueOf(bd1.subtract(bd2).toString());

    }

    public boolean isDouble(String input) {
        try {
            Double.valueOf(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String fmt(double d) {
        if (d == (long) d) {
            d = Math.round(d);
            return String.format("%d", (long) d);
        } else
            return String.format("%s", d);
    }
}
