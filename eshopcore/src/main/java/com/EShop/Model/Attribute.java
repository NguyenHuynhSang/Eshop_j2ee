package com.EShop.Model;

public class Attribute {
    private  int ID;
    private  String Name;

    public Attribute(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
