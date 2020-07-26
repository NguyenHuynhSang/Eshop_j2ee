/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.IService;


import com.EShop.Model.Slide;
import java.sql.SQLException;
import java.util.List;
public interface ISlideService extends IDbConnection<Slide> {
    public List<Slide> GetSlide() throws SQLException;
    public void InsertSlide(Slide slide)throws SQLException;
    public void UpdateSlide(Slide slide)throws SQLException;
    public void DeleteSlide(int slide) throws SQLException;
}
