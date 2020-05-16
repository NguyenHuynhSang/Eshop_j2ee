package com.EShop.Model;

public class AttributeValue {
    private  int ID;
    private  int AttributeID;
    private  String name;

    public AttributeValue(int ID, int attributeID, String name) {
        this.ID = ID;
        AttributeID = attributeID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAttributeID() {
        return AttributeID;
    }

    public void setAttributeID(int attributeID) {
        AttributeID = attributeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
