package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.MongoDB;
import com.example.maxfeldman.sole_mobileunit.Main.Server.Server;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;
import com.example.maxfeldman.sole_mobileunit.R;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class MainController {

    private static Server serverController;
    private static VideoController videoController;
    private static MongoDB mongoDB;
    public String ip = null;
    //private static NetworkController networkController;
    private static JavaNetworkController networkController;
    AppCompatActivity mainActivity;
    public String senderIp;
    public int senderPort;


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

        //VideoController videoController = VideoController.getInstance();
        //VideoFragment videoFragment = VideoFragment.newInstance(content);
        //videoController.setVideoFragment(videoFragment,mainActivity);
        videoController.setVideoContent(content);
    }

    public void startServer(){
        Thread thread = new Thread(serverController);
        thread.start();
    }


}
