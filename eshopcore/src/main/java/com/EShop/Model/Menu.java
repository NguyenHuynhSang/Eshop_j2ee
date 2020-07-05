package com.EShop.Model;

public class Menu {
    private int ID;
    private String Link;
    private String Text;
    private int DisplayOrder;
    private String Target;
    private int MenuGroupID;
    private boolean IsShow;

    public  Menu(){
        IsShow=false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String targer) {
        Target = targer;
    }

    public int getMenuGroupID() {
        return MenuGroupID;
    }

    public void setMenuGroupID(int menuGroupID) {
        MenuGroupID = menuGroupID;
    }

    public boolean isShow() {
        return IsShow;
    }

    public void setShow(boolean show) {
        IsShow = show;
    }
}
