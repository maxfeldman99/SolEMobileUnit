package com.example.maxfeldman.sole_mobileunit.Main.util;

import android.app.Application;

import com.mapzen.speakerbox.Speakerbox;

class Utilities {

    private static final Utilities ourInstance = new Utilities();



    static Utilities getInstance() {
        return ourInstance;
    }

    private Utilities() { }

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


}
