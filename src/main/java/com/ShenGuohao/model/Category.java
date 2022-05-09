package com.ShenGuohao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private int categoryId;
    private  String categoryName;
    private  String description;
    private boolean actice;

    public Category(int categoryId, String categoryName, String description, boolean actice) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.actice = actice;
    }
    public Category(){}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActice() {
        return actice;
    }

    public void setActice(boolean actice) {
        this.actice = actice;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", actice=" + actice +
                '}';
    }

    public  static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from category";

        ArrayList<Category>categories=new ArrayList<Category>();
        PreparedStatement st=con.prepareStatement(sql);

        ResultSet res=st.executeQuery();
        while (res.next()){
            Category category=new Category();
            category.setCategoryId(res.getInt("categoryId"));
            category.setCategoryName(res.getString("categoryName"));
            category.setDescription(res.getString("description"));
            categories.add(category);
        }

        return categories;
    }
    public  static String findByCategoryId(Connection con,int CategoryId) throws SQLException {
        String sql="select * from category where categoryId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,CategoryId);
        ResultSet res=st.executeQuery();
        String categoryName=null;
        while (res.next()){

          categoryName= res.getString("category");

        }

        return categoryName;
    }


}
