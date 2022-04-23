package com.inventar.app.data.model;

public class Client {
    private int id;
    private String name;
    private String familyName;

    public Client(int id, String name, String familyName) {
        this.setId(id);
        this.setName(name);
        this.setFamilyName(familyName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
