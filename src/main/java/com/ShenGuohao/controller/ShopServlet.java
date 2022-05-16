package com.ShenGuohao.controller;

import com.ShenGuohao.dao.ProductDao;
import com.ShenGuohao.model.Category;
import com.ShenGuohao.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ProductDao productDao=new ProductDao();
        List<Product>productList=null;
        if(request.getParameter("category")==null){
            try {
                productDao.findAll(con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            int categoryId=Integer.parseInt(request.getParameter("category"));
            try {
                productList=productDao.findByCategoryId(categoryId,con);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        request.setAttribute("productList",productList);
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
