package com.example.alumno.clase5;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  Handler.Callback {

    MiHilo hilo;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Handler es una cola de mensajes.
        Handler miHandler = new Handler(this);

        tv = (TextView) findViewById(R.id.txt);
        hilo = new MiHilo(miHandler);
        hilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(hilo.isAlive() == true)
        {
            hilo.interrupt();
        }
    }
    //Basicamente recibe mensajes de un hilo a otro. Y este metodo lee todos los mensajes uno a uno.
    @Override
    public boolean handleMessage(Message msg) {
        Log.d("Aplicacion","Llego Mensaje");
        switch (msg.arg1)
        {
            case 0:
                this.tv.setText(msg.obj.toString());
        }
        return false;
    }
}
