package com.EShop.Model.InputModel;

import com.EShop.Model.ProductAttribute;
import com.EShop.Model.ProductVersionImage;

import java.util.List;

public class ProductVersionInput
{
    public int ID ;
    public int ProductID ;

    public int WareHouseID ;

    public String Description ;

    public int Price ;
    public int PromotionPrice;
    public int Quantum ;

    public int RemainingAmount ;

    public String SKU ;
    public String Barcode ;
    public List<ProductAttribute> Attributes ;
    public List<ProductVersionImage> Images ;
}