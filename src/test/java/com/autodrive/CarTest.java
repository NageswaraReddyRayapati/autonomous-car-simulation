package com.autodrive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private Field field;

    @Before
    public void setUp() {
        field = new Field(10, 10);
    }

    @Test
    public void testTurnLeft() {
        Car car = new Car("A", 1, 2, "N");
        car.setCommands("L");
        car.executeNextCommand(field);
        assertEquals("W", car.getDirection());
    }

    @Test
    public void testTurnRight() {
        Car car = new Car("A", 1, 2, "N");
        car.setCommands("R");
        car.executeNextCommand(field);
        assertEquals("E", car.getDirection());
    }

    @Test
    public void testMoveForward() {
        Car car = new Car("A", 1, 2, "N");
        car.setCommands("F");
        car.executeNextCommand(field);
        assertEquals(1, car.getX());
        assertEquals(3, car.getY());
    }

    @Test
    public void testCommandsQueue() {
        Car car = new Car("A", 1, 2, "N");
        car.setCommands("LFR");
        assertEquals(3, car.getCommands().size());
    }
}
