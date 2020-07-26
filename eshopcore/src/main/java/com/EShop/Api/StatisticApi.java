package com.EShop.Api;

import com.EShop.Model.JSon;
import com.EShop.Model.Statistic;
import com.EShop.Model.User;
import com.EShop.Service.StatisticService;
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
@WebServlet(name = "StatisticApi", urlPatterns = {"/api/statistic"})
public class StatisticApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        StatisticService service = new StatisticService();

        String fromDate="";
        String toDate="";
        String ID = req.getParameter("ID");
        Gson gson = new Gson();
        PrintWriter printWriter = resp.getWriter();
        JSon js = null;
        try {
            List<Statistic> statistics = new ArrayList<Statistic>();
            statistics = service.GetStatistics(fromDate,toDate);
            printWriter.print(gson.toJson(statistics));
        } catch (SQLException ex) {
            log(ex.toString());
        }
    }
}
