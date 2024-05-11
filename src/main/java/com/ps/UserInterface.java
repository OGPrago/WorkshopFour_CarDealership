package com.ps;


import java.util.ArrayList;

public class UserInterface {

    static Dealership dealership = new Dealership();

    public static void display() {
        DealershipFileManager.getDealership(dealership);
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles(null);
        for (Vehicle vehicle : allVehicles) {
            System.out.printf("Vin: %d|Year: %d|Make: %s|Model: %s|VehicleType: %s|Color: %s|Mileage: %d|Price: $%.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
    }
}
