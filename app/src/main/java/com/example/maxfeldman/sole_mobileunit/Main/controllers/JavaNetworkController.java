package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JavaNetworkController <T> {
    private static final JavaNetworkController ourInstance = new JavaNetworkController();

    public static JavaNetworkController getInstance() {
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

}
