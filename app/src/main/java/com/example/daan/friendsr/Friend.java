package com.example.daan.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private Integer drawableId;

    // Constructor
    public Friend(String name, String bio, Integer drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public Integer getDrawableId() {
        return drawableId;
    }

}
