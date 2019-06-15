import java.util.List;
import com.mysql.cj.jdbc.Driver;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class MySQLUsersDao implements Users {

    private List<User> users;
    private Connection connection;

    public MySQLUsersDao(){
        try {
            DriverManager.registerDriver(new Driver());
        Config config = new Config();
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> all(){
        users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "select id, username, email, password from users";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                users.add(
                        new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Long insert(User user) {
        String query = "insert into users (id, username, email, password) VALUES (" +user.getId()+ ", '" +user.getUsername()+ "', '" + user.getEmail()+ "', '" + user.getPassword()+ "')";
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Long.valueOf(0);
    }

}
