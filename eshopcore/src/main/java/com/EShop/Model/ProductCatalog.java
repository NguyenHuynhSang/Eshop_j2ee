package com.EShop.Model;


import com.EShop.Model.Abstract.Auditable;
import com.EShop.Model.Abstract.Seoable;

import java.util.Date;

public class ProductCatalog {

    private int ID;
    private int ParentID;
    private String Name;
    private Date CreatedDate;
    private String CreatedBy;
    private Date ModifiedDate;
    public  ProductCatalog(){};
    public ProductCatalog(int ID, int parentID, String name, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy, String SEOTitle, String SEOURL, String SEODescription) {
        this.ID = ID;
        ParentID = parentID;
        Name = name;
        CreatedDate = createdDate;
        CreatedBy = createdBy;
        ModifiedDate = modifiedDate;
        ModifiedBy = modifiedBy;
        this.SEOTitle = SEOTitle;
        this.SEOURL = SEOURL;
        this.SEODescription = SEODescription;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getSEOTitle() {
        return SEOTitle;
    }

    public void setSEOTitle(String SEOTitle) {
        this.SEOTitle = SEOTitle;
    }

    public String getSEOURL() {
        return SEOURL;
    }

    public void setSEOURL(String SEOURL) {
        this.SEOURL = SEOURL;
    }

    public String getSEODescription() {
        return SEODescription;
    }

    public void setSEODescription(String SEODescription) {
        this.SEODescription = SEODescription;
    }

    private String ModifiedBy;
    private String SEOTitle;
    private String SEOURL;
    private String SEODescription;

}
