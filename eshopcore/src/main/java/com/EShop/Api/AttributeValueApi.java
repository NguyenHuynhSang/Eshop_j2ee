package com.EShop.Api;


import com.EShop.Model.AttributeValue;
import com.EShop.Service.AttributeService;
import com.EShop.Service.AttributeValueService;
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

@WebServlet(name = "AttributeValueApi", urlPatterns = {"/api/AttributeValue"})
public class AttributeValueApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        AttributeValueService attributeValueService = new AttributeValueService();
        List<AttributeValue> attributeValues= new ArrayList<>();
        Gson gson=new Gson();
        try {
            attributeValues = attributeValueService.GetAttributeValue();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        PrintWriter printWriter=response.getWriter();

        printWriter.print(gson.toJson(attributeValues));
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json
    }


}
