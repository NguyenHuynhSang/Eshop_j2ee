/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.Tag;
import com.EShop.Service.TagService;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
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
@WebServlet(name = "TagAPI", urlPatterns = {"/TagAPI"})
public class TagAPI extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("application/json");
        TagService tagservice = new TagService();       
        List<Tag> tag= new ArrayList<Tag>();
        Gson gson=new Gson();
        
        try {
            tag = tagservice.GetTag();
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       PrintWriter printWriter=response.getWriter();
       
       printWriter.print(gson.toJson(tag));
    }
    
        @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json
       
       Gson gson=new Gson();
       TagService jsonservice = new TagService();  
       
       String js = HttpUtil.of(request.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
       Tag tag=gson.fromJson(js, Tag.class);
        try {
            jsonservice.InsertTag(tag);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); 
       
       Gson gson=new Gson();
       TagService tagservice = new TagService();  
       
       String js = HttpUtil.of(request.getReader());
       Tag tag=gson.fromJson(js, Tag.class);
        try {
            tagservice.UpdateTag(tag);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Gson gson=new Gson();
        TagService tagservice=new TagService();
        
        String js=HttpUtil.of(request.getReader());
        Tag[] tags= gson.fromJson(js,Tag[].class);
        try {
            tagservice.DeleteTag(tags);
        } catch (SQLException ex) {
           Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
