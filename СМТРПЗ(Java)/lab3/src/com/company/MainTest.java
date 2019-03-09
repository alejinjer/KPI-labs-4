package com.company;

import org.junit.Assert;

public class MainTest {

    Tourniquet tourniquet = new Tourniquet();
    DataBase DB = new DataBase();


    @org.junit.Test
    public void test_different_ID_false()
    {
        SchoolCard card = DB.createSchoolCard();
        card.add5Uses();
        card.setID(123);
        boolean result = card.pass();
        Assert.assertEquals(result, false);
    }

    @org.junit.Test
    public void test_school_finalDate_true()
    {
        SchoolCard card = DB.createSchoolCard();
        card.setFinalDate(1,1,2025);
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, true);
    }

    @org.junit.Test
    public void test_school_finalDate_false()
    {
        SchoolCard card = DB.createSchoolCard();
        card.setFinalDate(1,1,2015);
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, false);
    }

    @org.junit.Test
    public void test_student_uses_true()
    {
        StudentCard card = DB.createStudentCard();
        card.add5Uses();
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, true);
    }

    @org.junit.Test
    public void test_student_uses_false()
    {
        StudentCard card = DB.createStudentCard();
        card.add5Uses();
        tourniquet.check(card);
        tourniquet.check(card);
        tourniquet.check(card);
        tourniquet.check(card);
        tourniquet.check(card);
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, false);
    }

    @org.junit.Test
    public void test_normal_cash_true()
    {
        NormalCard card = DB.createNormalCard();
        card.accountReplenishment(10);
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, true);
    }

    @org.junit.Test
    public void test_normal_cash_false()
    {
        NormalCard card = DB.createNormalCard();
        card.accountReplenishment(10);
        tourniquet.check(card);
        tourniquet.check(card);
        boolean result = tourniquet.check(card);
        Assert.assertEquals(result, false);
    }
}