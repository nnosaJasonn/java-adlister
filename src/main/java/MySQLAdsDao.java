import java.util.List;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

  private List<Ad> ads;
  private Connection connection;

  public MySQLAdsDao(){
      try {
          DriverManager.registerDriver(new Driver());
          Config config = new Config();
          connection = DriverManager.getConnection (
                  config.getUrl(),
                  config.getUsername(),
                  config.getPassword()
          );

      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

    @Override
    public List<Ad> all() {
      ads = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            String query = "select user_id, title, description from ads";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                ads.add(
                        new Ad(rs.getLong("user_id"), rs.getString("title"), rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public List<Ad> allFromUser(Long userID) {
        ads = new ArrayList<>();
        try  {
            Statement statement = connection.createStatement();
            String query = "select user_id, title, description from ads where user_id = " + userID;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                ads.add(
                        new Ad(rs.getLong("user_id"), rs.getString("title"), rs.getString("description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
            String query = "insert into ads (user_id, title, description) VALUES (" + ad.getUserId() + ", '" +ad.getTitle()+ "', '" + ad.getDescription()+ "')";
            Statement stmt = null;
        try{

            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                return rs.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
