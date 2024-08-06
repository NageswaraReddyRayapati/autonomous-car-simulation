package com.autodrive;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimulationSteps {
    private Field field;
    private List<Car> cars;
    private Car carA;
    private Car carB;

    @Given("a field of {int} by {int}")
    public void a_field_of_by(Integer width, Integer height) {
        field = new Field(width, height);
        cars = new ArrayList<>();
    }

    @And("a car {string} at position {int} {int} facing {string} with commands {string}")
    public void a_car_at_position_facing_with_commands(String name, Integer x, Integer y, String direction, String commands) {
        Car car = new Car(name, x, y, direction);
        car.setCommands(commands);
        cars.add(car);
        if (name.equals("A")) carA = car;
        if (name.equals("B")) carB = car;
    }

    @When("the simulation runs")
    public void the_simulation_runs() {
        Simulation simulation = new Simulation(field, cars);
        simulation.run();
    }

    @Then("the car {string} should be at position {int} {int} facing {string}")
    public void the_car_should_be_at_position_facing(String name, Integer x, Integer y, String direction) {
        Car car = name.equals("A") ? carA : carB;
        assertEquals(x.intValue(), car.getX());
        assertEquals(y.intValue(), car.getY());
        assertEquals(direction, car.getDirection());
    }

    @Then("there should be a collision between car {string} and car {string} at position {int} {int} at step {int}")
    public void there_should_be_a_collision_between_car_and_car_at_position_at_step(String name1, String name2, Integer x, Integer y, Integer step) {
        Car car1 = name1.equals("A") ? carA : carB;
        Car car2 = name2.equals("A") ? carA : carB;
        assertEquals(x.intValue(), car1.getX());
        assertEquals(y.intValue(), car1.getY());
        assertEquals(x.intValue(), car2.getX());
        assertEquals(y.intValue(), car2.getY());
    }
}
