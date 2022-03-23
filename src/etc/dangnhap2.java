package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class dangnhap2 {
    public static void main(String[] args) {
      if(getConnection() != null) {
          System.out.println("Connected");
      } else {
          System.out.println("Not Connected");
      }
    }

    public static Connection getConnection() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Username: ");
            String username = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();
            String dburl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=QuanlySinhvien;user=" + username + ";password=" + password;
            return DriverManager.getConnection(dburl);
        } catch (SQLException ignored) {}
        return null;
    }
}











