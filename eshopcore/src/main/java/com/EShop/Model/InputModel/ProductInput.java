package com.EShop.Model.InputModel;

import com.EShop.Model.ProductAttribute;
import com.EShop.Model.ProductVersionImage;
import net.sourceforge.jtds.jdbc.DateTime;

import java.util.Date;
import java.util.List;
public class ProductInput {
    public long CatalogID ;
    public String Url ;
    public String Name ;

    public String Description ;

    public String Content ;

    public DateTime CreatedDate;

    public String CreatedBy;

    public DateTime ModifiedDate;

    public String ModifiedBy;

    public int Weight ;


    public Number OriginalPrice;

    public String Deliver ;

    public String SEOTitle ;

    public String SEOUrl ;

    public String SEODescription ;

    public String ApplyPromotion ;
    public List<ProductVersionInput> Versions ;
    private class ProductVersionInput
    {
        public int ID ;
        public int ProductID ;

        public int WareHouseID ;

        public String Description ;

        public Number Price ;

        public int Quantum ;

        public int RemainingAmount ;

        public String SKU ;
        public String Barcode ;
        public List<ProductAttribute> Attributes ;
        public List<ProductVersionImage> Images ;
    }

}
