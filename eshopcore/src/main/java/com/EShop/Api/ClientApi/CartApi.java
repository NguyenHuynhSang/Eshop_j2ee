package com.EShop.Api.ClientApi;

import com.EShop.Model.UserModel.Order;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CartApi", urlPatterns = {"/api/CartApi"})
public class CartApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession();

        Order order = (Order) session.getAttribute("order");

        printWriter.print(gson.toJson(order));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
