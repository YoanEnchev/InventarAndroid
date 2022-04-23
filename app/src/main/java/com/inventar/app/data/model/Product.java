package com.inventar.app.data.model;

public class Product {
    private int id;
    private String name;
    private int year;
    private String type;
    private int amorthizationIndex;
    private String description;
    private boolean isAvailable;
    private boolean isTrashed;

    public Product(int id, String name, int year, String type, int amorthizationIndex,
                   String description, boolean isAvailable, boolean isTrashed) {
        this.setId(id);
        this.setName(name);
        this.setYear(year);
        this.setType(type);
        this.setAmorthizationIndex(amorthizationIndex);
        this.setDescription(description);
        this.setIsAvailable(isAvailable);
        this.setIsTrashed(isTrashed);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmorthizationIndex() {
        return amorthizationIndex;
    }

    public void setAmorthizationIndex(int amorthizationIndex) {
        this.amorthizationIndex = amorthizationIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getIsTrashed() {
        return isTrashed;
    }

    public void setIsTrashed(boolean isTrashed) {
        this.isTrashed = isTrashed;
    }
}
