package com.example.maxfeldman.sole_mobileunit.Main.fragments;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.maxfeldman.sole_mobileunit.Main.MainActivity;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.MainController;
import com.example.maxfeldman.sole_mobileunit.Main.controllers.NetworkController;
import com.example.maxfeldman.sole_mobileunit.Main.models.ValidateIpListener;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.example.maxfeldman.sole_mobileunit.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    MainController mainController = MainController.getInstance();
    ImageView imageVal;
    boolean isValid = false;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // to lock the landscape mode
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Button button = view.findViewById(R.id.validateButton);
        Button buttonNext = view.findViewById(R.id.next_btn);
        final EditText ipEditText = view.findViewById(R.id.ip_et);
        imageVal = view.findViewById(R.id.img_val);
        String ip = mainController.getIp();

        if(ip != null)
        {
            ipEditText.setText(ip);
        }




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip = ipEditText.getText().toString();
                validateIP(ip);
                if(isValid == true){
                    imageVal.setImageResource(R.drawable.ic_done);
                    imageVal.setVisibility(View.VISIBLE);

                }else{
                    imageVal.setImageResource(R.drawable.ic_error);
                    imageVal.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid){
                    goToFace();
                }else{
                    Toast.makeText(getContext(), "Please Enter a Valid IP Address of Destination Unit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    private void validateIP(final String inputIP){
        final Pattern IP_ADDRESS
                = Pattern.compile(
                "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                        + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                        + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                        + "|[1-9][0-9]|[0-9]))");
        Matcher matcher = IP_ADDRESS.matcher(inputIP);
        if (matcher.matches()) {
            NetworkController.INSTANCE.validateIp(inputIP, 12345, new ValidateIpListener() {
                @Override
                public void onMessageReceived(String message) {
                    String result = (String) message;



                    if(result.equals("valid"))
                    {
                        imageVal.setImageResource(R.drawable.ic_done);
                        imageVal.setVisibility(View.VISIBLE);
                        mainController.setIp(inputIP);

                        isValid = true;

                    }else {
                        imageVal.setImageResource(R.drawable.ic_error);
                        imageVal.setVisibility(View.VISIBLE);

                        isValid = false;
                    }
                }
            });
        }
    }

    private void goToFace(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        VideoFragment videoFragment = new VideoFragment();
        //Intent intent = new Intent(getContext(),MainActivity.class);
        // startActivity(intent);
        fragmentManager.beginTransaction().replace(R.id.container,videoFragment,"VideoFragment").commitNow();
        mainController.setVideoFragment((VideoFragment) videoFragment);
    }



}
