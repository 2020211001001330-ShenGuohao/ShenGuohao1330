package com.ShenGuohao.controller;

import com.ShenGuohao.dao.ProductDao;
import com.ShenGuohao.model.Category;
import com.ShenGuohao.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("hello");
        try {
            List<Category> categories=Category.findAllCategory(con);
            request.setAttribute("categoryList",categories);
            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String productName=request.getParameter("productName");
            double price=request.getParameter("prcie")!=null ?Double.parseDouble("price"):0.0;
        int categoryId=request.getParameter("categoryId")!=null ?Integer.parseInt("price"):0;
         String productDescription=request.getParameter("productDescription");

        InputStream inputStream=null;
        Part filePart=request.getPart("picture");
        if(filePart!=null){
            inputStream=filePart.getInputStream();
        }

        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        product.setPricture(inputStream);

        ProductDao productDao=new ProductDao();
        try {
            int n=productDao.save(product,con);

            if(n>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
