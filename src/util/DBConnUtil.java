package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

    public static Connection getConnection(String connectionString, String username, String password) throws SQLException {
        Connection connection = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, username, password);

        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found: " + ex.getMessage());
        }

        return connection;
    }
}


