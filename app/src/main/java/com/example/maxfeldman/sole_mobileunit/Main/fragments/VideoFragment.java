package com.example.maxfeldman.sole_mobileunit.Main.fragments;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


import com.example.maxfeldman.sole_mobileunit.Main.MainActivity;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.VideoController;
import com.example.maxfeldman.sole_mobileunit.Main.models.OnDataChangedListener;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.example.maxfeldman.sole_mobileunit.R;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class VideoFragment extends Fragment implements OnDataChangedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private VideoView videoView;
    private static int wrongTime = 0;
    private final String HAPPY = "Smile";
    private final String SAD = "sadFace";
    private final String FINISH = " finish";
    private final String TEST = "test";
    private final String MY_URI = "android.resource://com.example.maxfeldman.sole_mobileunit/raw/";
    private final String WRONG = "wrong";
    private final String CORRECT = "correct";
    private final String WAITING = "waiting";
    private final int SECOND = 1000;
    private static int counter = 0;
    private static Uri uri = null;
    private static boolean videoLoop = true;


    private static final String ARG_TEXT = "argText";
    private String currentVideo;
    public VideoController videoController;
    public MainController mainController;




    public static VideoFragment newInstance(String text)
    {
        VideoFragment fragment = new VideoFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TEXT,text);
        fragment.setArguments(args);
        return fragment;

    }



    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // to lock the landscape mode
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        videoController = VideoController.getInstance();

        videoController.setVideoFragment(this);

        View view = inflater.inflate(R.layout.fragment_video_fragment, container, false);
        videoView = view.findViewById(R.id.myVideoView);

        if(getArguments() != null) {
            currentVideo = getArguments().getString(ARG_TEXT);
            chooseEmotion(currentVideo);
        }

        if(currentVideo==null){
            currentVideo=WAITING;
            chooseEmotion(currentVideo);
        }




        // Inflate the layout for this fragment
        return view;
    }




    @Override
    public void OnVideoChanged(String videoType)
    {
        chooseEmotion(videoType);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }





    private void executeVideo(Uri uri, final int delayTime){
        final VideoFragment videoFragment = VideoFragment.newInstance(currentVideo);
        videoView.setVideoURI(uri);
        final Uri temp = uri;

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // this section is for looping
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        if(currentVideo==null){
                            currentVideo = WAITING;
                        }
                       if(currentVideo.equals(WAITING)) {
                           mp.setLooping(true);
                           Utilities.getInstance().setMediaPlayer(mp);
                           Utilities.getInstance().loopTest(true);
                       }


                    }
                });
         videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
         {
             @Override
             public void onCompletion(MediaPlayer mediaPlayer) {
//                 while(videoLoop == true) {
//                     executeVideo(temp, 0);
//                 }

                 mainController = MainController.getInstance();
                 sendVideoFinishedMsg();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, videoFragment).commit();

             }
         });



            videoView.start();
            videoView.postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void run() {


                }
            }, delayTime);


        }


    public void chooseEmotion(String videoType){
        Uri uri = null;
        String pathName = null;
        currentVideo = videoType;
        if(!currentVideo.equals(WAITING)){
            Utilities.getInstance().sendToRobot(currentVideo);
        }
        switch (videoType) {

            case HAPPY:
                pathName = MY_URI + CORRECT ;
                uri = Uri.parse(pathName);
                executeVideo(uri,SECOND*3);
                break;
            case SAD:
                pathName = MY_URI + WRONG;
                uri = Uri.parse(pathName);
                executeVideo(uri,SECOND*3);
                break;
            case WAITING:
                pathName = MY_URI + WAITING ;
                uri = Uri.parse(pathName);
                executeVideo(uri, SECOND * 7);


                break;

        }
    }

    private void sendVideoFinishedMsg(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = MainController.getInstance().socket;
                try {
                    Socket socket1 = new Socket(socket.getInetAddress(),1234);


                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket1.getOutputStream());
                    objectOutputStream.writeObject("finVideo");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }


}
