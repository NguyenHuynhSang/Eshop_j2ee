package com.EShop.Service;

import com.EShop.Model.Menu;
import com.EShop.Model.User;
import com.EShop.Model.UserGroup;
import com.EShop.Service.IService.IUserService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    Connection conn = DbConnection.getJDBCConnection();
    @Override
    public List<User> GetListUser() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select u.ID,gr.ID as gID,u.Username,u.Password,u.Name,u.Sex,u.Address,u.Phone,u.Email,u.IsLock,gr.GroupName\n" +
                "from [User] u\n" +
                "join UserGroup gr\n" +
                "on u.UserGroupID=gr.ID\n" +
                "\n";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("Username"));
            user.setName(rs.getString("Name"));
            user.setID(rs.getInt("ID"));
            user.setAddress(rs.getString("Address"));
            user.setEmail(rs.getString("Email"));
            user.setLock(rs.getBoolean("IsLock"));
            user.setPassword(rs.getString("Password"));
            user.setPhone(rs.getString("Phone"));
            UserGroup group=new UserGroup();
            group.setID(rs.getInt("gID"));
            group.setGroupName(rs.getString("GroupName"));
            user.setUserGroup(group);
            users.add(user);
        }
        rs.close();
        stmt.close();
        conn.close();
        return users;
    }

    @Override
    public User Login(User user) throws SQLException {
        User userReturn=new User();
        Statement stmt;
        stmt = conn.createStatement();
        String sqlQuery = "select *\n" +
                "from [User] u\n" +
                "where  u.Username='"+user.getUsername()+"'" +
                "  AND\n" +
                "u.Password='"+user.getPassword()+"'";
        ResultSet rs = stmt.executeQuery(sqlQuery);
       if (rs.next())
       {
           user.setUsername(rs.getString("Username"));
           user.setName(rs.getString("Name"));
           user.setID(rs.getInt("ID"));
           user.setAddress(rs.getString("Address"));
           user.setEmail(rs.getString("Email"));
           user.setLock(rs.getBoolean("IsLock"));
           user.setPassword(rs.getString("Password"));
           user.setPhone(rs.getString("Phone"));
           user.setUserGroupID(rs.getInt("UserGroupID"));
           rs.close();
           stmt.close();
           conn.close();
           return  user;

       }
        rs.close();
        stmt.close();
        conn.close();
        return null;
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
