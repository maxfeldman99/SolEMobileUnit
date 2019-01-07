package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.MongoDB;
import com.example.maxfeldman.sole_mobileunit.Main.Server.Server;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class MainController {

    private Server serverController = new Server();
    //private VideoController videoController = new VideoController();
    private MongoDB mongoDB = new MongoDB();
    private NetworkController networkController;



    public MainController() {

    }

    private static MainController instance = null;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }






}
