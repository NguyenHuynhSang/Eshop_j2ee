package com.EShop.Model;

public class ProductAttribute {
    private  int ID;
    private int AttributeValueID;

    private int ProductVersionID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAttributeValueID() {
        return AttributeValueID;
    }

    public void setAttributeValueID(int attributeValueID) {
        AttributeValueID = attributeValueID;
    }

    public int getProductVersionID() {
        return ProductVersionID;
    }

    public void setProductVersionID(int productVersionID) {
        ProductVersionID = productVersionID;
    }
}
