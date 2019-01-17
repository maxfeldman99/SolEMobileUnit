package com.example.maxfeldman.sole_mobileunit.Main.models.SessionModels;

/**
 * Created by MAX FELDMAN on 17/01/2019.
 */

public class ExpectedAnswer {

    private String input;
    private int successRating;

    public ExpectedAnswer(String input, int successRating) {
        this.input = input;
        this.successRating = successRating;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getSuccessRating() {
        return successRating;
    }

    public void setSuccessRating(int successRating) {
        this.successRating = successRating;
    }
}


