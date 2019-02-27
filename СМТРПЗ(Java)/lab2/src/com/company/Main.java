package com.company;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        Gson json = new Gson();
        Person p1 = new Person("Sasha", 19);
        Person p2 = new Person("Kolya", 19);
        System.out.println(p1.equals(p2));

        String tmp = json.toJson(p1);
        Person p3 = json.fromJson(tmp, Person.class);

        System.out.println(p1.equals(p3));
    }
}
