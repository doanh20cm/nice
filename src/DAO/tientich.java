package DAO;

import java.sql.*;

public class tientich{
    public static Connection getConnection(String username, String password) {
        try {
            String dburl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=QuanlySinhvien;user=" + username + ";password=" + password;
            return DriverManager.getConnection(dburl);
        } catch (SQLException ignored) {}
        return null;
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ignored) {}
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ignored) {}
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ignored) {}
    }

    public static void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ignored) {}
    }
}