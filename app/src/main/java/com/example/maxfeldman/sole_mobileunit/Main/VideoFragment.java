package com.example.maxfeldman.sole_mobileunit.Main;


import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.maxfeldman.sole_mobileunit.R;

public class VideoFragment extends Fragment implements OnDataChangedListener {


    private VideoView videoView;
    private static int wrongTime = 0;
    private final String HAPPY = "happy";
    private final String SAD = "sad";
    private final String FINISH = " finish";
    private final String TEST = "test";
    private final String MY_URI = "android.resource://com.example.maxfeldman.sole_mobileunit/raw/";
    private final String wrong = "wrong";
    private final int SECOND = 1000;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_video, container, false);
       videoView = (VideoView) view.findViewById(R.id.myVideoView);
        return view;
    }


    private void executeVideo(Uri uri,int delayTime){

        videoView.setVideoURI(uri);
        videoView.start();
        videoView.postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {
            }
        }, delayTime);

    }

    @Override
    public void OnVideoChanged(String videoType) {
        Uri uri = null;
        Log.d("video","onVideoChangedddddddddddddddddddddddddddd");

        switch (videoType) {

            case HAPPY:
                uri = Uri.parse(MY_URI + R.raw.correct);
                executeVideo(uri,SECOND*3);
                break;
            case SAD:
                String test = MY_URI + wrong;
                Uri uri3 = Uri.parse(test);
                executeVideo(uri3,SECOND*3);
                break;
            case FINISH:
                uri = Uri.parse(MY_URI + R.raw.youwin);
                executeVideo(uri,SECOND*3);
                break;
            case TEST:
                uri = Uri.parse(MY_URI + R.raw.test);
                executeVideo(uri,SECOND*3);
                break;

        }

    }


}
