package com.EShop.Api.ClientApi;

import com.EShop.Contain.contain;
import com.EShop.Model.Attribute;
import com.EShop.Model.Menu;
import com.EShop.Model.UserModel.Order;
import com.EShop.Service.AttributeService;
import com.EShop.Service.MenuService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MenuApi", urlPatterns = {"/api/GetListMenus"})
public class GetListMenuApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        MenuService menuService = new MenuService();
        List<Menu> menus= new ArrayList<>();
        Gson gson=new Gson();
        try {
            menus = menuService.GetListMenusByGroupId(contain.CLIENTGROUP);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        PrintWriter printWriter=resp.getWriter();

        printWriter.print(gson.toJson(menus));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}