
package com.EShop.Model;

public class Tag {     
    String ID;
    String Name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Tag(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }
}
