/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;


import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.EShop.Service.JSonService;
import com.EShop.Model.JSon;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "JSonAPI", urlPatterns = {"/api/json"})
public class JSonAPI extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getContentType();
        JSonService jsonservice = new JSonService();
        String querryStr = "";
        String queryString = request.getQueryString();
        if (queryString != null) {
            String[] parameters = queryString.split("&");
            Map<String, String[]> queryParameters = new HashMap<>();
            int counter = 0;

            for (String parameter : parameters) {
                String regex = Integer.toString(counter) + "=";
                parameter = parameter.replaceAll(regex, "");
                querryStr = querryStr + parameter;
                counter++;
            }
        }


        List<JSon> json = new ArrayList<JSon>();
        Gson gson = new Gson();

        try {
            if (querryStr == "") {
                json = jsonservice.GetAllJSon();
            } else {
                json = jsonservice.GetAllJSonByKey(querryStr);

            }
        } catch (SQLException ex) {

        }

        PrintWriter printWriter = response.getWriter();

        printWriter.print(gson.toJson(json));
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json");

        Gson gson = new Gson();
        JSonService jsonservice = new JSonService();

        String js = HttpUtil.of(request.getReader());
        JSon json = gson.fromJson(js, JSon.class);
        try {
            jsonservice.UpdateJson(json);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
