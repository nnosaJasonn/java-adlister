package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private List <Ad> ads;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public void delete(long title) {
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM ads WHERE id = ?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, title);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteFromUser(long user_id) {
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM ads WHERE user_id = ?;";
            stmt = connection.prepareStatement(query);
            stmt.setLong(1, user_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Long insert(Ad ad) {
        try {
            String sql = "INSERT INTO ads (user_id, title, description) VALUES (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          stmt.setLong(1, ad.getUserId());
          stmt.setString(2, ad.getTitle());
          stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> allFromUser(Long userID) {
        ads = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            String query = "select id, user_id, title, description from ads where user_id = " + userID;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                ads.add(
                        new Ad(rs.getLong("id"),
                                rs.getLong("user_id"), rs.getString("title"), rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    private String createInsertQuery(Ad ad) {
//        return "INSERT INTO ads(user_id, title, description) VALUES "
//            + "(" + ad.getUserId() + ", "
//            + "'" + ad.getTitle() +"', "
//            + "'" + ad.getDescription() + "')";

        return "INSERT INTO ads (user_id, title, descrition) VALUES ?,?,?)";
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
