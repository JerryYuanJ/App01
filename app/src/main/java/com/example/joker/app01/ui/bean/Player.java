package com.example.joker.app01.ui.bean;


public class Player {
    private String name;
    private int imageId;
    private String teamName;

    public Player(String name, int imageId, String teamName) {
        this.name = name;
        this.imageId = imageId;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
