package com.example.maxfeldman.sole_mobileunit.Main.util;

import com.example.maxfeldman.sole_mobileunit.Main.Helpers.DataListener;
import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;

public class Dao {

    private static  Dao ourInstance = null;

    private HashMap<String, Request> cacheSeq;


    public static Dao getInstance()
    {
        if (ourInstance == null) {
            ourInstance = new Dao();
        }

        return ourInstance;
    }

    private Dao(){
        cacheSeq = new HashMap<>();
    }

    public void getCachedSeq(String id,final DataListener listener){


        Request request;
        request = cacheSeq.get(id);
        listener.onDataLoad(request);



    }

    public void setCachedSeq(String id,Request request){
        cacheSeq.put(id,request);
    }




}
