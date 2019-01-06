package com.example.maxfeldman.sole_mobileunit.Main.Helpers;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Created by MAX FELDMAN on 06/01/2019.
 */

public class MongoDB {

    private String uri = "mongodb+srv://solejr:<solejr99>@cluster0-moel4.mongodb.net/admin\r\n" +
            "";

    private MongoClientURI clientURI;
    private MongoClient mongoClient;
    MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoDB"); // name of db in compass



    public MongoDB() {
        if (mongoClient == null) {
            MongoClientURI clientURI = new MongoClientURI(uri);
            mongoClient = new MongoClient(clientURI); {
            }

        }
    }

    private static MongoDB instance = null;

    public static MongoDB getInstance() {
        if (instance == null) {
            instance = new MongoDB();
        }
        return instance;
    }



    public void insertToColletion(String col, String key, String val) {
        MongoCollection collection = mongoDatabase.getCollection(col);
        Document document = new Document(key, val);
        collection.insertOne(document);
    }

    public Document findDocument(Document searchDoc, MongoCollection collection) {
        Document foundDoc = (Document) collection.find(searchDoc).first();
        return foundDoc;

    }

    public void updateDocument(Document before, Bson updateVal, MongoCollection collection) {

        Bson after = new Document("$set", updateVal);
        collection.updateOne(before, after);
    }

}
