package com.example.maxfeldman.sole_mobileunit.Main.models.SessionModels;

/**
 * Created by MAX FELDMAN on 17/01/2019.
 */

public class OnFailure {

    private Action action;
    private String nextScenarioID;
    private int numOfRetries;

    public OnFailure(Action action, String nextScenarioID, int numOfRetries) {
        this.action = action;
        this.nextScenarioID = nextScenarioID;
        this.numOfRetries = numOfRetries;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getNextScenarioID() {
        return nextScenarioID;
    }

    public void setNextScenarioID(String nextScenarioID) {
        this.nextScenarioID = nextScenarioID;
    }

    public int getNumOfRetries() {
        return numOfRetries;
    }

    public void setNumOfRetries(int numOfRetries) {
        this.numOfRetries = numOfRetries;
    }

}


