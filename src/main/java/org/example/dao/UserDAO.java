package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import  org.example.model.User;
import org.example.DatabaseConfig;

public class UserDAO {

    // CREATE
   public boolean createUser(User user)  {
       String sql="INSERT INTO users (username,email,password) VALUES (?,?,?)";

       try(Connection conn=DatabaseConfig.getConnection();
       PreparedStatement stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
           stmt.setString(1,user.getUsername());
           stmt.setString(2,user.getEmail());
           stmt.setString(3,user.getPassword());

           int rows=stmt.executeUpdate();
           if(rows>0){
               ResultSet rs=stmt.getGeneratedKeys();
               if(rs.next()){
                   user.setId(rs.getInt(1));
                   return true;
               }
           }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
     return false;
   }

   public User getUserById(int id)  {
       String sql="SELECT * FROM users WHERE id=?";

       try (Connection conn= DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){

            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();

            if (rs.next()){
                return new  User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")

                );
            }
       }
       catch (SQLException e){}
       return null;
   }

   public User getUserByEmail(String username)  {
       String sql="SELECT * FROM users WHERE username=?";
       User user=null;

       try(Connection conn = DatabaseConfig.getConnection();
           PreparedStatement stmt= conn.prepareStatement(sql)){

           stmt.setString(1,username);
           ResultSet rs=stmt.executeQuery();

           if (rs.next()){
               user=new User();
               user.setId(rs.getInt("id"));
               user.setUsername(rs.getString("username"));
               user.setEmail(rs.getString("email"));
               user.setPassword(rs.getString("password"));
           }

       }
       catch (SQLException e){
           e.printStackTrace();
       }
       return user;
   }

   public List<User> getAllUsers()  {
       List<User> users=new ArrayList<>();
       String sql="SELECT * FROM users";

       try(Connection conn= DatabaseConfig.getConnection();
           PreparedStatement stmt= conn.prepareStatement(sql);
           ResultSet rs =stmt.executeQuery()){

           while(rs.next()){
               users.add(new User(
                       rs.getInt("id"),
                       rs.getString("username"),
                       rs.getString("email"),
                       rs.getString("password")
               ));
           }
       }
       catch (SQLException e){
       e.printStackTrace();}

       return users;
   }

   public void  updateUser(User user)  {
       String sql = "UPDATE users SET email=?,password=? WHERE username=?";

       try (Connection conn= DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
           stmt.setString(1,user.getEmail());
           stmt.setString(2,user.getPassword());
           stmt.setString(3,user.getUsername());
           stmt.setInt(4,user.getId());

           stmt.executeUpdate();

       }catch (SQLException e){
           e.printStackTrace();
       }

   }

   public boolean deleteUser(int id)  {
       String sql="DELETE FROM users WHERE id=?";

       try (Connection conn=DatabaseConfig.getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            return stmt.executeUpdate()>0;
       }
       catch (SQLException e){
           e.printStackTrace();
       }
       return false;
   }

}

