package Conx;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;
    public Connection getConnection() {
        String dbName = "Zineb";
        String userName = "zineb";
        String password = "zineb";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:8889/" +dbName,userName,password);
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
        return connection;
    }
}