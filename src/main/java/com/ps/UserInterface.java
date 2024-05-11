package com.ps;

import java.util.ArrayList;

public class UserInterface {

    static Dealership dealership = new Dealership("Fantasy Island Cars", "Fantasy Island", "719-26-OATS");

    public static void display() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.getDealership(dealership);

        String dealershipInfo = dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber();
        System.out.println(dealershipInfo);
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
