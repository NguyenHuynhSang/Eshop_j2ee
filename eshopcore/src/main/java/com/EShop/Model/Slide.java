/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Model;

import java.sql.Date;

/**
 *
 * @author nhatminh
 */
public class Slide {

    public Slide(int ID, String Image, boolean IsShow, Date CreateDate, String CreateBy, Date ModifiedDate, String ModifiedBy,String Url,String Title,String Content) {
        this.ID = ID;
        this.Image = Image;
        this.IsShow = IsShow;
        this.CreateDate = CreateDate;
        this.CreateBy = CreateBy;
        this.ModifiedDate = ModifiedDate;
        this.ModifiedBy = ModifiedBy;
        this.Url = Url;
        this.Title = Title;
        this.Content= Content;
    }

    public Slide() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public boolean isIsShow() {
        return IsShow;
    }

    public void setIsShow(boolean IsShow) {
        this.IsShow = IsShow;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String CreateBy) {
        this.CreateBy = CreateBy;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String ModifiedBy) {
        this.ModifiedBy = ModifiedBy;
    }
    
        public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
        public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
    int ID;
    String Image;
    boolean IsShow;
    Date CreateDate;
    String CreateBy;
    Date ModifiedDate;
    String ModifiedBy;
    String Url;
    String Title;
    String Content;
}
