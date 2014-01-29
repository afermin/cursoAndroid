package com.example.pruebacurso;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button aceptar, limpiar;
    ProgressBar progreso;
    EditText nombre, apellido, cedula;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aceptar = (Button) findViewById(R.id.BtnAceptar);
        limpiar = (Button) findViewById(R.id.BtnLimpiar);
        nombre = (EditText) findViewById(R.id.TxtNombre);
        apellido = (EditText) findViewById(R.id.TxtApellido);
        cedula = (EditText) findViewById(R.id.TxtCedula);
        progreso = (ProgressBar) findViewById(R.id.ProgressBar);

        aceptar.setEnabled(false);

        aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getBaseContext(), Saludo.class);
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre.getText().toString());
                bundle.putString("apellido", apellido.getText().toString());
                bundle.putString("cedula", cedula.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nombre.setText("");
                apellido.setText("");
                cedula.setText("");
            }
        });

        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void afterTextChanged(Editable s) {
                actualizarProgreso();
            }
        });
        apellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void afterTextChanged(Editable s) {
                actualizarProgreso();
            }
        });
        cedula.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void afterTextChanged(Editable s) {
                actualizarProgreso();
            }
        });
    }

    public void actualizarProgreso(){
        int acum=0;
        if(!nombre.getText().toString().isEmpty()){
            acum+=100/3;
        }
        if(!apellido.getText().toString().isEmpty()){
            acum+=100/3;
        }
        if(!cedula.getText().toString().isEmpty()){
            acum+=100/3;
        }
        progreso.setProgress(acum);
        if(acum>=99){
            aceptar.setEnabled(true);
        }
        else
            aceptar.setEnabled(false);
    }

}
