package com.EShop.Model.InputModel;

import com.EShop.Model.ProductAttribute;
import com.EShop.Model.ProductVersionImage;
import net.sourceforge.jtds.jdbc.DateTime;
import java.util.Date;
import java.util.List;
public class ProductInput {
    public int ID;
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


    public int OriginalPrice;

    public String Deliver ;

    public String SEOTitle ;

    public String SEOUrl ;

    public String SEODescription ;

    public boolean ApplyPromotion ;
    public List<ProductVersionInput> Versions ;


}
