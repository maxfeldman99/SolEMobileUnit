package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maxfeldman.sole_mobileunit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeechRecognitionFragment extends Fragment {

    private SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());

    public SpeechRecognitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speech_recognition, container, false);

        return view;
    }

}
