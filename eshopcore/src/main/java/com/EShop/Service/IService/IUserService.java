package com.EShop.Service.IService;

import com.EShop.Filter.AccountFilter;
import com.EShop.Model.AttributeValue;
import com.EShop.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> GetListUser(AccountFilter filter) throws SQLException;
    public  User Login(User user) throws  SQLException;
    public  void CreateUser(User user) throws  SQLException;
    public void UpdateUser(User user) throws SQLException;
    public  void LockUser(int userID) throws  SQLException;
    public  void UpdateUser(int ID) throws  SQLException;


}
