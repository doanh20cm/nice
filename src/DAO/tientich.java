package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class tientich{
    public static Connection getConnection(String username, String password) {
        try {
            String dburl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=QuanlySinhvien;user=" + username + ";password=" + password;
            return DriverManager.getConnection(dburl);
        } catch (SQLException ignored) {}
        return null;
    }
}