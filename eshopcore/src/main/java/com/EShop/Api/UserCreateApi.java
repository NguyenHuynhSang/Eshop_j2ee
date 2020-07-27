package com.EShop.Api;


import com.EShop.Filter.AccountFilter;
import com.EShop.Model.*;

import com.EShop.Service.ContentCategoryService;
import com.EShop.Service.FooterService;
import com.EShop.Service.UserService;
import com.EShop.Utills.HttpUtil;
import com.EShop.ViewModel.ContentCategoryViewModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "UserCreateAPI", urlPatterns = {"/API-CreateUser"})
public class UserCreateApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        UserService service = new UserService();
        Gson gson = new Gson();
        String js = req.getParameter("filterJson");

        AccountFilter filter = gson.fromJson(js, AccountFilter.class);
        String ID = req.getParameter("ID");

        String action = req.getParameter("action");
        String Username= req.getParameter("Username");
        String Id=req.getParameter("ID");
        PrintWriter printWriter = resp.getWriter();
        List<User> users = new ArrayList<User>();

        if(action == null)
        {
            try {
                users = service.GetListUser(filter);
                printWriter.print(gson.toJson(users));
            } catch (SQLException ex) {
                log(ex.toString());
            }
        }
        else {
            try {
                switch (action) {
                    case "getAll":
                        users = service.GetListUser(filter);
                        printWriter.print(gson.toJson(users));
                        break;
                    case "checkUsername":
                        users = service.CheckUserName(Username);
                        printWriter.print(gson.toJson(users));
                        break;
                    case "getByID":
                        users=service.GetUserByID(Integer.parseInt(Id));
                        printWriter.print(gson.toJson(users));
                        break;
                }
            } catch (SQLException ex) {

            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json

        Gson gson=new Gson();
        UserService jsonservice = new UserService();

        String js = HttpUtil.of(request.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
        User tag=gson.fromJson(js, User.class);
        try {
            jsonservice.CreateUser(tag);
        } catch (SQLException ex) {
            Logger.getLogger(SlideAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json");

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        UserService jsonservice = new UserService();

        String js = HttpUtil.of(request.getReader());
        User user=gson.fromJson(js, User.class);
        try {
            jsonservice.UpdateUser(user);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
