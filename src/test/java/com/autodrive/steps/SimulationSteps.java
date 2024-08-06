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

public class SimulationSteps {
    private Field field;
    private List<Car> cars = new ArrayList<>();
    private Simulation simulation;
    private Map<Car, String> collisionResults = new HashMap<>();
    @Given("a field of width {int} and height {int}")
    public void a_field_of_width_and_height(int width, int height) {
        field = new Field(width, height);
    }

    @Given("a car named {string} at position {int} {int} facing {string}")
    public void a_car_named_at_position_facing(String name, int x, int y, String direction) {
        Car car = new Car(name, x, y, direction);
        cars.add(car);
    }

    @When("the car executes commands {string}")
    public void the_car_executes_commands(String commands) {
        cars.get(0).setCommands(commands);
        simulation = new Simulation(field, cars);
        simulation.run();
    }

    @Then("the final position of the car should be {int} {int} {string}")
    public void the_final_position_of_the_car_should_be(int x, int y, String direction) {
        Car car = cars.get(0);
        assertEquals(x, car.getX());
        assertEquals(y, car.getY());
        assertEquals(direction, car.getDirection());
    }
}
