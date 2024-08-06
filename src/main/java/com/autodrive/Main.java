package com.autodrive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Auto Driving Car Simulation!");
        System.out.print("Please enter the width and height of the simulation field in x y format: ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("You have created a field of " + width + " x " + height + ".");

        Field field = new Field(width, height);
        List<Car> cars = new ArrayList<>();

        while (true) {
            System.out.println("Please choose from the following options:");
            System.out.println("[1] Add a car to field");
            System.out.println("[2] Run simulation");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Please enter the name of the car: ");
                String name = scanner.nextLine();
                System.out.print("Please enter initial position of car " + name + " in x y Direction format: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String direction = scanner.next();
                scanner.nextLine(); // consume newline
                System.out.print("Please enter the commands for car " + name + ": ");
                String commands = scanner.nextLine();

                Car car = new Car(name, x, y, direction);
                car.setCommands(commands);
                cars.add(car);

                System.out.println("Your current list of cars are:");
                for (Car c : cars) {
                    System.out.println(c);
                }
            } else if (choice == 2) {
                Simulation simulation = new Simulation(field, cars);
                simulation.run();

                System.out.println("Please choose from the following options:");
                System.out.println("[1] Start over");
                System.out.println("[2] Exit");
                int endChoice = scanner.nextInt();
                if (endChoice == 2) {
                    System.out.println("Thank you for running the simulation. Goodbye!");
                    break;
                } else {
                    cars.clear();
                    System.out.println("Please enter the width and height of the simulation field in x y format: ");
                    width = scanner.nextInt();
                    height = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("You have created a field of " + width + " x " + height + ".");
                    field = new Field(width, height);
                }
            }
        }

        scanner.close();
    }
}
