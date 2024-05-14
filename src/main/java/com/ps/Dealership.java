package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Dealership() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }

        return vehiclesByPrice;
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
