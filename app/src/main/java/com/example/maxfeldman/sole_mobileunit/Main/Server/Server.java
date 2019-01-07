package com.example.maxfeldman.sole_mobileunit.Main.Server;

import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.models.Answer;
import com.example.maxfeldman.sole_mobileunit.Main.models.ContentRequest;
import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MAX FELDMAN on 04/01/2019.
 */

public class Server implements Runnable {


    private final int PORT = 12345;
    private boolean SERVER_IS_RUNNING = true;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private ServerSocket serverSocket;
    private Socket socket;
    private String serverMessage = "standby";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    MainController mainController;


    private Gson gson;
    //private RobotController controller;
    // test

    public Server()
    {
        //controller = RobotController.getInstance();
        gson = new Gson();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public void run() {
        while(SERVER_IS_RUNNING) {
            try {
                serverSocket= new ServerSocket(PORT);
                socket  = serverSocket.accept();
                inputStream = new ObjectInputStream(socket.getInputStream());
                //outputStream = new ObjectOutputStream(socket.getOutputStream());
                String message = null;
                try {
                    message = (String)inputStream.readObject();
                    //ArrayList<MotorRequest> request = new ArrayList<>();
                    Answer answerFromUser = gson.fromJson(message, Answer.class);
                    //// observer to notify MainActivity
                    if(message!=null) {
                        support.firePropertyChange(serverMessage, "standby",message);
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
                    serverSocket.close();

                    //SERVER_IS_RUNNING = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
