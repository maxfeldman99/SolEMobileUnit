package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import android.support.v7.app.AppCompatActivity;

import com.example.maxfeldman.sole_mobileunit.Main.Server.Server;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;

import java.net.Socket;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class MainController {

    private static Server serverController;
    private static VideoController videoController;
    public String ip = null;
    //private static NetworkController networkController;
    private static JavaNetworkController networkController;
    AppCompatActivity mainActivity;
    public String senderIp;
    public int senderPort;
    public Socket socket;


    public MainController() {
        this.serverController = new Server(this);
        this.videoController = VideoController.getInstance();
        //this.mongoDB = MongoDB.getInstance();
        this.networkController = JavaNetworkController.getInstance(); // because its written in kotlin
    }

    private static MainController instance = null;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void setMainActivity(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void setVideoFragment(VideoFragment fragment)
    {
        videoController.setVideoFragment(fragment,mainActivity);
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }
    public String getIp()
    {
        return this.ip;
    }

    public void executeVideo(String content){

        videoController.setVideoContent(content);
    }

    public void startServer(){
        Thread thread = new Thread(serverController);
        thread.start();
    }


}
