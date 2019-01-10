package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.maxfeldman.sole_mobileunit.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    TextToSpeech mTTS;


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test, container, false);

        Button button1 = view.findViewById(R.id.test_btn1);
        Button button2 = view.findViewById(R.id.test_btn2);
        Button button3 = view.findViewById(R.id.test_btn3);
        EditText speechEditText = view.findViewById(R.id.speech_edit_text);
        Button buttonSpeak = view.findViewById(R.id.test_btn_tts);

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
