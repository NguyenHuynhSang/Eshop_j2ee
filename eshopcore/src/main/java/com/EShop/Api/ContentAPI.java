/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.Content;
import com.EShop.Service.ContentService;
import com.EShop.Utills.HttpUtil;
import com.EShop.ViewModel.ContentViewModel;
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
@WebServlet(name = "api-Content", urlPatterns = {"/API-Content"})
public class ContentAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ContentService jsonservice = new ContentService();

        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        String ID= request.getParameter("ID");
        List<ContentViewModel> json = new ArrayList<ContentViewModel>();
        Gson gson = new Gson();
        PrintWriter printWriter = response.getWriter();
        ContentViewModel js=null;
        
        if(action==null)
        {
            try {
                json=jsonservice.GetContent();
                printWriter.print(gson.toJson(json));
            } catch (SQLException ex) {
                Logger.getLogger(ContentAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
            switch (action){
                case "getAll":
                    if (keyword!="") {
                        json = jsonservice.GetAllContentByKey(keyword);
                    } else {
                        json = jsonservice.GetContent();
                    }
                    printWriter.print(gson.toJson(json));
                    break;
                case "getByID":
                    if (ID!="" && ID!=null) json=jsonservice.GetContentByID(Integer.parseInt(ID));
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
       ContentService jsonservice = new ContentService();  
       
       String js = HttpUtil.of(request.getReader()); 
       Content content=gson.fromJson(js, Content.class);
        try {
            jsonservice.InsertContent(content);
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
       ContentService jsonservice = new ContentService();  
       
       String js = HttpUtil.of(request.getReader());
       Content content=gson.fromJson(js, Content.class);
        try {
            jsonservice.UpdateContent(content);
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
        ContentService jsonservice=new ContentService();
        
        String js=HttpUtil.of(request.getReader());
        Content[] json= gson.fromJson(js,Content[].class);
        try {
            jsonservice.DeleteContent(json);
        } catch (SQLException ex) {
           Logger.getLogger(ContentAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
