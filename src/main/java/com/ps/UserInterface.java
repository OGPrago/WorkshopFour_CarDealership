package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Dealership dealership = new Dealership("", "", "");
    static Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.getDealership(dealership);
    }

    public static void display() {
        int userInput = 0;

        do {
            System.out.println("Welcome to Fantasy Island Cars! \nPlease select an option");
            System.out.println("\t1) All vehicles");
            System.out.println("\t2) Vehicles by Price");
            System.out.println("\t3) Vehicles by MakeModel");
            System.out.println("\t4) Vehicles by Year");
            System.out.println("\t5) Vehicles by Color");
            System.out.println("\t6) Vehicles by Mileage");
            System.out.println("\t7) Vehicles by ");
            System.out.println("\t8) Add Vehicle");
            System.out.println("\t9) Remove Vehicle");
            System.out.println("\t10) Cart");
            System.out.println("\t11) Exit");

            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Misinput? ¬‿¬");
                scanner.next();
                continue;
            }

            switch (userInput) {
                case 1:
                    processGetByGetAllVehiclesRequest();
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
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Misinput? ¬‿¬");
            }


        } while (userInput != 11);


    }

    private void processGetByPriceRequest() {

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

    private static void processGetByGetAllVehiclesRequest() {
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

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }
}
