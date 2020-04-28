/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Model.JSon;
import Service.JSonService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "JSonAPI", urlPatterns = {"/api/json"})
public class JSonAPI extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getContentType();
        JSonService jsonservice = new JSonService();
        String querryStr = "";
        String queryString = request.getQueryString();
        if (queryString != null) {
            String[] parameters = queryString.split("&");
            Map<String, String[]> queryParameters = new HashMap<>();
            int counter = 0;

            for (String parameter : parameters) {
                String regex = Integer.toString(counter) + "=";
                parameter = parameter.replaceAll(regex, "");
                querryStr = querryStr + parameter;
                counter++;
            }
        }


        List<JSon> json = new ArrayList<JSon>();
        Gson gson = new Gson();

        try {
            if (querryStr == "") {
                json = jsonservice.GetAllJSon();
            } else {
                json= jsonservice.GetAllJSonByKey(querryStr);

            }
        } catch (SQLException ex) {

        }

        PrintWriter printWriter = response.getWriter();

        printWriter.print(gson.toJson(json));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }
}
