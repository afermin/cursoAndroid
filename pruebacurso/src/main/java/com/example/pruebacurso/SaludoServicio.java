package com.example.pruebacurso;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import static java.lang.Thread.sleep;

/**
 * Created by Alexander Fermin on 26/01/14.
 */
public class SaludoServicio extends Service {

    public String nombre;

    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        nombre = intent.getStringExtra("nombre");
        saludo();
        return START_STICKY;
    }

    public void saludo(){
        for (int i = 0; i < 5; i++){
            tareaLarga();
            Toast.makeText(getBaseContext(), "Hola "+nombre, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }

    /*public static final String ACTION_PROGRESO="En progreso";

    public static final String ACTION_FIN="Ha finalizado";

    public String nombre;

    public SaludoServicio() {
        super("SaludoServicio");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        nombre = intent.getStringExtra("nombre");

        int iter = intent.getIntExtra("iteraciones", 0);

        for(int i=1; i<=iter; i++) {
            tareaLarga();
            //Comunicamos el progreso
            Intent bcIntent = new Intent();
            bcIntent.setAction(ACTION_PROGRESO);
            bcIntent.putExtra("progreso", 100*i/iter);
            sendBroadcast(bcIntent);
        }
        Toast.makeText(this, "Hola "+nombre, Toast.LENGTH_SHORT).show();

        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);
    }

    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

*/
    private void tareaLarga()
    {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }


}
