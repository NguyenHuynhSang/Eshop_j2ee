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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.EShop.Contain.ApplicationConst.CLIENT_ROLE;

@WebServlet(name = "LoginApi", urlPatterns = {"/api/login"})
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
        PrintWriter printWriter = resp.getWriter();
        String ResultCode="ERROR";
        try {
            User userReturn=service.Login(user);
          if (userReturn!=null){

              if (userReturn.getUserGroupID()==CLIENT_ROLE)
              {
                  ResultCode="CLIENT";
                  printWriter.print(gson.toJson(ResultCode));
              }
              else if (userReturn.isLock()){

                  ResultCode="LOCKED";
                  printWriter.print(gson.toJson(ResultCode));
              }
              else
              {
                  HttpSession session = req.getSession();
                  if (session.getAttribute("userLogin") == null)
                  {
                      session.setAttribute("userLogin", userReturn);
                      ResultCode="COMPLETE";
                      printWriter.print(gson.toJson(ResultCode));
                  }else
                  {
                      ResultCode="EXIST";
                      printWriter.print(gson.toJson(ResultCode));
                  }
              }
          }else
          {

              printWriter.print(gson.toJson(ResultCode));
          }

        } catch (SQLException ex) {
            ResultCode="SQLERROR";
            printWriter.print(gson.toJson(ResultCode));
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
