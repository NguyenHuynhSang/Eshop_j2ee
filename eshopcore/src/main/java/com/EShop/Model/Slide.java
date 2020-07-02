package com.EShop.Model;

import java.util.Date;

public class Slide {
    private  int ID;
    private  String Image;
    private String Url;
    private boolean isShow;
    private String CreatedBy;
    private Date CreateDate;

    private String ModifiedBy;
    private Date ModifiedDate;
    private String Title;
    private String Content;

    public Slide(int ID, String image, String url, boolean isShow, String createdBy, Date createDate, String modifiedBy, Date modifiedDate, String title, String content) {
        this.ID = ID;
        Image = image;
        Url = url;
        this.isShow = isShow;
        CreatedBy = createdBy;
        CreateDate = createDate;
        ModifiedBy = modifiedBy;
        ModifiedDate = modifiedDate;
        Title = title;
        Content = content;
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

    public void setImage(String image) {
        Image = image;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
