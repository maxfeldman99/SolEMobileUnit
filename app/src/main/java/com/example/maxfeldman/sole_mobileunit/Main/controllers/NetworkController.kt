package com.example.maxfeldman.sole_mobileunit.Main.controllers

import android.content.Context
import android.speech.tts.TextToSpeech
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.net.Socket
import java.util.*

/*
       object = Singleton

        to call it use this code in java:
        NetworkController controller = NetworkController.INSTANCE;
                            ^
                            instance to the NetworkController Singleton you can use
 */

object NetworkController
{

    /**
     * @param ip: Ip to send to data to (Robot, Tablet)
     * @param T: The data we send (can be anything)
     * @param type: The type of the data we send (for future switch case) - can be null
     * @sample sendDataToIp("192.168.1.42", "Cool Data", "String");
     */

    fun <T> sendDataToIp(ip: String, data: T, type: String? = "")
    {

        //Coroutine call (instead of Thread or AsyncTask)
        GlobalScope.launch(Dispatchers.Default)
        {
            val socket = Socket(ip,12345)

            val outputStream = ObjectOutputStream(socket.getOutputStream())

            outputStream.writeObject(data)

            outputStream.flush()
            socket.close()
        }

    }

    fun sayTTS(sentence: String, context: Context)
    {
        GlobalScope.launch(Dispatchers.Main)
        {

            var tts = TextToSpeech(null, null)

            tts = TextToSpeech(context, object : TextToSpeech.OnInitListener {
                override fun onInit(status: Int) {
                    if (status == TextToSpeech.SUCCESS) {
                        tts.language = Locale.US
                    }
                }

            })

            tts.speak(sentence, TextToSpeech.QUEUE_FLUSH,null)

        }



    }


}
