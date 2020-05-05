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
public class ContentTag {

    public ContentTag(String TagID, int ContentID) {
        this.TagID = TagID;
        this.ContentID = ContentID;
    }

    public String getTagID() {
        return TagID;
    }

    public void setTagID(String TagID) {
        this.TagID = TagID;
    }

    public int getContentID() {
        return ContentID;
    }

    public void setContentID(int ContentID) {
        this.ContentID = ContentID;
    }
    String TagID;
    int ContentID;
}
