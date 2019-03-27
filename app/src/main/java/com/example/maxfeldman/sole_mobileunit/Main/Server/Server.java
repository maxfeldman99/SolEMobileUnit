package com.example.maxfeldman.sole_mobileunit.Main.Server;

import android.util.Log;

import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MAX FELDMAN on 04/01/2019.
 */

public class Server implements Runnable {


    private final int PORT = 1234;
    private boolean SERVER_IS_RUNNING = true;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private ServerSocket serverSocket;
    private Socket socket;
    private String serverMessage = "standby";
    private String serverStatus = "off";
    MainController mainController;


    private Gson gson;
    //private RobotController controller;
    // test

    public Server(MainController mainController)
    {
        this.mainController = mainController;
        //controller = RobotController.getInstance();
        gson = new Gson();
    }




    @Override
    public void run()
    {

       // serverSocket= new ServerSocket(PORT);
       // socket  = serverSocket.accept();

        //inputStream = new ObjectInputStream(socket.getInputStream());
        //outputStream = new ObjectOutputStream(socket.getOutputStream());


        while(SERVER_IS_RUNNING)
        {
            try
            {
                if(serverSocket == null)
                {
                    serverSocket = new ServerSocket(PORT);
                }

                socket  = serverSocket.accept();




                mainController.socket = socket;
                //mainController.senderPort = socket.getLocalPort();



                Log.d("test","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                inputStream = new ObjectInputStream(socket.getInputStream());
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                String message = null;
                try {
                    message = (String)inputStream.readObject();
                }catch (Exception e){
                    e.printStackTrace();
                }
                String compMessage = null;
                String test = "ack";
                try {
                    if(message!=null) {

                        if (message.startsWith("ack")) {
                            String answer = message.substring(3);
                            outputStream.writeObject(answer);
                        }


                        else{
                            Log.e("wtf",message);
                            Utilities.getInstance().loopTest(false);
                            mainController.socket = socket;

                            mainController.executeVideo(message);
                            //outputStream.writeObject("finVideo");


                        }



                    }





                    //controller.executeSequence(request.getSequence());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println("messege: "+str);



            } catch (IOException e) {
                e.printStackTrace();

            } finally {

                try {
                    //serverSocket.close();

                    //SERVER_IS_RUNNING = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
