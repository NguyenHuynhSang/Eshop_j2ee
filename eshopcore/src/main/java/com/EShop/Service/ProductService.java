package com.EShop.Service;

import com.EShop.IService.IProductService;
import com.EShop.Model.InputModel.ProductInput;
import com.EShop.Model.Product;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ProductService  implements IProductService {
    Connection conn = DbConnection.getJDBCConnection();

    @Override
    public List<Product> GetProducts() throws SQLException {
        return null;
    }

    @Override
    public List<Product> GetProductAllVersionPaging() throws SQLException {
        return null;
    }

    @Override
    public void InsertProduct(ProductInput product) throws SQLException {
        Statement statement;
        String sqlQuery="select * \n" +
                "from Product\n" +
                "where Name='"+product.Name+ "'"; // check trùng
        ResultSet rs;
        conn.setAutoCommit(false);
        statement = conn.createStatement();


        String createdDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Calendar.getInstance().getTime());
        rs = statement.executeQuery(sqlQuery);
        if (rs.next() == false)
        {

            sqlQuery="Insert into Product (CatalogID,Url,Name,Description,Content,CreatedDate,CreatedBy,Weight,OriginalPrice,Deliver,SEOTitle,SEOUrl,SEODescription,ApplyPromotion) \n" +
                    "values (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";
            String columnNames[] = new String[] { "ID" };

            PreparedStatement pStatement=conn.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
            //statement = conn.prepareStatement(sqlQuery);
            pStatement.setObject(1,product.CatalogID);
            pStatement.setObject(2, product.Url);
            pStatement.setObject(3, product.Name);
            pStatement.setObject(4, product.Description);
            pStatement.setObject(5, product.Content);
            pStatement.setObject(6, createdDate);
            pStatement.setObject(7,product.CreatedBy);
            pStatement.setObject(8, product.Weight);
            pStatement.setObject(9, product.OriginalPrice);
            pStatement.setObject(10, product.Deliver);
            pStatement.setObject(11, product.SEOTitle);
            pStatement.setObject(12, product.SEOUrl);
            pStatement.setObject(13, product.SEODescription);
            pStatement.setObject(14, product.ApplyPromotion);
            int rowCount=pStatement.executeUpdate();
            ResultSet rss=pStatement.getGeneratedKeys();
            int  last_inserted_id=0;
            if (rss.next())
            {
               int productID = Integer.parseInt(rss.getObject(1).toString()) ;
            }
            pStatement.close();
        }
        else
        {
            System.out.println("Đã tồn tại sản phẩm");
        }
        rs.close();
        statement.close();
        conn.commit();
        conn.close();
    }

    @Override
    public void UpdateProduct(Product product) throws SQLException {

    }

    @Override
    public void DeleteProduct(Product[] product) throws SQLException {

    }
}
