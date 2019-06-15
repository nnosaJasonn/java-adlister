import java.util.List;
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
        String query = "select id from users where username ='" +username+ "' and password = '" +password+ "';";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setID(String username, String password) {
        try {
            String query = "select id from users where username ='" +username+ "' and password = '" +password+ "';";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                this.id = rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getId(){
        return this.id;
    }


}
