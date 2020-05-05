/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.ContentCategory;
import com.EShop.Service.ContentCategoryService;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nhatminh
 */
@WebServlet(name = "ContentCategoryAPI", urlPatterns = {"/ContentCategoryAPI"})
public class ContentCategoryAPI extends HttpServlet {

    long[] ints;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("application/json");
        ContentCategoryService jsonservice = new ContentCategoryService();       
        List<ContentCategory> category= new ArrayList<>();
        Gson gson=new Gson();
        
        try {
            category = jsonservice.GetContentCategory();
        } catch (SQLException ex) {
            Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       PrintWriter printWriter=response.getWriter();
       
       printWriter.print(gson.toJson(category));
    }
    
        @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json
       
       Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
       ContentCategoryService jsonservice = new ContentCategoryService();  
       
       String js = HttpUtil.of(request.getReader()); 
       ContentCategory category=gson.fromJson(js, ContentCategory.class);
        try {
            jsonservice.InsertContentCategory(category);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); 
       
       Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
       ContentCategoryService jsonservice = new ContentCategoryService();  
       
       String js = HttpUtil.of(request.getReader());
       ContentCategory category=gson.fromJson(js, ContentCategory.class);
        try {
            jsonservice.UpdateContentCategory(category);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        ContentCategoryService jsonservice=new ContentCategoryService();
        
        String js=HttpUtil.of(request.getReader());
        ContentCategory[] json= gson.fromJson(js,ContentCategory[].class);
        try {
            jsonservice.DeleteContentCategory(json);
        } catch (SQLException ex) {
           Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
