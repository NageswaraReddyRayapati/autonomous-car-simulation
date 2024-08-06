package com.autodrive;

public enum Command {
    L {
        @Override
        public void execute(Car car, Field field) {
            car.turnLeft();
        }
    },
    R {
        @Override
        public void execute(Car car, Field field) {
            car.turnRight();
        }
    },
    F {
        @Override
        public void execute(Car car, Field field) {
            car.moveForward(field);
        }
    };

    public abstract void execute(Car car, Field field);
}
