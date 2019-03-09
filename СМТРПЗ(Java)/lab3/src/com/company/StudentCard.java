package com.company;

import java.util.Calendar;
import java.util.Date;

public class StudentCard extends AbstractCard {
    private int countOfUses;
    private Date finalDate;

    public int getCountOfUses() {
        return countOfUses;
    }

    public void add5Uses() {
        this.countOfUses += 5;
    }

    public void add10Uses() {
        this.countOfUses += 10;
    }

    public void setFinalDate(int date, int month, int year)
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DATE, date);
        finalDate = c.getTime();
    }

    public void tryPass() {
        if(countOfUses >= 1) {
            countOfUses--;
        }
    }

    public boolean pass() {
        if(!isDBcontains()) return false;
        if (finalDate != null)
        {
            Date currentDay = new Date();
            if (!currentDay.after(finalDate))
                return true;
        }
        if(countOfUses <= 0) {
            return false;
        }

        return true;
    }
}
