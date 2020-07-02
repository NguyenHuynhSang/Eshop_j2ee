package com.EShop.Model;

import java.text.DecimalFormat;
import java.util.Date;

public class Product {
    private int ID;
    private boolean ApplyPromotion;
    private int CatalogID;
    private String Content;
    private boolean Deliver;
    private String CreatedBy;
    private Date CreateDate;
    private String Description;
    private String ModifiedBy;
    private Date ModifiedDate;
    private String Name;
    private double OriginalPrice;
    private String SEODescription;
    private String SEOTitle;
    private String SEOUrl;
    private String Url;
    private int Weight;
    public  Product(){};
    public Product(int ID, boolean applyPromotion, int catalogID, String content, boolean deliver, String createdBy, Date createDate, String description, String modifiedBy, Date modifiedDate, String name, double originalPrice, String SEODescription, String SEOTitle, String SEOUrl, String url, int weight) {
        this.ID = ID;
        ApplyPromotion = applyPromotion;
        CatalogID = catalogID;
        Content = content;
        Deliver = deliver;
        CreatedBy = createdBy;
        CreateDate = createDate;
        Description = description;
        ModifiedBy = modifiedBy;
        ModifiedDate = modifiedDate;
        Name = name;
        OriginalPrice = originalPrice;
        this.SEODescription = SEODescription;
        this.SEOTitle = SEOTitle;
        this.SEOUrl = SEOUrl;
        Url = url;
        Weight = weight;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isApplyPromotion() {
        return ApplyPromotion;
    }

    public void setApplyPromotion(boolean applyPromotion) {
        ApplyPromotion = applyPromotion;
    }

    public int getCatalogID() {
        return CatalogID;
    }

    public void setCatalogID(int catalogID) {
        CatalogID = catalogID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isDeliver() {
        return Deliver;
    }

    public void setDeliver(boolean deliver) {
        Deliver = deliver;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getOriginalPrice() {
        return OriginalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        OriginalPrice = originalPrice;
    }

    public String getSEODescription() {
        return SEODescription;
    }

    public void setSEODescription(String SEODescription) {
        this.SEODescription = SEODescription;
    }

    public String getSEOTitle() {
        return SEOTitle;
    }

    public void setSEOTitle(String SEOTitle) {
        this.SEOTitle = SEOTitle;
    }

    public String getSEOUrl() {
        return SEOUrl;
    }

    public void setSEOUrl(String SEOUrl) {
        this.SEOUrl = SEOUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }
}
