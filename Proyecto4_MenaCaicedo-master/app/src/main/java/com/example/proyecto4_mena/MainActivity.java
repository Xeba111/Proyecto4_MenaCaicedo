package com.example.proyecto4_mena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    TextView textview;
    EditText inputTextX;
    EditText inputTextY;
    TextView mostrarXY;
    int[] coordenadasX;
    int[] coordenadasY;
    int numeroElementos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.Resultado);
        inputTextX = (EditText) findViewById(R.id.InputTextX);
        inputTextY = (EditText) findViewById(R.id.InputTextY);
        mostrarXY = (TextView) findViewById(R.id.imprimirCoordenadas);
        coordenadasX = new int[20];
        coordenadasY = new int[20];
        numeroElementos = 0;
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

            coordenadasX[numeroElementos] = x;
            coordenadasY[numeroElementos] = y;

            numeroElementos++;
        }

        inputTextX.setText("");
        inputTextY.setText("");
        mostrarXY.setText("X: " + x + " ,Y: " + y);
    }

    public void eliminarDatos(View view)
    {
        numeroElementos = 0;
        coordenadasX = new int[20];
        coordenadasY = new int[20];

        mostrarXY.setText(" ");
    }

    public void updateText(View view){
        double []x= {1,2,3,5,7,8,12,13,16,18};
        double []y={1.3,3.4,5.4,7.2,10.3,9.3,8.9,11,13,12};
        Regresion regresion = new Regresion(x,y);
        regresion.lineal();
    textview.setText("m= "+regresion.a+ "   b= "+regresion.b);
    }

    public class Regresion {
        double []x;
        double []y;
        private int n;          //número de datos
        public double a, b;    //pendiente y ordenada en el origen
        public Regresion(double[] x, double[] y) {
            this.x=x;
            this.y=y;
            n=x.length; //número de datos
        }
        public void lineal(){
            double pxy, sx, sy, sx2, sy2;
            pxy=sx=sy=sx2=sy2=0.0;
            for(int i=0; i<n; i++){
                sx+=x[i];
                sy+=y[i];
                sx2+=x[i]*x[i];
                sy2+=y[i]*y[i];
                pxy+=x[i]*y[i];
            }
            b=(n*pxy-sx*sy)/(n*sx2-sx*sx);
            a=(sy-b*sx)/n;
        }
        public double correlacion(){
//valores medios
            double suma=0.0;
            for(int i=0; i<n; i++){
                suma+=x[i];
            }
            double mediaX=suma/n;

            suma=0.0;
            for(int i=0; i<n; i++){
                suma+=x[i];
            }
            double mediaY=suma/n;
//coeficiente de correlación
            double pxy, sx2, sy2;
            pxy=sx2=sy2=0.0;
            for(int i=0; i<n; i++){
                pxy+=(x[i]-mediaX)*(y[i]-mediaY);
                sx2+=(x[i]-mediaX)*(x[i]-mediaX);
                sy2+=(y[i]-mediaY)*(y[i]-mediaY);
            }
            return pxy/Math.sqrt(sx2*sy2);
        }

    }


}