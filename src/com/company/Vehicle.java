package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import static com.company.SpotType.*;

public abstract class Vehicle {
    protected VehicleType type;
    protected ArrayList<HashMap<SpotType, Integer>> spotPreferences;
    protected HashMap<SpotType, Integer> occupiedSpots = new HashMap<>();

    public Vehicle(VehicleType type) {
        this.type = type;
        this.spotPreferences = initialiseSpotPreferences(type);
        initialiseOccupiedSpots();
    }

    // Initialise
    private ArrayList<HashMap<SpotType, Integer>> initialiseSpotPreferences(VehicleType type) {
        ArrayList<HashMap<SpotType, Integer>> spotPreferences = new ArrayList<>();

        if (type == VehicleType.VAN) {
            HashMap<SpotType, Integer> spotPreference = new HashMap<>();
            spotPreference.put(COMPACT, 0);
            spotPreference.put(REGULAR, 3);
            spotPreferences.add(spotPreference);
        } else {
            HashMap<SpotType, Integer> spotPreference1 = new HashMap<>();
            spotPreference1.put(COMPACT, 1);
            spotPreference1.put(REGULAR, 0);
            spotPreferences.add(spotPreference1);

            HashMap<SpotType, Integer> spotPreference2 = new HashMap<>();
            spotPreference2.put(COMPACT, 0);
            spotPreference2.put(REGULAR, 1);
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

    // Methods
    public void incrementOccupiedSpots(Integer nCompact, Integer nRegular) {
        occupiedSpots.put(COMPACT, occupiedSpots.get(COMPACT) + nCompact);
        occupiedSpots.put(REGULAR, occupiedSpots.get(REGULAR) + nRegular);
    }

}
