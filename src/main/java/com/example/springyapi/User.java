package com.example.springyapi;

public class User {

    private final int id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String ipAddress;
    private final double latitude;
    private final double longitude;

    public User (int id, String first_name, String last_name, String email, String ipAddress, double latitude, double longitude) {
        this.id = id;
        this. first_name = first_name;
        this. last_name = last_name;
        this.email = email;
        this.ipAddress = ipAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return first_name;
    }

    public String getLastname() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
