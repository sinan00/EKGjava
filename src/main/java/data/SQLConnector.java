package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    private static Connection connection;
    public static Connection getConnection() {
        try {
            if (connection == null||connection.isClosed()) {
                    connection= DriverManager.getConnection("jdbc:mysql://db.diplomportal.dk/s195512?user" +
                            "=s195512&password=8O5gMjPRIt2Fx0nTCuvgW");

                    System.out.println("Hej fra dB");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
