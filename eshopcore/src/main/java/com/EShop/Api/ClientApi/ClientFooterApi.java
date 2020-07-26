package com.EShop.Api.ClientApi;

import com.EShop.ClientServlet.FooterServlet;
import com.EShop.Contain.contain;
import com.EShop.Model.Footer;
import com.EShop.Model.Menu;
import com.EShop.Service.FooterService;
import com.EShop.Service.MenuService;
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
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ClientFooterApi", urlPatterns = {"/api/FooterClient"})
public class ClientFooterApi  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        FooterService jsonservice = new FooterService();

        Footer json = new Footer();
        Gson gson = new Gson();

        try {
            json = jsonservice.GetFooterActive();


        } catch (SQLException ex) {
            Logger.getLogger(FooterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter printWriter = resp.getWriter();

        printWriter.print(gson.toJson(json));



    }
}
