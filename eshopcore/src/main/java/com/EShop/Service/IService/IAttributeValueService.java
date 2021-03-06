package com.EShop.Service.IService;

import com.EShop.Model.AttributeValue;

import java.sql.SQLException;
import java.util.List;

public interface IAttributeValueService {
    public List<AttributeValue> GetAttributeValue() throws SQLException;
    public List<AttributeValue> GetAttributeValueByAtributeID(int id) throws  SQLException;
    public void InsertAttributeValue(AttributeValue attribute)throws SQLException;
    public void UpdateAttributeValue(AttributeValue attribute)throws SQLException;
    public void DeleteAttributeValue(AttributeValue[] attribute) throws SQLException;
}
