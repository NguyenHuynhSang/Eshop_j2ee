package com.EShop.Api.ClientApi;

import com.EShop.Model.UserModel.Order;
import com.EShop.Model.UserModel.OrderDetail;
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

    @WebServlet(name = "RemoveProductInCartApi", urlPatterns = {"/api/RemoveProductInCart"})
public class RemoveProductInCartApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");


        int productVerID = Integer.parseInt(req.getParameter("productVerID"));
        HttpSession session = req.getSession();

        Order order = (Order) session.getAttribute("order");
        if (order!=null)
        {
            for (OrderDetail item:
                 order.getOrderDetails())  {
                if (item.getProductVerion().ProductVersion.getID()==productVerID)
                {
                    order.getOrderDetails().remove(item);
                    break;
                }


            }
            session.setAttribute("order", order);
        }

        if (order.getOrderDetails().size()==0)
        {
            session.removeAttribute("order");
        }
        Order orderReturn = (Order) session.getAttribute("order");
        Gson gson = new GsonBuilder().create();
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(orderReturn));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}