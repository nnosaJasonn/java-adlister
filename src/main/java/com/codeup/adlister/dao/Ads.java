package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    void delete(long title);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    void deleteFromUser(long user_id);

    List<Ad> allFromUser(Long userID);
}
