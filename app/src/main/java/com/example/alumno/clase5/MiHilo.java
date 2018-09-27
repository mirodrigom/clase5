package com.example.alumno.clase5;

import android.os.Handler;
import android.os.Message;

/**
 * Created by alumno on 27/09/2018.
 */

public class MiHilo extends Thread
{
    private Handler mainActivityHandler;

    public MiHilo(Handler handler)
    {
        this.mainActivityHandler = handler;
    }

    public void run()
    {
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = new Message();
        //Envia mensajes al hilo en cuestion
        msg.arg1 = 0;
        msg.obj= "asd";
        this.mainActivityHandler.sendMessage(msg);
    }
}
