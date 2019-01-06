package com.example.maxfeldman.sole_mobileunit.Main;



import android.net.Uri;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.SessionFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;
import com.example.maxfeldman.sole_mobileunit.R;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class MainActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener,PropertyChangeListener {



    private static String serverMessage = "standby";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // VideoFragment videoFragment = VideoFragment.newInstance("waiting");
        final Fragment videoFragment = new VideoFragment();
        final Fragment sessionFragment = new SessionFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();

        //VideoFragment fragment = (VideoFragment) getSupportFragmentManager().findFragmentByTag("video");
        //fragment.OnVideoChanged("sad");
        //fragment.newInstance("happy");






//        Thread t = new Thread(new Runnable() {                // this part crashes the app when replacing fragment
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.container,sessionFragment).commit();
//
//                // Commit the transaction
//
//            }
//        });
//
//        t.start();


        /*

        NetworkController controller = NetworkController.INSTANCE;

        controller.sendDataToIp("192.168.1.32","Hello, World!",null);

        Testing Network Call - Working!

         */



    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { // this method will lunch different fragments/methods when new data incoming to server
        serverMessage = (String) evt.getNewValue();

        switch (serverMessage) {
            case "A":
                // do
                break;
            case "B":
                // do
                break;
            default:
                break;
        }

    }
}
