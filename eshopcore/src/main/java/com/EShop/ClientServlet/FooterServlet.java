/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EShop.ClientServlet;
import com.EShop.Model.Footer;
import com.EShop.Service.FooterService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "FooterServlet", urlPatterns = {"/FooterServlet"})
public class FooterServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       FooterService jsonservice = new FooterService();
        
       Footer json = new Footer();
       Gson gson = new Gson();
       PrintWriter printWriter = response.getWriter();
       try {
           json = jsonservice.GetFooterActive();
       } catch (SQLException ex) {
           Logger.getLogger(FooterServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        printWriter.print(json.getContent());
    }

}
