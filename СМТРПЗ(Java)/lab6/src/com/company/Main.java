package com.company;

import java.util.ArrayList;

public class Main {

    getAverageLength getAverageLength = array -> {
        float average = 0;
        for(String s : array) {
            average += s.length();
        }
        return average/array.length;
    };

    getMoreThanAverage getMoreThanAverage = array -> {
        ArrayList<String> lessThanAverage = new ArrayList<String>();
        for(String s : array) {
            if(s.length() > getAverageLength.getAverageLength(array)) {
                lessThanAverage.add(s);
            }
        }
        return lessThanAverage.toArray(new String[0]);
    };

    getLessThanAverage getLessThanAverage = array -> {
        ArrayList<String> lessThanAverage = new ArrayList<String>();
        for(String s : array) {
            if (s.length() < getAverageLength.getAverageLength(array)) {
                lessThanAverage.add(s);
            }
        }
        return lessThanAverage.toArray(new String[0]);
    };

    printArr printArr = array -> {
        for(String s : array) {
            System.out.println(s);
        }
    };
}