package com.EShop.Service;

import com.EShop.Model.User;
import com.EShop.Service.IService.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public List<User> GetListUser() throws SQLException {
        return null;
    }

    @Override
    public boolean Login(User user) throws SQLException {
        return false;
    }

    @Override
    public User CreateUser(User user) throws SQLException {
        return null;
    }

    @Override
    public void LockUser(int userID) throws SQLException {

    }

    @Override
    public void UpdateUser(int ID) throws SQLException {

    }
}
