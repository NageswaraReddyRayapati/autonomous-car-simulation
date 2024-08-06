package com.autodrive.steps;

import com.autodrive.Car;
import com.autodrive.Field;
import com.autodrive.Simulation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MultipleCarsSteps {
    private Field field;
    private List<Car> cars = new ArrayList<>();
    private Simulation simulation;
    private Map<Car, String> collisionResults = new HashMap<>();

    @Given("a field of {int} {int}")
    public void a_field_of_width_and_height(int width, int height) {
        field = new Field(width, height);
    }

    @Given("a car named {string} at positions {int} {int} facing {string}")
    public void a_car_named_at_position_facing(String name, int x, int y, String direction) {
        Car car = new Car(name, x, y, direction);
        cars.add(car);
    }

    @When("the cars execute commands {string} and {string}")
    public void the_cars_execute_commands(String commands1, String commands2) {
        if (cars.size() < 2) {
            throw new IllegalStateException("Not enough cars added to execute commands.");
        }

        cars.get(0).setCommands(commands1);
        cars.get(1).setCommands(commands2);
        simulation = new Simulation(field, cars);
        simulation.run();
    }

    @Then("the collision should occur between {string} and {string} at position {int} {int} at step {int}")
    public void the_collision_should_occur_between_and_at_position_at_step(String car1Name, String car2Name, int x, int y, int step) {
        Car car1 = cars.stream().filter(car -> car.getName().equals(car1Name)).findFirst().orElse(null);
        Car car2 = cars.stream().filter(car -> car.getName().equals(car2Name)).findFirst().orElse(null);

        assertNotNull(car1);
        assertNotNull(car2);

        simulation.run();

        collisionResults = simulation.getCollisionResults();

        assertEquals(String.format("%s collides with %s at (%d,%d) at step %d", car1Name, car2Name, x, y, step), collisionResults.get(car1));
        assertEquals(String.format("%s collides with %s at (%d,%d) at step %d", car2Name, car1Name, x, y, step), collisionResults.get(car2));
    }
}
