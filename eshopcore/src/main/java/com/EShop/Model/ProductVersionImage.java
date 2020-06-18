package com.EShop.Model;

public class ProductVersionImage {
    private String Url ;
    private boolean IsMain ;
    private int ProductVersionID ;

    public ProductVersionImage(String url, boolean isMain, int productVersionID) {
        Url = url;
        IsMain = isMain;
        ProductVersionID = productVersionID;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public boolean isMain() {
        return IsMain;
    }

    public void setMain(boolean main) {
        IsMain = main;
    }

    public int getProductVersionID() {
        return ProductVersionID;
    }

    public void setProductVersionID(int productVersionID) {
        ProductVersionID = productVersionID;
    }
}
