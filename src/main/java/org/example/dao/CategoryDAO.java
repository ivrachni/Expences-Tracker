package org.example.dao;

import jdk.javadoc.internal.doclets.toolkit.util.IndexItem;
import  org.example.model.category;
import  org.example.DatabaseConfig;

import  java.sql.*;
import  java.util.List;
import  java.util.ArrayList;


public class CategoryDAO {
    public category create (category category){
        String sql="INSERT INTO categories (category_name, user_id) VALUES (?,?)";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1,category.getCategory_name());
            stmt.setInt(2,category.getUserId());

            try( ResultSet rs=stmt.executeQuery()){
                if(rs.next()){
                    category.setCategory_id(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

   public List<category> getAllCategoriesByUser(int userId){
        List<category> categories = new ArrayList();
        String sql="SELECT * FROM categories WHERE user_id=?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs=stmt.executeQuery();

            while (rs.next()) {
                category category =new category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                category.setUserId(rs.getInt("user_id"));
                categories.add(category);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
       }

       public void updateCategory(category category){
        String sql= "UPDATE categories SET category_name=?, user_id=? WHERE category_id=?";

        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){

            stmt.setString(1,category.getCategory_name());
            stmt.setInt(2,category.getUserId());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       }

       public void deleteCategory(int category_id){
        String sql= "DELETE FROM categories WHERE category_id=?";

        try (Connection conn= DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,category_id);
            stmt.setInt(2,category_id);
            stmt.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       }
   }





