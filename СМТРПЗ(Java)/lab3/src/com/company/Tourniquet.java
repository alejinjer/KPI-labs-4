package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Tourniquet {
    static public ArrayList<CardInfo> history;

    Tourniquet() {
        history = new ArrayList<CardInfo>();
    }

    private void addToHistory(AbstractCard card) {
        CardInfo data = new CardInfo();
        data.card = card;
        data.ID = card.getID();
        data.access = card.pass();
        history.add(data);
    }

    public boolean check(AbstractCard card) {
        addToHistory(card);
        boolean access = card.pass();
        card.tryPass();
        return access;
    }

    public void showHistory() {
        for(CardInfo info : history) {
            System.out.println(info.card.getClass().getSimpleName()  + ", "
                    + "ID: " + info.ID + ", "
                    + "Date: " + info.date  + ", " + "Access: " + info.access);
        }
    }

    public void showSeparatedHistory(Class cardType) {
        for(CardInfo info : history) {
            if(cardType.getSimpleName() == info.card.getClass().getSimpleName()) {
                System.out.println(info.card.getClass().getSimpleName()  + ", "
                        + "ID: " + info.ID + ", "
                        + "Date: " + info.date  + ", " + "Access: " + info.access);
            }
        }
    }
}

class CardInfo {
    public AbstractCard card;
    public int ID;
    public Date date;
    public boolean access;
    CardInfo() {
        Date currDate = new Date();
        date = currDate;
    }
}
