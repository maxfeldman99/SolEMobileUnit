package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.maxfeldman.sole_mobileunit.R;
import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.github.zagum.speechrecognitionview.adapters.RecognitionListenerAdapter;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeechRecognitionFragment extends Fragment {

    private SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
    private TextView textViewOutput;

    public SpeechRecognitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speech_recognition, container, false);
        Button button = view.findViewById(R.id.activate_btn);
        textViewOutput = view.findViewById(R.id.speech_output);

        // speech recognition view

        final RecognitionProgressView recognitionProgressView = (RecognitionProgressView) view.findViewById(R.id.recognition_view);
        recognitionProgressView.setSpeechRecognizer(speechRecognizer);
        recognitionProgressView.setRecognitionListener(new RecognitionListenerAdapter() {
            @Override
            public void onResults(Bundle results) {
                showResults(results);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRecognition();
//                recognitionProgressView.play();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                recognitionProgressView.stop();
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
        //textViewOutput.setText();
    }

}
