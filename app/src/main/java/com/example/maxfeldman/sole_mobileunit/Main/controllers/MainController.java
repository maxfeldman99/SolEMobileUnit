package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.MongoDB;
import com.example.maxfeldman.sole_mobileunit.Main.Server.Server;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class MainController {

    private static Server serverController;
    private static VideoController videoController;
    private static MongoDB mongoDB;
    private static NetworkController networkController;


    public MainController(Server serverController, VideoController videoController, MongoDB mongoDB, NetworkController networkController) {
        this.serverController = serverController;
        this.videoController = videoController;
        this.mongoDB = mongoDB;
        this.networkController = networkController;
    }

    private static MainController instance = null;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController(serverController,);
        }
        return instance;
    }

    public void executeVideo(String content){
        VideoController.getInstance().setVideoContent(content);
    }


}
