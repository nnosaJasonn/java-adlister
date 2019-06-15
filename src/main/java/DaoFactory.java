public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static MySQLLoginDao loginsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }

    public static MySQLLoginDao getLoginsDao(){
        if (loginsDao == null){
            Config config = new Config();
            loginsDao = new MySQLLoginDao(config);
        }
        return loginsDao;
    }

    public static Users getUsersDao() {

        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }
        return usersDao;
    }
}
