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
import com.example.maxfeldman.sole_mobileunit.Main.models.MotorRequest;
import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.example.maxfeldman.sole_mobileunit.R;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener,PropertyChangeListener{



    private static String serverMessage = "standby";
    PojoConverter pojoConverter = new PojoConverter();
    MainController mainController = MainController.getInstance();
    private boolean loopTest = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainController.setMainActivity(this);

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




//         mongoDB section - dont delete.

//        String uri = "mongodb://solejr:solejr99@cluster0-shard-00-00-moel4.mongodb.net:27017,cluster0-shard-00-01-moel4.mongodb.net:27017,cluster0-shard-00-02-moel4.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";
//        MongoClientURI clientURI = new MongoClientURI(uri);
//        MongoClient mongoClient = new MongoClient(clientURI);
//
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoDB");
//        MongoCollection collection = mongoDatabase.getCollection("1");
//
//        // just a test request to check if upload is working
//        Request request = new Request();
//        ArrayList<MotorRequest> motorRequests = new ArrayList<>();
//        MotorRequest motorRequest = new MotorRequest("1","1234","100","90","0");
//        MotorRequest motorRequest2 = new MotorRequest("2","1234","100","90","0");
//        motorRequests.add(motorRequest);
//        motorRequests.add(motorRequest2);
//        request.setSequence(motorRequests);
//        request.setId("1");
//
//        DBObject document = null;
//        Document document1 = new Document();
//
//        try {
//            document1 = pojoConverter.PojoToJson(request);
//            //document1 = getDocument(document);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(document1.toString());
//
//        try {
//            Request request2 = pojoConverter.JsonToPojo();
//            System.out.println(request2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if(collection!=null && document1!=null) {
//
//           collection.find().toString();
//           collection.insertOne(document1);
//        }
//

    }

    public void loopTest(boolean loop){
        loopTest = loop;
    }


    public static Document getDocument(DBObject doc)
    {
        if(doc == null) return null;
        return new Document(doc.toMap());
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
