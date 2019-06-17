package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();
    private static Users usersDao;
    private static MySQLLoginDao loginsDao;


    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static MySQLLoginDao getLoginsDao(){
        if (loginsDao == null){
            Config config = new Config();
            loginsDao = new MySQLLoginDao(config);
        }
        return loginsDao;
    }





}
