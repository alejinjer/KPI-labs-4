package com.company;

public class NormalCard extends AbstractCard{
    private int cash;

    public void tryPass() {
        if(cash >= DataBase.price) {
            cash -= DataBase.price;
        }
    }

    public int getCash() {
        return cash;
    }

    public void accountReplenishment(int value) {
        this.cash += value;
    }


    public boolean pass() {
        if(!isDBcontains() || cash < DataBase.price) return false;
        return true;
    }
}