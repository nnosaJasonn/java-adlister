package mysql;


import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class tryItOut {
    public static void main(String[] args) {


        try {
            DriverManager.registerDriver(new Driver());
            Config config = new Config();
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()

            );

            Statement statement = connection.createStatement();




            String insert = "insert into albums(artist, name, release_date, sales, genre) values ('fer', 'fers good album', 1989, 50.2, 'speed metal')";
            String query = "select artist, id, name,  sales from albums order by sales desc";

            Statement stmnt = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);
            stmnt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs1 = stmnt.getGeneratedKeys();
            if(rs.next()) {
                System.out.println("record inserted!");
            }


            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println( rs.getString("artist"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getDouble("sales"));
                System.out.println("================");

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
