
package com.EShop.Service;

import com.EShop.Service.IService.ISlideService;
import com.EShop.Mapper.SlideMapper;
import com.EShop.Model.Slide;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class SlideService extends DbConnection<Slide> implements ISlideService{
    Connection conn = DbConnection.getJDBCConnection();
     @Override
     public List<Slide> GetSlide() throws SQLException
    {
        String sql="SELECT * FROM Slide";
        return query(sql,new SlideMapper());
    }  
     
    public List<Slide> GetJSONByID(String ID) throws SQLException
    {
       int id = Integer.parseInt(ID);
       String sqlQuery = "SELECT * FROM Slide WHERE ID = ?";
       return query(sqlQuery,new SlideMapper(), id);
    }
     
    
      public List<Slide> GetAllSlideByKey(String key) throws SQLException {
        String sqlQuery;
        if (key != "") {
            try {
                sqlQuery = "select * from Slide  where ID= ? OR Title LIKE %?%";
                return query(sqlQuery,new SlideMapper(),key,key);
            } catch (NumberFormatException e) {
                sqlQuery = "select * from Slide where  Title LIKE ?";
                return query(sqlQuery, new SlideMapper(),key);
            }
        }  
        return null;
    }
      
      public List<Slide> GetSlideActive() throws SQLException
      {
          String sqlQuery;
          sqlQuery = "select * from Slide Where IsShow = 'true'";
          return query(sqlQuery,new SlideMapper());
      }

     @Override
     public void InsertSlide(Slide slide)throws SQLException
     {
          String sqlQuery="INSERT INTO Slide (Title,Content,Image,IsShow,Url) VALUES (?,?,?,?,?)";
          Update(sqlQuery,slide.getTitle(),slide.getContent(),slide.getImage(),slide.isShow(),slide.getUrl());
     }
     
   
     @Override
     public void UpdateSlide(Slide slide)throws SQLException
     {
        String sqlQuery="UPDATE Slide SET Title = ?,Content = ?, Image = ? , IsShow = ? , Url=? WHERE ID = ?";
          Update(sqlQuery,slide.getTitle(),slide.getContent(),slide.getImage(),slide.isShow(),slide.getUrl());
     }
    @Override
    public void DeleteSlide(int id) throws SQLException
     {
        String sqlQuery = "Delete from Slide Where ID = ?";
        Update(sqlQuery, id);
         
     }


    public Slide GetSlideByID(String ID) throws SQLException
    {
        int id = Integer.parseInt(ID);
        String sqlQuery = "SELECT * FROM Slide WHERE ID = ?";
        List<Slide> slide = query(sqlQuery,new SlideMapper(), id);
        return slide.get(0);
    }

    public void SetActiveSlide(int id) throws SQLException
    {
        String sqlQuery;
        Slide slide = GetSlideByID(Integer.toString(id));
        if(!slide.isShow()) {
            sqlQuery = "Update Slide Set IsShow ='true' where ID = ?";
        } else
        {
            sqlQuery = "Update Slide Set IsShow ='false' where ID = ?";
        }
        Update(sqlQuery,id);
    }

}
