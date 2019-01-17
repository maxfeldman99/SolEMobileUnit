package com.example.maxfeldman.sole_mobileunit.Main.models.SessionModels;

public class Lesson
{
    private int id;
    private String title;
    private String badge;
    private String category;
    private String[] goals;
    private Scenario[] scenario;

    public Lesson(){}

    public Lesson(int id, String title, String badge, String category, String[] goals, Scenario[] scenarios) {
        this.id = id;
        this.title = title;
        this.badge = badge;
        this.category = category;
        this.goals = goals;
        this.scenario = scenario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getGoals() {
        return goals;
    }

    public void setGoals(String[] goals) {
        this.goals = goals;
    }

    public Scenario[] getScenario() {
        return scenario;
    }

    public void setScenarios(Scenario[] scenarios) {
        this.scenario = scenarios;
    }
}

