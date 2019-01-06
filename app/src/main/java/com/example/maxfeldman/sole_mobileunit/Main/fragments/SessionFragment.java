package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.maxfeldman.sole_mobileunit.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class SessionFragment extends Fragment { // this fragment will contain the questions to be asked

    private TextToSpeech mTTS;


    public SessionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_session, container, false);
        Button button = view.findViewById(R.id.test_btn1);
        Button button2 = view.findViewById(R.id.test_btn2);
        Button button3 = view.findViewById(R.id.test_btn3);

        mTTS = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.US);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","not supported language");

                    }else{
                        Log.e("TTS","failed to initalize");
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoFragment videoFragment = VideoFragment.newInstance("happy");
                speak("Hello , my name is SOL-E-JR",0.2f,0.9f);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoFragment videoFragment = VideoFragment.newInstance("sad");
                speak("SELF DESTRUCTION ACTIVATED!",0.2f,0.9f);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoFragment videoFragment = VideoFragment.newInstance("waiting");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();
            }
        });

        return view;
    }

    private void speak(String speechText,float pitch,float speed){
        mTTS.setSpeechRate(speed);
        mTTS.setPitch(pitch);
        mTTS.speak(speechText,TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onDestroy() {
        if(mTTS!=null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
}
