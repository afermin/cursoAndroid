package com.example.pruebacurso;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alexander Fermin on 26/01/14.
 */
public class Saludo extends Activity {
    TextView nombre, apellido, cedula;
    Button back;

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.hola);
        Bundle bundle = this.getIntent().getExtras();
        nombre = (TextView) findViewById(R.id.TextNombre);
        nombre.setText(bundle.getString("nombre"));
        apellido = (TextView) findViewById(R.id.TextApellido);
        apellido.setText(bundle.getString("apellido"));
        cedula = (TextView) findViewById(R.id.TextCedula);
        cedula.setText(bundle.getString("cedula"));

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
