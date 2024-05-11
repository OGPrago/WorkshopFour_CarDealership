package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {


    static void getDealership(Dealership dealership) {
        try (BufferedReader bufReader = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] splitLine = line.split("\\|");
                if (splitLine.length == 8) {
                    int vin = Integer.parseInt((splitLine[0]).trim());
                    int year = Integer.parseInt(splitLine[1].trim());
                    String make = (splitLine[2].trim());
                    String model = splitLine[3].trim();
                    String vehichleType = splitLine[4].trim();
                    String color = splitLine[5].trim();
                    int odometer = Integer.parseInt(splitLine[6].trim());
                    double price = Double.parseDouble(splitLine[7].trim());
                    dealership.vehicles.add(new Vehicle(vin, year, make, model, vehichleType, color, odometer, price));

                }
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private static void saveDealership(Dealership dealership) {

    }
}
