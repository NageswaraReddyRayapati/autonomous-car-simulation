package com.autodrive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    private final Field field;
    private final List<Car> cars;

    public Simulation(Field field, List<Car> cars) {
        this.field = field;
        this.cars = cars;
    }

    public void run() {
        boolean collisionDetected = false;
        int step = 0;
        Car collidingCar1 = null;
        Car collidingCar2 = null;
        int collisionX = 0;
        int collisionY = 0;

        while (!collisionDetected && carsHaveCommands()) {
            step++;
            Map<String, Integer> carPositions = new HashMap<>();

            for (Car car : cars) {
                if (car.hasCommands()) {
                    car.executeNextCommand(field);
                    String position = car.getX() + "," + car.getY();
                    if (carPositions.containsKey(position)) {
                        collisionDetected = true;
                        collidingCar1 = cars.get(carPositions.get(position));
                        collidingCar2 = car;
                        collisionX = car.getX();
                        collisionY = car.getY();
                        break;
                    } else {
                        carPositions.put(position, cars.indexOf(car));
                    }
                }
            }
        }

        if (collisionDetected) {
            System.out.println(collidingCar1.getName() + " collides with " + collidingCar2.getName() + " at (" + collisionX + "," + collisionY + ") at step " + step);
            System.out.println(collidingCar2.getName() + " collides with " + collidingCar1.getName() + " at (" + collisionX + "," + collisionY + ") at step " + step);
        } else {
            showResults();
        }
    }

    private boolean carsHaveCommands() {
        return cars.stream().anyMatch(Car::hasCommands);
    }

    private void showResults() {
        System.out.println("Final positions of cars:");
        for (Car car : cars) {
            System.out.println(car.getName() + ", (" + car.getX() + "," + car.getY() + ") " + car.getDirection());
        }
    }
}
