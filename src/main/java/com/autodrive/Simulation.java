package com.autodrive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    private final Field field;
    private final List<Car> cars;
    private Map<Car, String> results;

    public Simulation(Field field, List<Car> cars) {
        this.field = field;
        this.cars = cars;
        this.results = new HashMap<>();
    }

    public void run() {
        boolean collision = false;
        for (int step = 0; !collision && cars.stream().anyMatch(car -> !car.getCommands().isEmpty()); step++) {
            Map<String, Car> positions = new HashMap<>();
            for (Car car : cars) {
                car.executeNextCommand(field);
                String positionKey = car.getX() + "," + car.getY();
                if (positions.containsKey(positionKey)) {
                    Car collidedCar = positions.get(positionKey);
                    results.put(car, String.format("%s collides with %s at (%d,%d) at step %d", car.getName(), collidedCar.getName(), car.getX(), car.getY(), step + 1));
                    results.put(collidedCar, String.format("%s collides with %s at (%d,%d) at step %d", collidedCar.getName(), car.getName(), collidedCar.getX(), collidedCar.getY(), step + 1));
                    collision = true;
                } else {
                    positions.put(positionKey, car);
                }
            }
        }

            showResults(collision);

    }
    public void showResults(boolean collision) {
        System.out.println("Final positions of cars:");
        if(!collision) {
            for (Car car : cars) {
                System.out.println(car.getName() + " is at (" + car.getX() + "," + car.getY() + ") facing " + car.getDirection());
            }
        }else {
            results.forEach((carName, result) -> System.out.println(result));
        }
    }

    public Map<Car, String> getCollisionResults() {
        return results;
    }

}
