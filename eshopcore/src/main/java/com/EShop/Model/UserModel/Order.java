package com.EShop.Model.UserModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int ID;
    private List<OrderDetail> OrderDetails;
    private  int Status;

    private  String Note;
    private  String ShipName;
    private  String ShipMobile;
    private  String ShipAddress;
    private  String ShipEmail;


    private String CreatedBy;
    private Date CreateDate;
    private String ModifiedBy;
    private Date ModifiedDate;

    public Order() {
        Status=0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<OrderDetail> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.OrderDetails = orderDetails;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipMobile() {
        return ShipMobile;
    }

    public void setShipMobile(String shipMobile) {
        ShipMobile = shipMobile;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String shipAddress) {
        ShipAddress = shipAddress;
    }

    public String getShipEmail() {
        return ShipEmail;
    }

    public void setShipEmail(String shipEmail) {
        ShipEmail = shipEmail;
    }
}
