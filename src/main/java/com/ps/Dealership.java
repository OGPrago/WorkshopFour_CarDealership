package com.ps;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    DealershipFileManager dealershipFileManager = new DealershipFileManager();

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

    protected ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }

        return vehiclesByPrice;
    }

    protected ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().toLowerCase().contains(make.toLowerCase())
                    && vehicle.getModel().toLowerCase().contains(model.toLowerCase())) {
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    protected ArrayList<Vehicle> getVehiclesByYear(int yearMin, int yearMax) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            int year = vehicle.getYear();
            if (year >= yearMin && year <= yearMax) {
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    protected ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().toLowerCase().contains(color.toLowerCase())) {
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    protected ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            int mileage = vehicle.getOdometer();
            if (mileage >= min && mileage <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }

    protected ArrayList<Vehicle> getVehiclesByType(String vehichleType) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().toLowerCase().contains(vehichleType.toLowerCase())) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    protected void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // Add the vehicle to the current Dealership's vehicles list
        dealershipFileManager.saveDealership(this);
    }

    protected void removeVehicle(Vehicle vehicle) {
        getAllVehicles().remove(vehicle);
        dealershipFileManager.saveDealership(this);
    }


}
