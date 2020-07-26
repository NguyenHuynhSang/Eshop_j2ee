package com.EShop.Api;

import com.EShop.Model.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserCurrentApi", urlPatterns = {"/api/userCurrent"})
public class UserCurrentApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        if (session.getAttribute("userLogin") != null)
        {
            User currentUser=(User)session.getAttribute("userLogin");
            printWriter.print(gson.toJson(currentUser));
        }
    }
}
