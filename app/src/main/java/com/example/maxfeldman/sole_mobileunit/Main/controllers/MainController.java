package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.MongoDB;
import com.example.maxfeldman.sole_mobileunit.Main.Server.Server;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class MainController {

    private static Server serverController;
    private static VideoController videoController;
    private static MongoDB mongoDB;
    private static NetworkController networkController;


    public MainController() {
        this.serverController = new Server();
        this.videoController = VideoController.getInstance();
        //this.mongoDB = MongoDB.getInstance();
        this.networkController = NetworkController.INSTANCE; // because its written in kotlin
    }

    private static MainController instance = null;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void setVideoFragment(VideoFragment fragment)
    {
        videoController.setVideoFragment(fragment);
    }

    public void executeVideo(String content){

        VideoController.getInstance().setVideoContent(content);
    }

    public void startServer(){
        Thread thread = new Thread(serverController);
        thread.start();
    }


}
