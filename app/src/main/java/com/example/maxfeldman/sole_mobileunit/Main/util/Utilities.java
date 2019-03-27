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

    private JavaNetworkController networkController = JavaNetworkController.getInstance();
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

//    public Request getHappy() {
//
//        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();
//        MotorRequest motorRequest1 = new MotorRequest("1", "C", "200", "70", "1000");
//
//        motorRequests.add(motorRequest1);
//
//
//        final Request request = new Request("1", motorRequests, motorRequests.size());
//
//        return  request;
//    }

    public Request getHappy() {

        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();
        MotorRequest motorRequest1 = new MotorRequest("1", "C", "200", "35", "1000");
        MotorRequest motorRequest2 = new MotorRequest("2", "C", "200", "-35", "0");
        MotorRequest motorRequest3 = new MotorRequest("3", "A", "200", "35", "0");
        MotorRequest motorRequest4 = new MotorRequest("4", "B", "200", "35", "1000");
        MotorRequest motorRequest5 = new MotorRequest("5", "A", "200", "-35", "0");
        MotorRequest motorRequest6 = new MotorRequest("6", "B", "200", "-35", "1000");
        MotorRequest motorRequest7 = new MotorRequest("7", "A", "200", "35", "0");
        MotorRequest motorRequest8 = new MotorRequest("8", "B", "200", "35", "1000");
        MotorRequest motorRequest9 = new MotorRequest("9", "A", "200", "-35", "0");
        MotorRequest motorRequest10 = new MotorRequest("10", "B", "200", "-35", "0");
        motorRequests.add(motorRequest1);
        motorRequests.add(motorRequest2);
        motorRequests.add(motorRequest3);
        motorRequests.add(motorRequest4);
        motorRequests.add(motorRequest5);
        motorRequests.add(motorRequest6);
        motorRequests.add(motorRequest7);
        motorRequests.add(motorRequest8);
        motorRequests.add(motorRequest9);
        motorRequests.add(motorRequest10);

        final Request request = new Request("happy", motorRequests, motorRequests.size());

        return  request;
    }

    public Request getSad() {

        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();
        MotorRequest motorRequest1 = new MotorRequest("1", "C", "20", "40", "3000");
        MotorRequest motorRequest2 = new MotorRequest("2", "C", "20", "-40", "0");


//        MotorRequest motorRequest3 = new MotorRequest("5", "A", "200", "60", "0");
//        MotorRequest motorRequest4 = new MotorRequest("6", "B", "200", "60", "1000");
//        MotorRequest motorRequest5 = new MotorRequest("5", "A", "200", "-60", "0");
//        MotorRequest motorRequest6 = new MotorRequest("6", "B", "200", "-60", "0");
        motorRequests.add(motorRequest1);
        motorRequests.add(motorRequest2);
//        motorRequests.add(motorRequest3);
//        motorRequests.add(motorRequest4);
//        motorRequests.add(motorRequest5);
//        motorRequests.add(motorRequest6);

        final Request request = new Request("sad", motorRequests, motorRequests.size());

        return  request;
    }

    public Request getWaiting() {

        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();

        MotorRequest motorRequest0 = new MotorRequest("1", "A", "0", "0", "0");

//        MotorRequest motorRequest1 = new MotorRequest("1", "A", "200", "50", "0");
//        MotorRequest motorRequest2 = new MotorRequest("2", "B", "200", "50", "1000");
//        MotorRequest motorRequest3 = new MotorRequest("3", "A", "200", "-50", "0");
//        MotorRequest motorRequest4 = new MotorRequest("4", "B", "200", "-50", "1000");
//        MotorRequest motorRequest5 = new MotorRequest("5", "A", "200", "50", "0");
//        MotorRequest motorRequest6 = new MotorRequest("6", "B", "200", "50", "0");
//        motorRequests.add(motorRequest1);
//        motorRequests.add(motorRequest2);
//        motorRequests.add(motorRequest3);
//        motorRequests.add(motorRequest4);
//        motorRequests.add(motorRequest5);
//        motorRequests.add(motorRequest6);

        motorRequests.add(motorRequest0);

        final Request request = new Request("4", motorRequests, motorRequests.size());

        return  request;
    }

    public Request getFunny() {

        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();
        MotorRequest motorRequest1 = new MotorRequest("1", "C", "200", "70", "1000");
        MotorRequest motorRequest2 = new MotorRequest("2", "C", "200", "-70", "0");
        MotorRequest motorRequest3 = new MotorRequest("3", "A", "200", "70", "0");
        MotorRequest motorRequest4 = new MotorRequest("4", "B", "200", "70", "1000");
        MotorRequest motorRequest5 = new MotorRequest("5", "A", "200", "-70", "0");
        MotorRequest motorRequest6 = new MotorRequest("6", "B", "200", "-70", "1000");
        MotorRequest motorRequest7 = new MotorRequest("7", "A", "200", "70", "0");
        MotorRequest motorRequest8 = new MotorRequest("8", "B", "200", "70", "1000");
        MotorRequest motorRequest9 = new MotorRequest("9", "A", "200", "-70", "0");
        MotorRequest motorRequest10 = new MotorRequest("10", "B", "200", "-70", "0");
        motorRequests.add(motorRequest1);
        motorRequests.add(motorRequest2);
        motorRequests.add(motorRequest3);
        motorRequests.add(motorRequest4);
        motorRequests.add(motorRequest5);
        motorRequests.add(motorRequest6);
        motorRequests.add(motorRequest7);
        motorRequests.add(motorRequest8);
        motorRequests.add(motorRequest9);
        motorRequests.add(motorRequest10);

        final Request request = new Request("funny", motorRequests, motorRequests.size());

        return  request;
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

//            case "happy":
//                dao.getCachedSeq("1", new DataListener() {
//                    @Override
//                    public void onDataLoad(Object o) {
//                        request = (Request) o;
//                    }
//                });
////
//                if(request==null){
//                    getRequestWithIndex("1",null);
//                }
//                break;
//            case "sad":
//                dao.getCachedSeq("2", new DataListener() {
//                    @Override
//                    public void onDataLoad(Object o) {
//                        request = (Request) o;
//                    }
//                });
////
//                if(request==null){
//                    getRequestWithIndex("2",null);
//                }
//                break;
//            case "waiting":
//                dao.getCachedSeq("3", new DataListener() {
//                    @Override
//                    public void onDataLoad(Object o) {
//                        request = (Request) o;
//                    }
//                });
////
//                if(request==null){
//                    getRequestWithIndex("3",null);
//                }
//                break;



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

    public void storeRequests(){
        Request request1 = getHappy();
        Request request2 = getSad();
        Request request3 = getFunny();

        fireBase.addFaceEmojiRequest(request1,"happy");
        fireBase.addFaceEmojiRequest(request2,"sad");
        fireBase.addFaceEmojiRequest(request3,"funny");

    }






}

