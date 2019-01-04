package com.example.maxfeldman.sole_mobileunit.Main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maxfeldman.sole_mobileunit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SessionFragment extends Fragment { // this fragment will contain the questions to be asked


    public SessionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_session, container, false);

        return view;
    }

}
