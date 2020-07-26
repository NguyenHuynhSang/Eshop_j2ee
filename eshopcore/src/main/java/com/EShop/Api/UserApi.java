package com.EShop.Api;

import com.EShop.Model.JSon;
import com.EShop.Model.ProductVersion;
import com.EShop.Model.User;
import com.EShop.Service.ProductService;
import com.EShop.Service.UserService;
import com.google.gson.Gson;

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

        String ID = req.getParameter("ID");
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        JSon js = null;
        try {
            List<User> users = new ArrayList<User>();
            users = service.GetListUser();
            printWriter.print(gson.toJson(users));
        } catch (SQLException ex) {
            log(ex.toString());
        }

    }
}
