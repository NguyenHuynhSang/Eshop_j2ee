package com.EShop.Model.UserModel;

import com.EShop.Model.ViewModel.ProductDetailViewModel;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private   int ID;
    private ProductDetailViewModel ProductVerion;
    private int OrderID;
    private int Quantity;
    private Number Price;

    public OrderDetail() {}



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Number getPrice() {
        return Price;
    }

    public void setPrice(Number price) {
        Price = price;
    }

    public ProductDetailViewModel getProductVerion() {
        return ProductVerion;
    }

    public void setProductVerion(ProductDetailViewModel productVerion) {
        ProductVerion = productVerion;
    }
}
