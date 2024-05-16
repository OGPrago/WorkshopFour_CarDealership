package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DealershipFileManager {


    protected void getDealership(Dealership dealership) {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("inventory.txt"))) {
            String dealershipInfo = bufReader.readLine();
            String[] dealershipInfoParts = dealershipInfo.split("\\|");
            if (dealershipInfoParts.length == 3) {
                dealership.setName(dealershipInfoParts[0]);
                dealership.setAddress(dealershipInfoParts[1]);
                dealership.setPhoneNumber(dealershipInfoParts[2]);
            }

            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] splitLine = line.split("\\|");
                if (splitLine.length == 8) {
                    int vin = Integer.parseInt(splitLine[0].trim());
                    int year = Integer.parseInt(splitLine[1].trim());
                    String make = splitLine[2].trim();
                    String model = splitLine[3].trim();
                    String vehicleType = splitLine[4].trim();
                    String color = splitLine[5].trim();
                    int odometer = Integer.parseInt(splitLine[6].trim());
                    double price = Double.parseDouble(splitLine[7].trim());


                    dealership.getAllVehicles().add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }


    protected void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.txt"));

            writer.write(String.format("%s|%s|%s\n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhoneNumber())
            );

            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%f\n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }

            System.out.println("Vehicle saved to inventory.txt.");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
