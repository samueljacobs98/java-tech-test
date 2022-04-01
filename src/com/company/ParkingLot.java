package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import static com.company.SpotType.COMPACT;
import static com.company.SpotType.REGULAR;

public class ParkingLot {
    // parkedVehicles, ArrayList of Vehicles
    // Starts with no vehicles parked (i.e. ArrayList with 0 elements)
    // Each vehicle has its own VehicleType and keeps track of how many spots it occupies
    ArrayList<Vehicle> parkedVehicles = new ArrayList<Vehicle>();
    // totalCompactSpots
    Integer totalCompactSpots;
    // totalRegularSpots
    Integer totalRegularSpots;
    // availableSpots, number of each spot type available,
    // set on initialisation
    HashMap<SpotType, Integer> availableSpots = new HashMap<SpotType, Integer>();
    // occupiedSpots, number of each spot type occupied, stored in hash map

    public ParkingLot(int nCompact, int nRegular) {
        totalCompactSpots = nCompact;
        totalRegularSpots = nRegular;
        initialiseAvailableSpots(nCompact, nRegular);
    }

    // initialiseAvailableSpots, method()
    // Run during constructor
    // Ensures that when a ParkingLot is created, the correct number of
    // Each type of spot is set
    private void initialiseAvailableSpots(int nCompact, int nRegular) {
        availableSpots.put(COMPACT, nCompact);
        availableSpots.put(REGULAR, nRegular);
    }

    //    parkVehicle, method(Vehicle)
    //    adds the vehicle to the parkedVehicles arrayList
    public void parkVehicle(Vehicle vehicle) {
        parkedVehicles.add(vehicle);
        // note the vehicle is initialised to take up 0 spots
        updateAvailableSpots(vehicle);
    }

    public void printAvailableSpots() {
        System.out.println("There are " + availableSpots.get(COMPACT) + " compact spots");
        System.out.println("and");
        System.out.println(availableSpots.get(REGULAR) + " regular spots remaining.");
    }

    public void printTotalSpots() {
        System.out.println("There are " + totalCompactSpots + " compact spots");
        System.out.println("and");
        System.out.println(totalRegularSpots + " regular spots in total.");
    }

    private boolean checkForSpace(HashMap<SpotType, Integer> spotPreference) {
        Integer spotPreferenceCompact = spotPreference.get(COMPACT);
        Integer spotPreferenceRegular = spotPreference.get(REGULAR);

        boolean requiredCompactSpotsAvailable = availableSpots.get(COMPACT) >= spotPreferenceCompact;
        boolean requiredRegularSpotsAvailable = availableSpots.get(REGULAR) >= spotPreferenceRegular;

        return requiredCompactSpotsAvailable && requiredRegularSpotsAvailable;
    }

    // updateOccupiedSpots, method(Vehicle)
    // Takes a vehicle input, checks if the ideal number of spots are available
    private void updateAvailableSpots(Vehicle vehicle) {
        // Create a spots required HashMap for the current vehicle
        ArrayList<HashMap<SpotType, Integer>> spotPreferences = vehicle.getSpotPreferences();
        for (HashMap<SpotType, Integer> spotPreference : spotPreferences) {
            System.out.println("Attempting to park: " + vehicle.type.toString().toLowerCase());

            if(checkForSpace(spotPreference)) {
                availableSpots.put(COMPACT, availableSpots.get(COMPACT) - spotPreference.get(COMPACT));
                availableSpots.put(REGULAR, availableSpots.get(COMPACT) - spotPreference.get(REGULAR));
                printAvailableSpots();
                return;
            }
        }
        System.out.println("Sorry. There is not enough space available for your vehicle.");
    }

    public boolean isParkingLotEmpty() {
        return availableSpots.get(COMPACT) == totalCompactSpots && availableSpots.get(REGULAR) == totalRegularSpots;
    }

}
