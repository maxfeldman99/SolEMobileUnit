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


public class MainActivity extends AppCompatActivity implements VideoFragment.OnFragmentInteractionListener,PropertyChangeListener{



    private static String serverMessage = "standby";
    PojoConverter pojoConverter = new PojoConverter();
    MainController mainController = MainController.getInstance();
    Utilities utilities = Utilities.getInstance();
    private boolean loopTest = true;
    Request request;





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

        //VideoFragment fragment = (VideoFragment) getSupportFragmentManager().findFragmentByTag("video");
        //fragment.OnVideoChanged("sad");
        //fragment.newInstance("happy");




//        fireBase.addFaceEmojiRequest(Utilities.getInstance().getHappy(),Utilities.getInstance().getHappy().getId());  // already was added
//        fireBase.addFaceEmojiRequest(Utilities.getInstance().getSad(),Utilities.getInstance().getSad().getId());
//        fireBase.addFaceEmojiRequest(Utilities.getInstance().getFunny(),Utilities.getInstance().getFunny().getId());


//        Request request1 = fireBase.getFaceRequest("req","1");
//        Request request2 = fireBase.getFaceRequest("req","2");
//        Request request3 = fireBase.getFaceRequest("req","3");


//        System.out.println(request2);



        /*

        NetworkController controller = NetworkController.INSTANCE;

        controller.sendDataToIp("192.168.1.32","Hello, World!",null);

        Testing Network Call - Working!

         */




//         //mongoDB section - dont delete.










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
