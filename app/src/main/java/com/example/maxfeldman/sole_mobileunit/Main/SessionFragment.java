package com.example.maxfeldman.sole_mobileunit.Main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        Button button = view.findViewById(R.id.test_btn1);
        Button button2 = view.findViewById(R.id.test_btn2);
        Button button3 = view.findViewById(R.id.test_btn3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoFragment videoFragment = VideoFragment.newInstance("happy");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,videoFragment).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VideoFragment videoFragment = VideoFragment.newInstance("sad");
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

}
