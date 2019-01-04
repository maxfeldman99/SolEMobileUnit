package com.example.maxfeldman.sole_mobileunit.Main;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.maxfeldman.sole_mobileunit.R;



public class MainActivity extends AppCompatActivity implements VideoFragment2.OnFragmentInteractionListener   {


    private String observerTestString = "test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final FrameLayout layout = findViewById(R.id.video_fragment2);
        getSupportFragmentManager().beginTransaction().replace(R.id.video_fragment2, new VideoFragment2(),"video").commit();


        VideoFragment2 fragment = (VideoFragment2) getSupportFragmentManager().findFragmentByTag("video");
        //fragment.OnVideoChanged("sad");

        // getSupportFragmentManager().beginTransaction().add(R.id.video_fragment,new VideoFragment(),"video").commitNow();

        //VideoFragment videoFragment = (VideoFragment) getSupportFragmentManager().findFragmentByTag("video");

        //videoFragment.OnVideoChanged("sad");



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            startActivity(intent);
//
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
