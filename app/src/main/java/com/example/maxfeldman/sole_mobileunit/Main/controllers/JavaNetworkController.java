package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import android.app.Application;

import com.mapzen.speakerbox.Speakerbox;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

class JavaNetworkController <T> {
    private static final JavaNetworkController ourInstance = new JavaNetworkController();

    static JavaNetworkController getInstance() {
        return ourInstance;
    }

    private JavaNetworkController() {
    }

    public void sendDataToIp(final String ip, final T data, final String type)
    {
        Thread netWorkThread = new Thread(new Runnable() {
            @Override
            public void run()
            {

                try {
                    Socket socket = new Socket(ip,12345);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(data);

                    outputStream.flush();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void sayTTS(final String sentence, final Application application)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Speakerbox speakerbox = new Speakerbox(application);

                speakerbox.play(sentence);


            }
        });

        thread.start();

    }
}
