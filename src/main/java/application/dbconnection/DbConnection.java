package application.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private static final String url = "jdbc:mysql://localhost:3306/MySQL";
    private static final String userDB = "root";
    private static final String passwordDB = "root";

    private static Connection connection;

    public Connection getConnect(){
        try {
            connection = DriverManager.getConnection(url, userDB, passwordDB);
            return connection;
        }  catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
