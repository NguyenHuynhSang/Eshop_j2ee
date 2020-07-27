package com.EShop.Api;

import com.EShop.Filter.ProductFilter;
import com.EShop.Filter.StatisticFilter;
import com.EShop.Model.JSon;
import com.EShop.Model.Statistic;
import com.EShop.Model.User;
import com.EShop.Service.StatisticService;
import com.EShop.Service.UserService;
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
@WebServlet(name = "StatisticApi", urlPatterns = {"/api/statistic"})
public class StatisticApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        StatisticService service = new StatisticService();



        Gson gson =new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();

        String js = req.getParameter("filterJson");

        StatisticFilter filter = gson.fromJson(js, StatisticFilter.class);


        PrintWriter printWriter = resp.getWriter();
        try {
            List<Statistic> statistics = new ArrayList<Statistic>();
            statistics = service.GetStatistics(filter);
            printWriter.print(gson.toJson(statistics));
        } catch (SQLException ex) {
            log(ex.toString());
        }
    }
}
