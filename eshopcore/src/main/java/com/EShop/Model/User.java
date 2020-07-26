package com.EShop.Model;

public class User {
    private int ID;
    private String Username;
    private String Password;
    private String Name;
    private String Sex;
    private String Address;
    private String Email;
    private String Phone;
    private int UserGroupID;
    private UserGroup UserGroup;
    private  boolean IsLock;
    public User() {
        IsLock=false;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getUserGroupID() {
        return UserGroupID;
    }

    public void setUserGroupID(int userGroupID) {
        UserGroupID = userGroupID;
    }

    public com.EShop.Model.UserGroup getUserGroup() {
        return UserGroup;
    }

    public void setUserGroup(com.EShop.Model.UserGroup userGroup) {
        UserGroup = userGroup;
    }

    public boolean isLock() {
        return IsLock;
    }

    public void setLock(boolean lock) {
        IsLock = lock;
    }
}
