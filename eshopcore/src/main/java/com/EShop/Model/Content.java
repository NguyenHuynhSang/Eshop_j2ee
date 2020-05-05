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
public class Content {

    public Content(int ID, String Name, String MetaTitle, String Description, String Image, int CategoryID, String Detail, int Warranty, Date CreateDate, String CreateBy, Date ModifiedDate, String ModifiedBy, String MetaKeywords, String MetaDescription, boolean Status, Date TopHot, int ViewCount, String Tags, String Language) {
        this.ID = ID;
        this.Name = Name;
        this.MetaTitle = MetaTitle;
        this.Description = Description;
        this.Image = Image;
        this.CategoryID = CategoryID;
        this.Detail = Detail;
        this.Warranty = Warranty;
        this.CreateDate = CreateDate;
        this.CreateBy = CreateBy;
        this.ModifiedDate = ModifiedDate;
        this.ModifiedBy = ModifiedBy;
        this.MetaKeywords = MetaKeywords;
        this.MetaDescriptions = MetaDescription;
        this.Status = Status;
        this.TopHot = TopHot;
        this.ViewCount = ViewCount;
        this.Tags = Tags;
        this.Language = Language;
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

    public String getMetaTitle() {
        return MetaTitle;
    }

    public void setMetaTitle(String MetaTitle) {
        this.MetaTitle = MetaTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public int getWarranty() {
        return Warranty;
    }

    public void setWarranty(int Warranty) {
        this.Warranty = Warranty;
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

    public String getMetaKeywords() {
        return MetaKeywords;
    }

    public void setMetaKeywords(String MetaKeywords) {
        this.MetaKeywords = MetaKeywords;
    }

    public String getMetaDescriptions() {
        return MetaDescriptions;
    }

    public void setMetaDescriptions(String MetaDescription) {
        this.MetaDescriptions = MetaDescription;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Date getTopHot() {
        return TopHot;
    }

    public void setTopHot(Date TopHot) {
        this.TopHot = TopHot;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void setViewCount(int ViewCount) {
        this.ViewCount = ViewCount;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }
    int ID;
    String Name;
    String MetaTitle;
    String Description;
    String Image;
    int CategoryID;
    String Detail;
    int Warranty;
    Date CreateDate;
    String CreateBy;
    Date ModifiedDate;
    String ModifiedBy;
    String MetaKeywords;
    String MetaDescriptions;
    boolean Status;
    Date TopHot;
    int ViewCount;
    String Tags;
    String Language;
}
