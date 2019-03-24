package com.example.maxfeldman.sole_mobileunit.Main.Helpers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by MAX FELDMAN on 23/02/2019.
 */

public class FireBase {


    public static FirebaseFirestore db=FirebaseFirestore.getInstance();
    private Request req2;





    public void addFaceEmojiRequest(Request request,String id){


        db.collection("sole_jr_robot_requests").document(id)
                .set(request)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("success", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("fail", "Error writing document", e);
                    }
                });
    }

    public void getFaceRequest(String collection, String id,final DataListener listener){

        DocumentReference docRef = db.collection(collection).document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Request request = documentSnapshot.toObject(Request.class);

                listener.onDataLoad(request);
            }
        });


    }




}
