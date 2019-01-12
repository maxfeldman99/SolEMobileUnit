package com.example.maxfeldman.sole_mobileunit.Main.models;

import com.example.maxfeldman.sole_mobileunit.Main.models.MotorRequest;

import java.util.ArrayList;

public class Request
{
    private String id;
    ArrayList<MotorRequest> sequence;
    int sizeOfSequence;

    public Request(){}

    public Request(String id, ArrayList<MotorRequest> sequence, int sizeOfSequence) {
        this.id = id;
        this.sequence = sequence;
        this.sizeOfSequence = sizeOfSequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<MotorRequest> getSequence() {
        return sequence;
    }

    public void setSequence(ArrayList<MotorRequest> sequence)
    {
        this.sequence = sequence;
        this.sizeOfSequence = sequence.size();
    }

    public int getSizeOfSequence() {
        return sizeOfSequence;
    }
}
