package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.company.SpotType.COMPACT;
import static com.company.SpotType.REGULAR;
import static com.company.VehicleType.*;

public class ParkingLot {
    ArrayList<Vehicle> parkedVehicles = new ArrayList<>();
    Integer totalCompactSpots;
    Integer totalRegularSpots;
    HashMap<SpotType, Integer> availableSpots = new HashMap<>();

    public ParkingLot(int nCompact, int nRegular) {
        totalCompactSpots = nCompact;
        totalRegularSpots = nRegular;
        initialiseAvailableSpots(nCompact, nRegular);
    }

    private void initialiseAvailableSpots(int nCompact, int nRegular) {
        availableSpots.put(COMPACT, nCompact);
        availableSpots.put(REGULAR, nRegular);
    }

    public void parkVehicle(Vehicle vehicle) {
        System.out.println("Attempting to park: " + vehicle.type.toString().toLowerCase());
        if (updateAvailableSpots(vehicle)) {
            parkedVehicles.add(vehicle);
            System.out.println("Vehicle parked.");
        } else {
            System.out.println("Sorry, there's not enough space for your vehicle.");
        }
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

    private boolean checkForSpace(Integer spotPreferenceCompact, Integer spotPreferenceRegular) {
        boolean requiredCompactSpotsAvailable = availableSpots.get(COMPACT) >= spotPreferenceCompact;
        boolean requiredRegularSpotsAvailable = availableSpots.get(REGULAR) >= spotPreferenceRegular;

        return requiredCompactSpotsAvailable && requiredRegularSpotsAvailable;
    }

    private boolean updateAvailableSpots(Vehicle vehicle) {
        ArrayList<HashMap<SpotType, Integer>> spotPreferences = vehicle.getSpotPreferences();
        for (HashMap<SpotType, Integer> spotPreference : spotPreferences) {

            Integer spotPreferenceCompact = spotPreference.get(COMPACT);
            Integer spotPreferenceRegular = spotPreference.get(REGULAR);

            if(checkForSpace(spotPreferenceCompact, spotPreferenceRegular)) {
                availableSpots.put(COMPACT, availableSpots.get(COMPACT) - spotPreferenceCompact);
                availableSpots.put(REGULAR, availableSpots.get(REGULAR) - spotPreferenceRegular);
                vehicle.incrementOccupiedSpots(spotPreferenceCompact, spotPreferenceRegular);
                printAvailableSpots();
                return true;
            }
        }
        return false;
    }

    public boolean isParkingLotEmpty() {
        return Objects.equals(availableSpots.get(COMPACT), totalCompactSpots) && Objects.equals(availableSpots.get(REGULAR), totalRegularSpots);
    }

    public void getSpotsPerVehicle() {
        for (Vehicle vehicle : parkedVehicles) {
            Integer nCompact = vehicle.getOccupiedSpots().get(COMPACT);
            Integer nRegular = vehicle.getOccupiedSpots().get(REGULAR);
            System.out.println("This " + vehicle.getVehicleType().toString().toLowerCase() + " is taking up " + nCompact + " compact spot(s) and " + nRegular + " regular spot(s).");
        }
    }

    public void getSpotsPerVehicleType() {
        HashMap<VehicleType, Integer> spotsPerVehicleType = new HashMap<>();

        spotsPerVehicleType.put(MOTORCYCLE, 0);
        spotsPerVehicleType.put(CAR, 0);
        spotsPerVehicleType.put(VAN, 0);

        for (Vehicle vehicle : parkedVehicles) {
            Integer nCompact = vehicle.getOccupiedSpots().get(COMPACT);
            Integer nRegular = vehicle.getOccupiedSpots().get(REGULAR);
            spotsPerVehicleType.put(vehicle.type, spotsPerVehicleType.get(vehicle.type) + nCompact + nRegular);
        }

        System.out.println("Motorcycles are using " + spotsPerVehicleType.get(MOTORCYCLE) + " spaces.");
        System.out.println("Cars are using " + spotsPerVehicleType.get(CAR) + " spaces.");
        System.out.println("Vans are using " + spotsPerVehicleType.get(VAN) + " spaces.");
    }
}
