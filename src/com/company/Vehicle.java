package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import static com.company.SpotType.*;

public abstract class Vehicle {
    protected VehicleType type;
    protected ArrayList<HashMap<SpotType, Integer>> spotPreferences = new ArrayList<HashMap<SpotType, Integer>>();
    protected HashMap<SpotType, Integer> occupiedSpots = new HashMap<SpotType, Integer>();

    public Vehicle(VehicleType type) {
        this.type = type;
        this.spotPreferences = initialiseSpotPreferences(type);
        initialiseOccupiedSpots();
    }

    // Initialise

    // Initialise Spot Preferences
    // Cars and Motorcycles both prefer 1 compact spot to a regular spot - 2 preferences
    // Vans require 3 regular spots - 1 preference
    private ArrayList<HashMap<SpotType, Integer>> initialiseSpotPreferences(VehicleType type) {
        ArrayList<HashMap<SpotType, Integer>> spotPreferences = new ArrayList<HashMap<SpotType, Integer>>();

        if (type == VehicleType.VAN) {
            HashMap<SpotType, Integer> spotPreference = new HashMap<SpotType, Integer>();
            spotPreference.put(SpotType.COMPACT, 0);
            spotPreference.put(SpotType.REGULAR, 3);
            spotPreferences.add(spotPreference);
        } else {
            HashMap<SpotType, Integer> spotPreference1 = new HashMap<SpotType, Integer>();
            spotPreference1.put(SpotType.COMPACT, 1);
            spotPreference1.put(SpotType.REGULAR, 0);
            spotPreferences.add(spotPreference1);

            HashMap<SpotType, Integer> spotPreference2 = new HashMap<SpotType, Integer>();
            spotPreference2.put(SpotType.COMPACT, 0);
            spotPreference2.put(SpotType.REGULAR, 1);
            spotPreferences.add(spotPreference2);
        }

        return spotPreferences;
    }

    private void initialiseOccupiedSpots() {
        occupiedSpots.put(COMPACT, 0);
        occupiedSpots.put(REGULAR, 0);
    }

    // Getters
    public ArrayList<HashMap<SpotType, Integer>> getSpotPreferences() {
        return spotPreferences;
    }

    public VehicleType getVehicleType() {
        return type;
    }

    public HashMap<SpotType, Integer> getOccupiedSpots() {
        return occupiedSpots;
    }

}
