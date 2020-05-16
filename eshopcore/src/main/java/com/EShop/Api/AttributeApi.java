package com.EShop.Api;

import com.EShop.Model.Attribute;
import com.EShop.Model.Content;
import com.EShop.Service.AttributeService;
import com.EShop.Service.ContentService;
import com.EShop.Utills.HttpUtil;
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

@WebServlet(name = "AttributeApi", urlPatterns = {"/api/Attribute"})
public class AttributeApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        AttributeService attributeService = new AttributeService();
        List<Attribute> attributes= new ArrayList<>();
        Gson gson=new Gson();
        try {
            attributes = attributeService.GetAttribute();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        PrintWriter printWriter=response.getWriter();

        printWriter.print(gson.toJson(attributes));
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json
    }

}
