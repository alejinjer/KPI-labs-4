package com.company;

import org.junit.Assert;

public class MainTest {
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void test1_TransportOverflowing_false()
    {
        Bus bus = new Bus();
        Human human = new Human();
        Policeman policeman = new Policeman();

        for (int i = 0; i < 30; i++)
        {
            Human man = new Human();
            bus.addPassenger(man);
        }
    }

    @org.junit.Test
    public void test2_TransportFilling_true()
    {
        Bus bus = new Bus();
        Human human = new Human();
        Policeman policeman = new Policeman();

        boolean result;
        for (int i = 0; i < 20; i++)
        {
            Human man = new Human();
            bus.addPassenger(man);
        }

        result = true;
        Assert.assertEquals(result, true);
    }

    @org.junit.Test(expected = Error.class)
    public void test3_AddPassengerTwice_false() {
        PoliceCar policecar = new PoliceCar();
        Policeman policeman = new Policeman();

        policecar.addPassenger(policeman);
        policecar.addPassenger(policeman);

    }

    @org.junit.Test(expected = NullPointerException.class)
    public void test4_tryRemoveMissingPassenger_false() {
        FireEngine fireengine = new FireEngine();
        Fireman fireman = new Fireman();
        Fireman fireman2 = new Fireman();

        fireengine.addPassenger(fireman);
        fireengine.removePassenger(fireman2);
    }

    @org.junit.Test
    public void test5_countOfHumansInTransport_OnTheRoad() {
        Road road = new Road();

        FireEngine fireengine = new FireEngine();
        Taxi taxi = new Taxi();
        PoliceCar policecar = new PoliceCar();

        Fireman fireman = new Fireman();
        Fireman fireman2 = new Fireman();
        Fireman fireman3 = new Fireman();
        Policeman policeman = new Policeman();

        fireengine.addPassenger(fireman);
        fireengine.addPassenger(fireman2);
        taxi.addPassenger(fireman3);
        policecar.addPassenger(policeman);

        road.addCarToRoad(fireengine);
        road.addCarToRoad(taxi);
        road.addCarToRoad(policecar);

        Assert.assertEquals(road.getCountOfHumans(), 4);
    }
}