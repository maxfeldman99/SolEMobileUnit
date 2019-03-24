package com.example.maxfeldman.sole_mobileunit.Main.Helpers;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.maxfeldman.sole_mobileunit.Main.models.Request;
import com.example.maxfeldman.sole_mobileunit.Main.util.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX FELDMAN on 23/02/2019.
 */

public class FireBase {


    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Request req2;


    public void addFaceEmojiRequest(Request request, String id) {


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

    public void getFaceRequest(String collection, final String id, final DataListener listener) {

        CollectionReference docRef = db.collection(collection);
        docRef.whereEqualTo("id", id).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.isEmpty()) {

                } else {
                    List<Request> requests = queryDocumentSnapshots.toObjects(Request.class);
                    for (int i = 0; i < requests.size(); i++) {
                        Request request = requests.get(i);
                        if (request.getId().equals(id)) {
                            listener.onDataLoad(request);
                        }
                    }

                }


            }

        });
    }

    public void getAllRequests(String collection,final DataListener listener){
        CollectionReference docRef = db.collection(collection);

    }
}



