package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership = new Dealership();
    static Scanner scanner = new Scanner(System.in);
    static UserInterface ui = new UserInterface();

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.getDealership(dealership);
    }

    public static void display() {
        mainMenu();
    }

    private static void mainMenu() {
        byte userInput = 0;

        do {
            System.out.println("Welcome to Fantasy Island Cars! \nPlease select an option");
            System.out.println("\t1) All vehicles");
            System.out.println("\t2) Custom Search");
            System.out.println("\t3) Add Vehicle");
            System.out.println("\t4) Remove Vehicle");
            System.out.println("\t5) Exit");

            try {
                userInput = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Misinput? ¬‿¬");
                scanner.next();
                continue;
            }

            switch (userInput) {
                case 1:
                    ui.processGetByGetAllVehiclesRequest();
                    break;
                case 2:
                    customSearchMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Misinput? ¬‿¬");
            }


        } while (userInput != 5);
    }

    private static void customSearchMenu() {
        byte searchCommand = 0;

        do {
            System.out.println("\t1) Vehicles by Price");
            System.out.println("\t2) Vehicles by MakeModel");
            System.out.println("\t3) Vehicles by Year");
            System.out.println("\t4) Vehicles by Color");
            System.out.println("\t5) Vehicles by Mileage");
            System.out.println("\t6) Vehicles by ");
            System.out.println("\t7) Back");

            try {
                searchCommand = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Misinput? ¬‿¬");
                scanner.next();
                continue;
            }

            switch (searchCommand) {
                case 1:
                    ui.processGetByPriceRequest();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }

        } while (searchCommand != 7);
    }

    private void processGetByPriceRequest() {
        init();
        System.out.println("Enter minimum amount:");
        double min = scanner.nextDouble();
        System.out.println("Enter maximum amount:");
        double max = scanner.nextDouble();

        if (min > max) {
            System.out.println("Error: Minimum amount cannot be greater than maximum amount.");
            return;
        }

        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(min, max);

        if (vehiclesByPrice.isEmpty()) {
            System.out.println("No vehicles found within the specified price range.");
        } else {
            System.out.println("Vehicles within the specified price range:");
            String dealershipInfo = dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber();
            System.out.println(dealershipInfo);
            for (Vehicle vehicle : vehiclesByPrice) {
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

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processGetByGetAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        init();

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

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }
}
