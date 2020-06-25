/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Model;

import java.sql.Date;


public class ContentCategory {
    int ID;
    String Name;
    int ParentID;
    String Metatitle;
    String SeoTitle;
    int DisplayOrder;
    Date CreateDate;
    String CreateBy;
    Date ModifiedDate;
    String ModifiedBy;
    String MetaKeyWords;
    String MetaDesciptions;
    boolean Status;
    boolean ShowOnHome;
    String Language;

    public ContentCategory() {
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

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int ParentID) {
        this.ParentID = ParentID;
    }

    public String getMetatitle() {
        return Metatitle;
    }

    public void setMetatitle(String Metatitle) {
        this.Metatitle = Metatitle;
    }

    public String getSeoTitle() {
        return SeoTitle;
    }

    public void setSeoTitle(String SeoTitle) {
        this.SeoTitle = SeoTitle;
    }

    public void setDisplayOrder(int DisplayOrder) {
        this.DisplayOrder = DisplayOrder;
    }
    
    public int getDisplayOrder() {
       return this.DisplayOrder;
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

    public String getMetaKeyWords() {
        return MetaKeyWords;
    }

    public void setMetaKeyWords(String MetaKeyWords) {
        this.MetaKeyWords = MetaKeyWords;
    }

    public String getMetaDesciptions() {
        return MetaDesciptions;
    }

    public void setMetaDesciptions(String MetaDesciptions) {
        this.MetaDesciptions = MetaDesciptions;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public boolean isShowOnHome() {
        return ShowOnHome;
    }

    public void setShowOnHome(boolean ShowOnHome) {
        this.ShowOnHome = ShowOnHome;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public ContentCategory(int ID, String Name, int ParentID, String Metatitle, String SeoTitle, int DisplayOrder, Date CreateDate, String CreateBy, Date ModifiedDate, String ModifiedBy, String MetaKeyWords, String MetaDesciptions, boolean Status, boolean ShowOnHome, String Language) {
        this.ID = ID;
        this.Name = Name;
        this.ParentID = ParentID;
        this.Metatitle = Metatitle;
        this.SeoTitle = SeoTitle;
        this.DisplayOrder = DisplayOrder;
        this.CreateDate = CreateDate;
        this.CreateBy = CreateBy;
        this.ModifiedDate = ModifiedDate;
        this.ModifiedBy = ModifiedBy;
        this.MetaKeyWords = MetaKeyWords;
        this.MetaDesciptions = MetaDesciptions;
        this.Status = Status;
        this.ShowOnHome = ShowOnHome;
        this.Language = Language;
    }




}
