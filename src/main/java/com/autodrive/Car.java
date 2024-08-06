package com.autodrive;

import java.util.LinkedList;
import java.util.Queue;

public class Car {
    private final String name;
    private int x;
    private int y;
    private Direction direction;
    private final Queue<Command> commands;

    public Car(String name, int x, int y, String direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = Direction.valueOf(direction);
        this.commands = new LinkedList<>();
    }

    public void setCommands(String commandString) {
        for (char c : commandString.toCharArray()) {
            commands.add(Command.valueOf(String.valueOf(c)));
        }
    }

    public Queue<Command> getCommands() {
        return new LinkedList<>(commands); // return a copy to ensure encapsulation
    }

    public void executeNextCommand(Field field) {
        if (!commands.isEmpty()) {
            Command command = commands.poll();
            command.execute(this, field);
        }
    }

    public boolean hasCommands() {
        return !commands.isEmpty();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction.name();
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void moveForward(Field field) {
        int newX = x + direction.dx();
        int newY = y + direction.dy();
        if (field.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    @Override
    public String toString() {
        return name + ", (" + x + "," + y + ") " + direction + ", " + commands.toString().replaceAll("[\\[\\], ]", "");
    }
}
