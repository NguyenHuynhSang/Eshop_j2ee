package com.EShop.Api.ClientApi;


import com.EShop.Model.UserModel.Order;
import com.EShop.Model.UserModel.OrderDetail;
import com.EShop.Model.ViewModel.ProductDetailViewModel;
import com.EShop.Service.ProductService;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "AddToCartApi", urlPatterns = {"/api/AddToCart"})
public class AddToCartApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); //lay du lieu tieng viet
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        int quantity = 1;
        int productVerID = Integer.parseInt(req.getParameter("productVerID"));
        ProductService productService = new ProductService();
        try {
            ProductDetailViewModel product = productService.GetProductVertionDetailByID(productVerID);
            if (product != null) {
                if (req.getParameter("quantity") != null)
                    quantity = Integer.parseInt(req.getParameter("quantity"));
                HttpSession session = req.getSession();
                if (session.getAttribute("order") == null) {
                    Order order = new Order();
                    List<OrderDetail> listItems = new ArrayList<>();
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setQuantity(quantity);
                    orderDetail.setProductVerion(product);
                    if (product.ProductVersion.getPromotionPrice().intValue() == 0)
                        orderDetail.setPrice(product.ProductVersion.getPrice());
                    else {
                        orderDetail.setPrice(product.ProductVersion.getPromotionPrice());
                    }
                    listItems.add(orderDetail);
                    order.setOrderDetails(listItems);
                    session.setAttribute("order", order);
                } else {
                    Order order = (Order) session.getAttribute("order");
                    List<OrderDetail> listItems = order.getOrderDetails();
                    boolean check = false;
                    for (OrderDetail item : listItems) {
                        // có rồi thì cộng thêm số lượng
                        if (item.getProductVerion().ProductVersion.getID() == product.ProductVersion.getID()) {
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }

                    }
                    //sp chưa có trong giỏ hàng
                    if (check == false) {
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setQuantity(quantity);
                        orderDetail.setProductVerion(product);
                        if (product.ProductVersion.getPromotionPrice().intValue() == 0)
                            orderDetail.setPrice(product.ProductVersion.getPrice());
                        else {
                            orderDetail.setPrice(product.ProductVersion.getPromotionPrice());
                        }
                        listItems.add(orderDetail);
                    }
                    session.setAttribute("order", order);


                }

            }
            PrintWriter printWriter = resp.getWriter();
            HttpSession session = req.getSession();
            Gson gson = new Gson();
            Order order = (Order) session.getAttribute("order");

            printWriter.print(gson.toJson(order));
        } catch (SQLException ex) {


        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
