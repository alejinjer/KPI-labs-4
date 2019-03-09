package com.company;

abstract class AbstractCard {
    private int ID;

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getType() { return getClass().getSimpleName(); }

    public boolean isDBcontains() {
        if(!DataBase.DB.contains(this)) return false;
        if(DataBase.DB.indexOf(this) != getID()) return false;
        return true;
    }

    abstract public boolean pass();
    abstract public void tryPass();
}