package com.example.maxfeldman.sole_mobileunit.Main.controllers

import android.app.Application
import com.example.maxfeldman.sole_mobileunit.Main.models.ValidateIpListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket
import java.util.*
import com.max.michael.robotviewunit.models.*

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

    fun sendDataWithSocket(socket: Socket,data: Any)
    {

        GlobalScope.launch (Dispatchers.Default){

            val outputStream = ObjectOutputStream(socket.getOutputStream())

            outputStream.writeObject(data)

        }
    }

    fun sayTTS(sentence: String, application: Application)
    {

        val javaNetworkController = JavaNetworkController.getInstance()

//        GlobalScope.launch(Dispatchers.Main)
//        {
//
//            val speaker = Speakerbox(application)
//            speaker.play(sentence)
//        }

    }

    fun validateIp(ip: String,port: Int, listeners: ValidateIpListener)
    {
        GlobalScope.launch(Dispatchers.Default)
        {
            val id = UUID.randomUUID().toString()
            try {
                val socket = Socket(ip, port)
                val objectOutputStream = ObjectOutputStream(socket.getOutputStream())

                objectOutputStream.writeObject("ack$id")
                println("ack$id")
                val objectInputStream = ObjectInputStream(socket.getInputStream())
                val inputId = objectInputStream.readObject() as String

                GlobalScope.launch(Dispatchers.Main)
                {
                    if (inputId == id) {
                       listeners.onMessageReceived("valid")
                    } else {
                        listeners.onMessageReceived("invalid")
                    }
                }


            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }

    }


}
