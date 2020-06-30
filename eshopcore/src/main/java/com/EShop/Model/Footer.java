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

    public Footer(int ID, String Content, boolean IsShow) {
        this.ID = ID;
        this.Content = Content;
        this.IsShow = IsShow;
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

    public boolean isIsShow() {
        return IsShow;
    }

    public void setIsShow(boolean IsShow) {
        this.IsShow = IsShow;
    }
    int ID;
    String Content;
    boolean IsShow;
}
