package com.example.maxfeldman.sole_mobileunit.Main;



import android.net.Uri;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.MenuFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;
import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.example.maxfeldman.sole_mobileunit.R;
import com.google.firebase.FirebaseApp;
import com.mongodb.DBObject;

import org.bson.Document;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class MainActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener{



    private static String serverMessage = "standby";
    MainController mainController = MainController.getInstance();
    Utilities utilities = Utilities.getInstance();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        //utilities.storeRequests();



        mainController.setMainActivity(this);

       // VideoFragment videoFragment = VideoFragment.newInstance("waiting");
        final Fragment videoFragment = new VideoFragment();
        final Fragment menuFragment  =  new MenuFragment();



        mainController.startServer();
        utilities.onAppStartup();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();



}




    public static Document getDocument(DBObject doc)
    {
        if(doc == null) return null;
        return new Document(doc.toMap());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }




}
