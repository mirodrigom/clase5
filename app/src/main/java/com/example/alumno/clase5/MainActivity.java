package com.example.alumno.clase5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  Handler.Callback {

    MiHilo hiloUno;
    MiHilo hiloDos;
    MiHilo hiloTres;
    TextView tv;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Handler es una cola de mensajes.
        Handler miHandler = new Handler(this);

        tv = (TextView) findViewById(R.id.txt);
        imgv = (ImageView) findViewById(R.id.imgv);
        //final String urlStringTexto = "http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml";
        final String urlStringTexto = "http://192.168.3.79:8080/personas.xml";
        final String urlStringJSON = "http://192.168.3.135:8080/personas.json";
        final String urlStringImagen = "http://cdn5.nuevachevallier.com/wp-content-test/uploads/2017/11/HOTELES.jpg";
        //hiloUno = new MiHilo(miHandler,urlStringTexto,true,"xml");
        hiloDos = new MiHilo(miHandler,urlStringImagen,false,"");
        hiloTres = new MiHilo(miHandler,urlStringJSON,true,"json");
        //hiloUno.start();
        hiloDos.start();
        hiloTres.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(hiloUno.isAlive() == true)
        {
            hiloUno.interrupt();
        }
        if(hiloDos.isAlive() == true)
        {
            hiloDos.interrupt();
        }
        if(hiloTres.isAlive() == true)
        {
            hiloTres.interrupt();
        }
    }
    //Basicamente recibe mensajes de un hilo a otro. Y este metodo lee todos los mensajes uno a uno.
    @Override
    public boolean handleMessage(Message msg) {
        Log.d("Aplicacion","Llego Mensaje");
        if(msg.obj != null)
        {
            switch (msg.arg1)
            {
                case 0:
                    List<Personas> lista_personas = (List<Personas>) msg.obj;
                    this.tv.setText(lista_personas.get(1).getPhone());
                    //this.tv.setText(msg.obj.toString());
                    break;
                case 1:
                    byte[] bytes = (byte[])msg.obj;
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    imgv.setImageBitmap(bitmap);
                    break;
            }
        }
        return false;
    }
}
