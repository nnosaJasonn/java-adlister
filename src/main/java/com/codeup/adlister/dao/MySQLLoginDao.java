package com.codeup.adlister.dao;

import java.util.List;

import com.codeup.adlister.dao.Config;
import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class MySQLLoginDao {
    private Connection connection;
    private Long id;
    public MySQLLoginDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verify(String username, String password) {
        try {
            String query = "select id from users where username = ? and password = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                this.id = rs.getLong("id");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public void setID(String username, String password) {
//        try {
//            String query = "select id from users where username = ? and password = ?;";
//
//
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setString(1, username);
//            stmt.setString(2, password);
//            ResultSet rs = stmt.executeQuery();
//            if(rs.next()){
//                this.id = rs.getLong("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public long getId(){
        return this.id;
    }


}