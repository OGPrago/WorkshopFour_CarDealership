package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership = new Dealership();
    static Scanner scanner = new Scanner(System.in);
    static UserInterface ui = new UserInterface();
    DealershipFileManager dealershipFileManager = new DealershipFileManager();

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
                scanner.nextLine();
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
                    ui.processAddVehicleRequest();
                    break;
                case 4:
                    ui.processRemoveVehicleRequest();
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
            System.out.println("\t6) Vehicles by Type");
            System.out.println("\t7) Back");

            try {
                searchCommand = scanner.nextByte();
                scanner.nextLine();
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
                    ui.processGetByMakeModelRequest();
                    break;
                case 3:
                    ui.processGetByYearRequest();
                    break;
                case 4:
                    ui.processGetByColorRequest();
                    break;
                case 5:
                    ui.processGetByMileageRequest();
                    break;
                case 6:
                    ui.processGetByVehicleTypeRequest();
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        } while (searchCommand != 7);
    }

    private void printDealershipInfo() {
        ui.init();
        String dealershipInfo = dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber();
        System.out.println(dealershipInfo);
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
            printDealershipInfo();
            processVehicles(vehiclesByPrice);
        }
    }

    private void processGetByMakeModelRequest() {
        init();
        System.out.println("Enter Make: ");
        String make = scanner.nextLine().trim();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine().trim();

        if (make.isEmpty() || model.isEmpty()) {
            System.out.println("Incorrect input.");
            return;
        }

        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);

        if (vehiclesByMakeModel.isEmpty()) {
            System.out.printf("No vehicles found for %s %s\n", make, model);
        } else {
            System.out.printf("%s %s vehicles\n", make, model);
            printDealershipInfo();
            processVehicles(vehiclesByMakeModel);
        }
    }


    private void processGetByYearRequest() {
        init();
        System.out.println("Enter minimum year:");
        int yearMin = scanner.nextInt();
        System.out.println("Enter maximum year:");
        int yearMax = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left after nextInt()

        if (yearMin > yearMax) {
            System.out.println("Error: Minimum year cannot be greater than maximum year.");
            return;
        }

        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(yearMin, yearMax);

        if (vehiclesByYear.isEmpty()) {
            System.out.println("No vehicles found within the specified year range.");
        } else {
            System.out.println("Vehicles within the specified year range:");
            printDealershipInfo();
            processVehicles(vehiclesByYear);
        }
    }


    private void processGetByColorRequest() {
        init();
        System.out.println("Enter color: ");
        String color = scanner.nextLine().trim();

        if (color.isEmpty()) {
            System.out.println("No color entered. Please enter a valid color.");
            return;
        }

        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);

        if (vehiclesByColor.isEmpty()) {
            System.out.printf("No vehicles found for %s.\n", color);
        } else {
            System.out.println(color + " vehicles");
            printDealershipInfo();
            processVehicles(vehiclesByColor);
        }
    }

    private void processGetByMileageRequest() {
        init();
        System.out.println("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.println("Enter maximum mileage: ");
        int max = scanner.nextInt();

        if (min > max) {
            System.out.println("Error: Minimum cannot be greater than maximum.");
            return;
        }

        ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min, max);

        if (vehiclesByMileage.isEmpty()) {
            System.out.println("No vehicles found within the specified mileage range.");
        } else {
            System.out.println("Vehicles within the specified mileage range:");
            printDealershipInfo();
            processVehicles(vehiclesByMileage);
        }
    }

    private void processGetByVehicleTypeRequest() {
        init();
        System.out.println("Enter Vehicle Type: ");
        String type = scanner.nextLine().trim();

        if (type.isEmpty()) {
            System.out.println("No type entered. Please enter a valid type.");
            return;
        }

        ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(type);

        if (vehiclesByType.isEmpty()) {
            System.out.printf("No vehicles found for %s.\n", type);
        } else {
            System.out.println(type + " vehicles");
            printDealershipInfo();
            processVehicles(vehiclesByType);
        }
    }

    private void processGetByGetAllVehiclesRequest() {
        init();
        printDealershipInfo();
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();

        processVehicles(allVehicles);
    }


    private void processAddVehicleRequest() {
        init();
        System.out.println("Enter VIN:");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make:");
        String make = scanner.nextLine().trim();
        System.out.println("Enter model:");
        String model = scanner.nextLine().trim();
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine().trim();
        System.out.println("Enter color:");
        String color = scanner.nextLine().trim();
        System.out.println("Enter mileage:");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);

        dealership.addVehicle(newVehicle);

        dealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest() {
        init();
        System.out.println("Enter VIN of the vehicle to remove:");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    private void processVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
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
