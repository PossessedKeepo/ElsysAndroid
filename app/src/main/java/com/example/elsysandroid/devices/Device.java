package com.example.elsysandroid.devices;

public class Device {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Device: " + name + " - " + id;
    }
}
