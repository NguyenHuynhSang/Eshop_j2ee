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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.EShop.Service.JSonService;
import com.EShop.Model.JSon;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

@WebServlet(name = "JSonAPI", urlPatterns = {"/api/json/*"})
public class JSonAPI extends HttpServlet {

    long[] ints;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        JSonService jsonservice = new JSonService();

        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        String ID= request.getParameter("ID");
        List<JSon> json = new ArrayList<JSon>();
        Gson gson = new Gson();
        PrintWriter printWriter = response.getWriter();
        JSon js=null;

        try {
            switch (action){
                case "getAll":
                    if (keyword!= "") {
                        json = jsonservice.GetAllJSonByKey(keyword);
                    } else {
                        json = jsonservice.GetAllJSon();
                    }
                    printWriter.print(gson.toJson(json));
                    break;
                case "getByID":
                    if (ID!="" && ID!=null) js=jsonservice.GetJSONByID(Integer.parseInt(ID));
                    printWriter.print(gson.toJson(js));
                    break;

            }

        } catch (SQLException ex) {

        }



    }





    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json


        Gson gson = new Gson();
        JSonService jsonservice = new JSonService();

        String js = HttpUtil.of(request.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
        JSon json = gson.fromJson(js, JSon.class);
        try {
            jsonservice.InsertJson(json);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
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

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String ID= request.getParameter("ID");
        JSonService jsonservice = new JSonService();
        try {
            jsonservice.DeleteJSon(Integer.parseInt(ID));
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


