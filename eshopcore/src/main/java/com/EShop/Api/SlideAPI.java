/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.Slide;
import com.EShop.Service.SlideService;
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
@WebServlet(name = "SlideAPI", urlPatterns = {"/API-Slide"})
public class SlideAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        SlideService jsonservice = new SlideService();

        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        String ID= request.getParameter("ID");
        List<Slide> json = new ArrayList<Slide>();
        Gson gson = new Gson();
        PrintWriter printWriter = response.getWriter();
        Slide js=null;
        if(action==null)
        {
            try {
                json=jsonservice.GetSlide();
                printWriter.print(gson.toJson(json));
            } catch (SQLException ex) {
                Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            switch (action){
                case "getAll":
                    if (keyword!= "") {
                        json = jsonservice.GetAllSlideByKey(keyword);
                    } else {
                        json = jsonservice.GetSlide();
                    }
                    printWriter.print(gson.toJson(json));
                    break;
                case "getByID":
                    if (ID!="" && ID!=null) json=jsonservice.GetJSONByID(ID);
                    printWriter.print(gson.toJson(json));
                    break;

            }

        } catch (SQLException ex) {

        }
    }
    
        @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); //set kiểu dữ liệu trả về từ server là chuỗi json
       
       Gson gson=new Gson();
       SlideService jsonservice = new SlideService();  
       
       String js = HttpUtil.of(request.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
       Slide tag=gson.fromJson(js, Slide.class);
        try {
            jsonservice.InsertSlide(tag);
        } catch (SQLException ex) {
            Logger.getLogger(SlideAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); 
       
       Gson gson=new Gson();
       SlideService tagservice = new SlideService();  
       
       String js = HttpUtil.of(request.getReader());
       Slide tag=gson.fromJson(js, Slide.class);
        try {
            tagservice.UpdateSlide(tag);
        } catch (SQLException ex) {
            Logger.getLogger(SlideAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        SlideService jsonservice=new SlideService();
        
        String js=HttpUtil.of(request.getReader());
        String ID= request.getParameter("ID");
        try {
            jsonservice.DeleteSlide(Integer.parseInt(ID));
        } catch (SQLException ex) {
           Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
