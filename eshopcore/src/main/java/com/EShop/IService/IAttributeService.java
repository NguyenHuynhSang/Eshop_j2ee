package com.EShop.IService;

import com.EShop.Model.Attribute;

import java.sql.SQLException;
import java.util.List;

public interface IAttributeService {
    public List<Attribute> GetAttribute() throws SQLException;
    public void InsertAttribute(Attribute attribute)throws SQLException;
    public void UpdateAttribute(Attribute attribute)throws SQLException;
    public void DeleteAttribute(Attribute[] attribute) throws SQLException;

}
