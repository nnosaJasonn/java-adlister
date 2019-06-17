package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    void deleteUser(long userID);
}
