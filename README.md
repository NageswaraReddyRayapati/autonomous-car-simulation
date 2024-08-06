# Auto Driving Car Simulation

## Description

This project simulates an autonomous driving car system on a rectangular field. Multiple cars can be added to the field, each with a unique name, starting position, and direction. The cars can execute a list of commands, including turning left, turning right, and moving forward. The simulation ensures that cars do not move out of the field boundaries and detects collisions between cars.

## Features

- Create a simulation field with specified width and height.
- Add multiple cars with unique names, initial positions, and directions.
- Issue a series of commands to each car.
- Run the simulation and display the final positions of the cars or detect collisions.
- Command-line interface for user interaction.

## Usage

1. Clone the repository:
    ```sh
    git clone https://github.com/NageswaraReddyRayapati/autonomous-car-simulation.git
    cd autodrive-simulation
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the simulation:
    ```sh
    mvn exec:java -Dexec.mainClass="com.autodrive.Main"
    ```

## Example

```plaintext
Welcome to Auto Driving Car Simulation!
Please enter the width and height of the simulation field in x y format:
10 10
You have created a field of 10 x 10.
Please choose from the following options:
[1] Add a car to field
[2] Run simulation
1
Please enter the name of the car:
A
Please enter initial position of car A in x y Direction format:
1 2 N
Please enter the commands for car A:
FFRFFFFRRL
Your current list of cars are:
- A, (1,2) N, FFRFFFFRRL
Please choose from the following options:
[1] Add a car to field
[2] Run simulation
