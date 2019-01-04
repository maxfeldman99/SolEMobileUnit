package com.example.maxfeldman.sole_mobileunit.Main;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.maxfeldman.sole_mobileunit.R;



public class VideoFragment2 extends Fragment implements OnDataChangedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private VideoView videoView;
    private static int wrongTime = 0;
    private final String HAPPY = "happy";
    private final String SAD = "sad";
    private final String FINISH = " finish";
    private final String TEST = "test";
    private final String MY_URI = "android.resource://com.example.maxfeldman.sole_mobileunit/raw/";
    private final String wrong = "wrong";
    private final int SECOND = 1000;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public VideoFragment2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static VideoFragment2 newInstance(String param1, String param2) {
        VideoFragment2 fragment = new VideoFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // to lock the landscape mode
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video_fragment2, container, false);
        videoView = (VideoView) view.findViewById(R.id.myVideoView);
        chooseEmotion(SAD);


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnVideoChanged(String videoType) {
        chooseEmotion(videoType);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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

    private void chooseEmotion(String videoType){
        Uri uri = null;
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
