package com.EShop.Api;

import com.EShop.Filter.AccountFilter;
import com.EShop.Filter.ProductFilter;
import com.EShop.Model.Content;
import com.EShop.Model.JSon;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.User;
import com.EShop.Service.ContentService;
import com.EShop.Service.ProductService;
import com.EShop.Service.UserService;
import com.EShop.Utills.HttpUtil;
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
@WebServlet(name = "UserApi", urlPatterns = {"/api/user"})
public class UserApi extends HttpServlet {

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

        PrintWriter printWriter = resp.getWriter();
        try {
            List<User> users = new ArrayList<User>();
            users = service.GetListUser(filter);
            printWriter.print(gson.toJson(users));
        } catch (SQLException ex) {
            log(ex.toString());
        }

    }
}
