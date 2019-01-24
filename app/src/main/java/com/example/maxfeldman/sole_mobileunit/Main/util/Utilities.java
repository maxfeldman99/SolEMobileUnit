package com.example.maxfeldman.sole_mobileunit.Main.util;

import android.app.Application;
import android.media.MediaPlayer;

import com.mapzen.speakerbox.Speakerbox;

public class Utilities  {

    private static final Utilities ourInstance = new Utilities();

    private boolean loop = true;
    private MediaPlayer mp;


    public static Utilities getInstance() {
        return ourInstance;
    }

    private Utilities() { }

    public void setLoop(boolean loop){
        this.loop = loop;
    }

    public void setMediaPlayer(MediaPlayer mp){
        this.mp = mp;
    }

    public MediaPlayer getMediaPlayer(){
        return this.mp;
    }

    public void sayTTS(final String sentence, final Application application)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Speakerbox speakerbox = new Speakerbox(application);
                speakerbox.play(sentence);


            }
        });

        thread.start();

    }

    public void loopTest(boolean loop){
        setLoop(loop);

        mp.setLooping(loop);

    }


}
