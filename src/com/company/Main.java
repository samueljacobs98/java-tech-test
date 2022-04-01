package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot(10, 10);

        //        - Tell us when the parking lot is empty
        System.out.println(parkingLot.isParkingLotEmpty() ? "Empty" : "Not Empty");
        // Create a vehicle
//        Van van1 = new Van();

        // Try to park a vehicle
//        parkingLot.parkVehicle(van1);

        // Create an ArrayList of vehicles
        ArrayList<Vehicle> vehicles = new ArrayList<>();

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
        Van van3 = new Van();
        Van van4 = new Van();
        vehicles.add(van1);
        vehicles.add(van2);
        vehicles.add(van3);
        vehicles.add(van4);



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


        //        - Tell us how many spots vans are taking up
        parkingLot.getSpotsPerVehicleType();
    }
}