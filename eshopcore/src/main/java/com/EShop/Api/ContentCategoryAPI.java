/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.ContentCategory;
import com.EShop.Service.ContentCategoryService;
import com.EShop.Utills.HttpUtil;
import com.EShop.ViewModel.ContentCategoryViewModel;
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
@WebServlet(name = "ContentCategoryAPI", urlPatterns = {"/API-ContentCategory"})
public class ContentCategoryAPI extends HttpServlet {

    long[] ints;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ContentCategoryService jsonservice = new ContentCategoryService();

        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        String ID= request.getParameter("ID");
        List<ContentCategoryViewModel> json = new ArrayList<ContentCategoryViewModel>();
        Gson gson = new Gson();
        PrintWriter printWriter = response.getWriter();
        ContentCategoryViewModel js=null;
        if(action==null)
        {
            try {
                json=jsonservice.GetContentCategory();
                printWriter.print(gson.toJson(json));
            } catch (SQLException ex) {
                Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                switch (action){
                    case "getAll":
                         if (keyword!= "")
                        { 
                            json = jsonservice.GetAllContentCategoryByKey(keyword);
                        } else {
                            json = jsonservice.GetContentCategory();
                        }
                        printWriter.print(gson.toJson(json));
                        break;
                    case "getByID":
                        if (ID!="" && ID!=null) json=jsonservice.GetContentCategoryByID(Integer.parseInt(ID));
                        printWriter.print(gson.toJson(json));
                        break;

                }

            } catch (SQLException ex) {

            }
        }
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
       ContentCategoryViewModel category=gson.fromJson(js, ContentCategoryViewModel.class);
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

        ContentCategoryService jsonservice = new ContentCategoryService();  
        
        String ID= request.getParameter("ID");
        try {
            jsonservice.DeleteContentCategory(Integer.parseInt(ID));
        } catch (SQLException ex) {
           Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
