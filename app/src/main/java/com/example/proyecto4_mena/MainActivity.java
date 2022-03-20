package com.example.proyecto4_mena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText inputTextX;
    EditText inputTextY;
    TextView mostrarXY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextX = (EditText) findViewById(R.id.InputTextX);
        inputTextY = (EditText) findViewById(R.id.InputTextY);
        mostrarXY = (TextView) findViewById(R.id.imprimirCoordenadas);
    }

    public void guardarDatos(View view)
    {
        String valorX = inputTextX.getText().toString();
        String valorY = inputTextY.getText().toString();
        int x = 0;
        int y = 0;

        if(valorX != "" && valorY != "")
        {
            x = Integer.parseInt(valorX);
            y = Integer.parseInt(valorY);
        }

        mostrarXY.setText("X: " + x + " ,Y: " + y);
    }
}