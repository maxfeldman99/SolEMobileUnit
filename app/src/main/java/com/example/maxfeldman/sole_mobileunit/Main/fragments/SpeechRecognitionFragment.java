package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maxfeldman.sole_mobileunit.R;
import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.github.zagum.speechrecognitionview.adapters.RecognitionListenerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeechRecognitionFragment extends Fragment {

    private SpeechRecognizer speechRecognizer;
    private TextView textViewOutput;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION_CODE = 1;
    private RecognitionProgressView recognitionProgressView;
    int[] colors = new int[5];




    public SpeechRecognitionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speech_recognition, container, false);
        Button buttonStart = view.findViewById(R.id.activate_btn);
        Button buttonReset = view.findViewById(R.id.stop_btn);
        textViewOutput = view.findViewById(R.id.speech_output);

         //speech recognition view
        colors[0] =ContextCompat.getColor(getContext(), R.color.color1);
        colors[1] =ContextCompat.getColor(getContext(), R.color.color2);
        colors[2] =ContextCompat.getColor(getContext(), R.color.color3);
        colors[3] =ContextCompat.getColor(getContext(), R.color.color4);
        colors[4] =ContextCompat.getColor(getContext(), R.color.color5);





        recognitionProgressView = (RecognitionProgressView) view.findViewById(R.id.recognition_view);
        recognitionProgressView.setSpeechRecognizer(speechRecognizer);
        recognitionProgressView.setRecognitionListener(new RecognitionListenerAdapter() {
            @Override
            public void onResults(Bundle results) {
                recognitionProgressView.setColors(colors);
//
//                recognitionProgressView.setBarMaxHeightsInDp(heights);
//
//                recognitionProgressView.setCircleRadiusInDp(2);
//
//
//
//                recognitionProgressView.setRotationRadiusInDp(10);

                recognitionProgressView.play();
                showResults(results);
            }
        });
        recognitionProgressView.setColors(colors);
//
//        recognitionProgressView.setBarMaxHeightsInDp(heights);
//
//        recognitionProgressView.setCircleRadiusInDp(2);
//
//        recognitionProgressView.setSpacingInDp(2);
//
//        recognitionProgressView.setIdleStateAmplitudeInDp(2);
//
//        recognitionProgressView.setRotationRadiusInDp(10);

        recognitionProgressView.play();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),

                        Manifest.permission.RECORD_AUDIO)

                        != PackageManager.PERMISSION_GRANTED) {

                        requestPermission();

                } else {

                    startRecognition();

                    recognitionProgressView.postDelayed(new Runnable() {

                        @Override

                        public void run() {

                            startRecognition();

                        }

                    }, 50);

                }

            }

        });



        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recognitionProgressView.stop();
                recognitionProgressView.play();
                textViewOutput.setText("");
            }
        });




        return view;
    }

    private void startRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName()); /////////
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizer.startListening(intent);
    }

    private void showResults(Bundle results){
        ArrayList<String> matches = results

                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        Log.e("speech",matches.toString());
        Toast.makeText(getContext(), matches.get(0), Toast.LENGTH_LONG).show();

        textViewOutput.setText(matches.get(0));
        recognitionProgressView.stop();
        recognitionProgressView.play();

    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(),

                Manifest.permission.RECORD_AUDIO)) {

            Toast.makeText(getContext(), "Requires RECORD_AUDIO permission", Toast.LENGTH_SHORT).show();

        } else {

            ActivityCompat.requestPermissions((Activity) getContext(),

                    new String[] { Manifest.permission.RECORD_AUDIO },

                    REQUEST_RECORD_AUDIO_PERMISSION_CODE);

        }

    }
    @Override
    public void onDestroy() {

        if (speechRecognizer != null) {

            speechRecognizer.destroy();

        }

        super.onDestroy();

    }

    }
