/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.EShop.Service.JSonService;
import com.EShop.Model.JSon;
import com.EShop.Utills.HttpUtil;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/API-JSon"})
public class JSonAPI extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               response.setContentType("application/json");
        JSonService jsonservice = new JSonService();       
        List<JSon> json= new ArrayList<JSon>();
        Gson gson=new Gson();
        
        try {
            json = jsonservice.GetAllJSon();
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       PrintWriter printWriter=response.getWriter();
       
       printWriter.print(gson.toJson(json));
    }
    
        @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); 
       
       Gson gson=new Gson();
       JSonService jsonservice = new JSonService();  
       
       String js = HttpUtil.of(request.getReader());
       JSon json=gson.fromJson(js, JSon.class);
        try {
            jsonservice.UpdateJson(json);
        } catch (SQLException ex) {
            Logger.getLogger(JSonAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

}
