package com.example.maxfeldman.sole_mobileunit.Main.controllers;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.maxfeldman.sole_mobileunit.Main.fragments.VideoFragment;

class VideoController
{
    private static final VideoController ourInstance = new VideoController();

    private VideoFragment videoFragment;

    static VideoController getInstance() {
        return ourInstance;
    }

    private VideoController() {
    }

    public void setVideoFragment(VideoFragment fragment)
    {
        this.videoFragment = fragment;
    }

    public void setVideoContent(String emotion)
    {
        videoFragment.chooseEmotion(emotion);
    }
}
