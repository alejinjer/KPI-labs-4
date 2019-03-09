package com.company;

public class Main {

    public static void main(String[] args) {
        Tourniquet t = new Tourniquet();
        DataBase db = new DataBase();

        NormalCard card = db.createNormalCard();
        System.out.println(t.check(card));

        card.accountReplenishment(5);
        System.out.println(t.check(card));
        System.out.println(t.check(card));

        t.showHistory();

        System.out.println("///////////////////////////////////////////");

        StudentCard card1 = db.createStudentCard();
        System.out.println(t.check(card1));

        card1.add5Uses();
        System.out.println(t.check(card1));
        System.out.println(t.check(card1));
        System.out.println(t.check(card1));
        System.out.println(t.check(card1));
        System.out.println(t.check(card1));
        System.out.println(t.check(card1));

        t.showHistory();

        System.out.println("///////////////////////////////////////////");

        SchoolCard card2 = db.createSchoolCard();
        System.out.println(t.check(card2));

        card2.setFinalDate(1,06,2020);
        System.out.println(t.check(card2));

        t.showSeparatedHistory(SchoolCard.class);
    }
}
