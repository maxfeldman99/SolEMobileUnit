package com.example.maxfeldman.sole_mobileunit.Main.models;

/**
 * Created by MAX FELDMAN on 07/01/2019.
 */

public class Answer<T> {

    private String id;
    private T content;

    public Answer(String id, T content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}

