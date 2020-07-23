package com.EShop.Model;

public class ProductVersion {
    private int ID ;
    private int ProductID ;
    private int WareHouseID ;
    private String Description ;
    private Number Price ;
    private String SEODescription;

    public com.EShop.Model.Product getProduct() {
        return Product;
    }

    public void setProduct(com.EShop.Model.Product product) {
        Product = product;
    }
    
    private Product Product;
    private String SEOTitle;
    private String SEOUrl;
    private String Image;
    public ProductVersion(){};
    public ProductVersion(int ID, int productID, int wareHouseID, String description, Number price, String SEODescription, String SEOTitle, String SEOUrl, String image, Number promotionPrice, int quantum, int remainingAmount, String SKU, String barcode) {
        this.ID = ID;
        ProductID = productID;
        WareHouseID = wareHouseID;
        Description = description;
        Price = price;
        this.SEODescription = SEODescription;
        this.SEOTitle = SEOTitle;
        this.SEOUrl = SEOUrl;
        Image = image;
        PromotionPrice = promotionPrice;
        Quantum = quantum;
        RemainingAmount = remainingAmount;
        this.SKU = SKU;
        Barcode = barcode;
    }


    public Number getPromotionPrice() {
        return PromotionPrice;
    }

    public void setPromotionPrice(Number promotionPrice) {
        PromotionPrice = promotionPrice;
    }

    private Number PromotionPrice;

    private int Quantum ;

    private int RemainingAmount ;



    private String SKU ;

    private String Barcode ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getWareHouseID() {
        return WareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        WareHouseID = wareHouseID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Number getPrice() {
        return Price;
    }

    public void setPrice(Number price) {
        Price = price;
    }

    public int getQuantum() {
        return Quantum;
    }

    public void setQuantum(int quantum) {
        Quantum = quantum;
    }

    public int getRemainingAmount() {
        return RemainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        RemainingAmount = remainingAmount;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
