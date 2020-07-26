package com.EShop.Api;

import com.EShop.Model.ProductCatalog;
import com.EShop.Model.User;
import com.EShop.Service.CatalogService;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginApi", urlPatterns = {"/api/logic"})
public class LoginApi  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        UserService service = new UserService();

        String js = HttpUtil.of(req.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
        User user = gson.fromJson(js, User.class);
        try {
            if (service.Login(user))
            {



            }

        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
