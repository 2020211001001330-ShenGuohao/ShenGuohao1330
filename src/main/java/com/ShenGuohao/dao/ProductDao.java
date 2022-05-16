package com.ShenGuohao.dao;

import com.ShenGuohao.model.Product;
import com.ShenGuohao.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPricture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPricture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {

        String sql="delete  product where productid=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        pt.executeUpdate();


        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql="update Prouct SET   categoryId=? productName=? productDescription=? pricture=? price=? WHERE productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,instance.getCategoryId());
        pt.setString(2,instance.getProductName());
        pt.setString(3,instance.getProductDescription());
        pt.setObject(4,instance.getPricture());
        pt.setObject(5,instance.getPrice());
        pt.setInt(6,instance.getProductId());
        pt.executeUpdate();

        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql="select * from Product where productId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,productId);
        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
        }

        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product>products=new ArrayList<>();
        String sql="select * from product where categoryId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,categoryId);
        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
            products.add(product);

        }



        return products;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product>products=new ArrayList<>();
        String sql="select * from product where price>? and price <?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDouble(1,minPrice);
        st.setDouble(2,maxPrice);
        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
            products.add(product);

        }



        return products;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product>products=new ArrayList<>();
        String sql="select * from product";
        PreparedStatement st=con.prepareStatement(sql);

        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
            products.add(product);

        }

        return products;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product>products=new ArrayList<>();
        String sql="select * from product where productName=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,productName);

        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
            products.add(product);

        }

        return products;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product>products=new ArrayList<>();
        String sql="select * from product";
        PreparedStatement st=con.prepareStatement(sql);

        ResultSet res=st.executeQuery();
        Product product=null;
        while (res.next()){
            product = new Product();
            product.setProductId(res.getInt("productId"));
            product.setProductName(res.getString("productName"));
            product.setProductDescription(res.getString("productDescription"));
            product.setPrice(res.getDouble("price"));
            product.setPricture((InputStream) res.getObject("priture"));
            product.setCategoryId(res.getInt("categoryId"));
            products.add(product);

        }

        return products;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws SQLException {

        byte [] imgByte =null;

        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet res=pt.executeQuery();
        while (res.next()){
            Blob blob=res.getBlob("picture");
            imgByte=blob.getBytes(1,(int) blob.length());
        }
        return imgByte;
    }
}
