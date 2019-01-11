package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.R;
import com.google.gson.Gson;
import com.max.michael.robotviewunit.models.MotorRequest;
import com.max.michael.robotviewunit.models.Request;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageTestFragment extends Fragment {


    private TextToSpeech mTTS;
    private int counter = 3;




    public ImageTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_test, container, false);
        ImageButton button1 = view.findViewById(R.id.im_btn_1);
        ImageButton button2 = view.findViewById(R.id.im_btn_2);
        ImageButton button3 = view.findViewById(R.id.im_btn_3);
        ImageButton button4 = view.findViewById(R.id.im_btn_4);
        final TextView mistakes = view.findViewById(R.id.text_mistakes_counter);


        /// motor section

        final ArrayList<MotorRequest> motorRequests = new ArrayList<>();
        MotorRequest motorRequest1 = new MotorRequest("1","A","200","100","0");
        MotorRequest motorRequest2 = new MotorRequest("2","B","200","100","1000");
        MotorRequest motorRequest3 = new MotorRequest("3","A","200","-100","0");
        MotorRequest motorRequest4 = new MotorRequest("4","B","200","-100","1000");
        MotorRequest motorRequest5 = new MotorRequest("5","A","200","100","0");
        MotorRequest motorRequest6 = new MotorRequest("6","B","200","100","0");
        motorRequests.add(motorRequest1);
        motorRequests.add(motorRequest2);
        motorRequests.add(motorRequest3);
        motorRequests.add(motorRequest4);
        motorRequests.add(motorRequest5);
        motorRequests.add(motorRequest6);

        final Request request = new Request("1",motorRequests,motorRequests.size());

        Gson gson = new Gson();
        final String tosend = gson.toJson(request);




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



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test_execute(tosend,"happy","CORRECT! YOU WIN!");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                mistakes.setText(String.valueOf(counter));
                checkCounterStatus(tosend);


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                mistakes.setText(String.valueOf(counter));
                checkCounterStatus(tosend);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                mistakes.setText(String.valueOf(counter));
                checkCounterStatus(tosend);
            }
        });


        return view;
    }

    private void test_execute(String tosend,String face,String speechText){
        VideoFragment videoFragment = VideoFragment.newInstance(face);
        speak(speechText,0.2f,0.9f);
        NetworkController controller = NetworkController.INSTANCE;
        controller.sendDataToIp("192.168.43.4",tosend,null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();

    }

    private void checkCounterStatus(String tosend){
        if(counter!=0) {
            speak("try again", 0.2f, 0.9f);
        }else{
            counter = 3;
            test_execute(tosend,"sad","Maybe next time");
        }
    }

    private void speak(String speechText,float pitch,float speed){
        mTTS.setSpeechRate(speed);
        mTTS.setPitch(pitch);
        mTTS.speak(speechText,TextToSpeech.QUEUE_FLUSH,null);

    }

}
