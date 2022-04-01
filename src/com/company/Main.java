package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot(5, 5);

        //        - Tell us when the parking lot is empty
        System.out.println(parkingLot.isParkingLotEmpty() ? "Empty" : "Not Empty");
        // Create a vehicle
//        Motorcycle motorcycle1 = new Motorcycle();

        // Try to park a vehicle
//        parkingLot.parkVehicle(motorcycle1);

        // Create an ArrayList of vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Motorcycle motorcycle1 = new Motorcycle();
        Motorcycle motorcycle2 = new Motorcycle();
        vehicles.add(motorcycle1);
        vehicles.add(motorcycle2);

        Car car1 = new Car();
        Car car2 = new Car();
        vehicles.add(car1);
        vehicles.add(car2);

        Van van1 = new Van();
        Van van2 = new Van();
        vehicles.add(van1);
        vehicles.add(van2);

//         Try to park each vehicle
        for (Vehicle vehicle : vehicles) {
            parkingLot.parkVehicle(vehicle);
        }

//        - Tell us how many spots are remaining
        parkingLot.printAvailableSpots();

        //    - Tell us how many total spots are in the parking lot
        parkingLot.printTotalSpots();

        //        - Tell us when the parking lot is empty
        System.out.println(parkingLot.isParkingLotEmpty() ? "Empty" : "Not Empty");
    }
}


/*
Design a parking lot using object-oriented principles

Goals:
- Your solution should be in Java - if you would like to use another language, please let the interviewer know.
- Boilerplate is provided. Feel free to change the code as you see fit

Assumptions:
- The parking lot can hold motorcycles, cars and vans
- The parking lot has motorcycle spots, car spots and large spots
- A motorcycle can park in any spot
- A car can park in a single compact spot, or a regular spot
- A van can park, but it will take up 3 regular spots
- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

Here are a few methods that you should be able to run:
- Tell us how many spots are remaining
- Tell us how many total spots are in the parking lot
- Tell us when the parking lot is full
- Tell us when the parking lot is empty
- Tell us when certain spots are full e.g. when all motorcycle spots are taken
- Tell us how many spots vans are taking up

Hey candidate! Welcome to your interview. I'll start off by giving you a Solution class. To run the code at any time, please hit the run button located in the top left corner.
*/