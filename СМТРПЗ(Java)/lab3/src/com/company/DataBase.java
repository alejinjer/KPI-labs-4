package com.company;

import java.util.ArrayList;

public class DataBase {
    static ArrayList <AbstractCard> DB;
    static int price = 5;

    DataBase() {
        DB = new ArrayList<AbstractCard>();
    }

    void addToDB(AbstractCard card) {
        DB.add(card);
        card.setID(DB.indexOf(card));
    }

    SchoolCard createSchoolCard() {
        SchoolCard card = new SchoolCard();
        addToDB(card);
        return card;
    }

    StudentCard createStudentCard() {
        StudentCard card = new StudentCard();
        addToDB(card);
        return card;
    }

    NormalCard createNormalCard() {
        NormalCard card = new NormalCard();
        addToDB(card);
        return card;
    }
}
