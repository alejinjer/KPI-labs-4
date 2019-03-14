package com.company;

import java.util.ArrayList;

public class Road {
    public ArrayList<Transport> carsOnRoad;

    Road() {
        carsOnRoad = new ArrayList<Transport>();
    }

    public int getCountOfHumans() {
        int count = 0;
        for(Transport t : carsOnRoad) {
            count+=t.getCountOfPassengers();
        }
        return count;
    }
    public void addCarToRoad(Transport t){
        if(!carsOnRoad.contains(t)) {
            carsOnRoad.add(t);
        } else {
            throw new Error("This car is already on the road");
        }
    }
}
