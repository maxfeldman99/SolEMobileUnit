package com.example.maxfeldman.sole_mobileunit.Main.Helpers;

import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class PojoConverter {

    Gson gson = new Gson();

    public PojoConverter(){

    }

    public Document PojoToJson(Request request) throws IOException {


        String json = gson.toJson(request);

        // write to JSON

//        FileWriter writer = new FileWriter("file.json");
//        writer.write(json);
//        writer.close();

        Document doc = Document.parse( json.toString() );


        //BasicDBObject document = new BasicDBObject();
        //document = (BasicDBObject) JSON.parse(json);
        DBObject d = BasicDBObject.parse(json);
        DBObject t = (DBObject) Document.parse(json);
       //Object o = BasicDBObject.parse(json);
        return doc;

    }



        // back to POJO
    public Request  JsonToPojo() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("file.json"));
        Request pojo = gson.fromJson(br,Request.class);
        return pojo;
    }




}
