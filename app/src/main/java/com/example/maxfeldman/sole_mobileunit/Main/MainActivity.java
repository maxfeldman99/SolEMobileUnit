package com.example.maxfeldman.sole_mobileunit.Main;



import android.net.Uri;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.maxfeldman.sole_mobileunit.Main.Helpers.PojoConverter;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.ImageTestFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.InputTestFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.SessionFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.TestFragment;
import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;
import com.example.maxfeldman.sole_mobileunit.R;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class MainActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener,PropertyChangeListener{



    private static String serverMessage = "standby";
    PojoConverter pojoConverter;
    MainController mainController = MainController.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       // VideoFragment videoFragment = VideoFragment.newInstance("waiting");
        final Fragment videoFragment = new VideoFragment();
        final Fragment sessionFragment = new SessionFragment();
        final Fragment testFragment = new TestFragment();
        final Fragment imageTestFragment = new ImageTestFragment();
        final Fragment inputTestFragment = new InputTestFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();

        mainController.setVideoFragment((VideoFragment) videoFragment);

        //VideoFragment fragment = (VideoFragment) getSupportFragmentManager().findFragmentByTag("video");
        //fragment.OnVideoChanged("sad");
        //fragment.newInstance("happy");

        mainController.startServer();



        /*

        NetworkController controller = NetworkController.INSTANCE;

        controller.sendDataToIp("192.168.1.32","Hello, World!",null);

        Testing Network Call - Working!

         */




        // mongoDB section - dont delete.

//        String uri = "mongodb://solejr:solejr99@cluster0-shard-00-00-moel4.mongodb.net:27017,cluster0-shard-00-01-moel4.mongodb.net:27017,cluster0-shard-00-02-moel4.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";
//        MongoClientURI clientURI = new MongoClientURI(uri);
//        MongoClient mongoClient = new MongoClient(clientURI);
//
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoDB");
//        MongoCollection collection = mongoDatabase.getCollection("1");


//        Request request = new Request();
//        BasicDBObject document = pojoConverter(request);
//        collection.insertOne(new Document(document));



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
