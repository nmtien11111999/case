package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String url = "jdbc:mysql://localhost:3306/case_study?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "123gane456789a";
    public DBConnect(){

    }

    public Connection getConnection() throws ClassNotFoundException {
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url,user,password);
            System.out.println("Connect database successfully");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}
