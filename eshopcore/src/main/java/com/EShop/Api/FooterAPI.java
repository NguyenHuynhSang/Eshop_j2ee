/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.Api;

import com.EShop.Model.Footer;
import com.EShop.Service.FooterService;
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
@WebServlet(name = "FooterAPI", urlPatterns = {"/API-Footer"})
public class FooterAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        FooterService jsonservice = new FooterService();

        String keyword = request.getParameter("keyword");
        String action = request.getParameter("action");
        String ID= request.getParameter("ID");
        List<Footer> json = new ArrayList<Footer>();
        Gson gson = new Gson();
        PrintWriter printWriter = response.getWriter();
        Footer js=null;
        if(action==null)
        {
            try {
                json=jsonservice.GetFooter();
                printWriter.print(gson.toJson(json));
            } catch (SQLException ex) {
                Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            switch (action){
                case "getAll":
                    if (keyword!= "") {
                        json = jsonservice.GetAllFooterByKey(keyword);
                    } else {
                        json = jsonservice.GetFooter();
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
       FooterService jsonservice = new FooterService();  
       
       String js = HttpUtil.of(request.getReader()); //request.getReader() dùng để lấy dữ liệu từ server
       Footer tag=gson.fromJson(js, Footer.class);
        try {
            jsonservice.InsertFooter(tag);
        } catch (SQLException ex) {
            Logger.getLogger(FooterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException 
    {
       request.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
       response.setContentType("application/json"); 
       
       Gson gson=new Gson();
       FooterService tagservice = new FooterService();  
       
       String js = HttpUtil.of(request.getReader());
       Footer tag=gson.fromJson(js, Footer.class);
        try {
            tagservice.UpdateFooter(tag);
        } catch (SQLException ex) {
            Logger.getLogger(FooterAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
        FooterService jsonservice=new FooterService();
        
        String js=HttpUtil.of(request.getReader());
        String ID= request.getParameter("ID");
        try {
            jsonservice.DeleteFooter(Integer.parseInt(ID));
        } catch (SQLException ex) {
           Logger.getLogger(ContentCategoryAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
