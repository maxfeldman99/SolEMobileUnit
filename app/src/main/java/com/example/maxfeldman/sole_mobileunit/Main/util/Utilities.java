package com.example.maxfeldman.sole_mobileunit.Main.util;

import android.app.Application;
import android.media.MediaPlayer;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.DataListener;
import com.example.maxfeldman.sole_mobileunit.Main.Helpers.FireBase;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.JavaNetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.models.MotorRequest;
import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.google.gson.Gson;
import com.mapzen.speakerbox.Speakerbox;

import java.util.ArrayList;

public class Utilities {

    private static final Utilities ourInstance = new Utilities();

    private boolean loop = true;
    private MediaPlayer mp;
    private Request request;
    private FireBase fireBase;


    private NetworkController networkController2 = NetworkController.INSTANCE;
    private Dao dao = Dao.getInstance();


    public static Utilities getInstance() {
        return ourInstance;
    }

    private Utilities() {
        fireBase = new FireBase();
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setMediaPlayer(MediaPlayer mp) {
        this.mp = mp;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mp;
    }

    public void sayTTS(final String sentence, final Application application) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Speakerbox speakerbox = new Speakerbox(application);
                speakerbox.play(sentence);


            }
        });

        thread.start();

    }

    public void loopTest(boolean loop) {
        setLoop(loop);

        mp.setLooping(loop);

    }






    public void sendToRobot(String emotion){


            dao.getCachedSeq(emotion, new DataListener() {
                @Override
                public void onDataLoad(Object o) {
                    request = (Request) o;

                    Gson gson = new Gson();
                    String data = gson.toJson(request);
                    //networkController.sendDataToIp("192.168.43.4",data,null);
                    networkController2.sendDataToIp(MainController.getInstance().getIp(),data,null);

                }
            });


    }


    public void onAppStartup(){
        fireBase.getAllRequests("sole_jr_robot_requests",null);

    }

    private void getRequestWithId(String id, final DataListener listener){
        fireBase.getFaceRequest("sole_jr_robot_requests", id, new DataListener() {
            @Override
            public void onDataLoad(Object o) {
                request = (Request) o;
                if(listener != null)
                {
                    listener.onDataLoad(request);
                }
            }
        });


    }



}

