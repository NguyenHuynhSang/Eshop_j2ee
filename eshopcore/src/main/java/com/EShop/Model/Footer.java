/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Model;

/**
 *
 * @author nhatminh
 */
public class Footer {

    public Footer() {
    }

    public Footer(int ID, String Content, boolean Status) {
        this.ID = ID;
        this.Content = Content;
        this.Status = Status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    int ID;
    String Content;
    boolean Status;
}
