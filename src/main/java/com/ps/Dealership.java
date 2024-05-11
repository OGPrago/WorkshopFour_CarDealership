package com.ps;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;

    ArrayList<Vehicle> vehicles = new ArrayList<>();


    public  ArrayList<Vehicle> getAllVehicles(Vehicle vehicle) {
        return this.vehicles;
    }

    private ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        return null;
    }

    private ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        return null;
    }

    private ArrayList<Vehicle> getVehiclesByYear(int yearMin, int yearMax) {

        return null;
    }

    private ArrayList<Vehicle> getVehiclesByColor(String color) {

        return null;
    }

    private ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

        return null;
    }

    private ArrayList<Vehicle> getVehiclesByType(String vehichleType) {
        return null;
    }

    private void addVehicle(Vehicle vehicle) {

    }

    private void removeVehicle(Vehicle vehicle) {

    }


}
