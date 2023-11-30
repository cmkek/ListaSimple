
package com.example.listasimple;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //estructura del nodo
    static class Nodo {
        public int dato;
        public Nodo siguiente;

        public Nodo(int valor) {
            dato = valor;
            siguiente = null;
        }
    }

    private Nodo inicio = null;
    private Nodo ultimo = null;
    //en la creacion la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = findViewById(R.id.entrada);

        final Button bt = findViewById(R.id.boton);
//cuando se da click al boton encontrado en el layout "bt"
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se convierte valor de int a string
                int valor = Integer.parseInt(et.getText().toString());
                //se crea nuevo nodo con el valor escrito en el edit text
                Nodo nuevoNodo = new Nodo(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                } else {
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                }
                et.setText("");
                //llamando al metodo actaualizar salida
                actualizarSalida();
            }
        });
    }
    //metodo actualizar salida
    private void actualizarSalida() {
        StringBuilder resultado = new StringBuilder();
        Nodo imp = inicio;
        while (imp != null) {
            resultado.append(imp.dato).append("\n");
            imp = imp.siguiente;
        }
        //del text view encontrado por id en el layout se coloca el dato (int) convertiso a string
        final TextView tv = findViewById(R.id.salida);
        tv.setText(resultado.toString());
    }


}