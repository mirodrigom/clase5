package com.example.alumno.clase5;

import android.os.Handler;
import android.os.Message;

/**
 * Created by alumno on 27/09/2018.
 */

public class MiHilo extends Thread
{
    private Handler mainActivityHandler;
    private String url;
    private boolean esTexto;

    public MiHilo(Handler handler, String url, boolean esTexto)
    {
        this.url = url;
        this.esTexto = esTexto;
        this.mainActivityHandler = handler;
    }

    public void run()
    {
        ConnectionManager cm = new ConnectionManager();

        Message msg = new Message();
        //Envia mensajes al hilo en cuestion
        if(this.esTexto == true)
        {
            msg.arg1 = 0;
            msg.obj= new String(cm.obtenerString(this.url));
        }else{
            msg.arg1 = 1;
            msg.obj = cm.obtenerString(this.url);
        }
        this.mainActivityHandler.sendMessage(msg);

    }
}
