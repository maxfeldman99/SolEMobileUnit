package com.example.maxfeldman.sole_mobileunit.Main.util;

import com.example.maxfeldman.sole_mobileunit.Main.models.Request;

import java.util.HashMap;

public class Dao {

    private static final Dao ourInstance = new Dao();

    private HashMap<String, Request> cacheSeq;

    public static Dao getInstance() {
        return ourInstance;
    }

    private Dao(){

        HashMap<String, Request> cacheSeq = new HashMap<>();
    }

    public Request getCachedSeq(String id){

        Request request;
        request = cacheSeq.get(id);
        return request;
    }

    public void setCachedSeq(String id,Request request){
        cacheSeq.put(id,request);
    }




}
