package com.EShop.dto.admin;

import java.util.Date;

public class OrderInputDto {
    public int ID;
    public  int Status;
    public  String Note;
    public  String ShipName;
    public  String ShipMobile;
    public  String ShipAddress;
    public  String ShipEmail;
    public String CreatedBy;
    public Date CreateDate;
    public String ModifiedBy;
    public Date ModifiedDate;
    public OrderInputDto() {
    }
}
