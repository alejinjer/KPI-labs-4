package com.company;

import java.util.ArrayList;

public abstract class Transport <T extends Human> {
    protected int seets;
    private ArrayList<T> passengers;

    Transport() {
        passengers = new ArrayList<T>();
    }
    public int getSeets() {
        return seets;
    }


    public void addPassenger(T human) {
        if(passengers.size() >= seets) {
            throw new IndexOutOfBoundsException("Sorry, there is no empty seets :/");

        } else if(passengers.contains(human)){
            throw new Error("You are already sitting inside!");
        } else {
            passengers.add(human);
        }
    }

    public void removePassenger(T human) {
        if(passengers.contains(human)) {
            passengers.remove(human);
        } else {
            throw new NullPointerException("There is no Passenger there");
        }
    }

    public int getCountOfPassengers() {
        return passengers.size();
    }
}