package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test4 {
    public static void main(String[] args) {
    if (checkConnection(cnn)==true){
        System.out.println("Connection is OK");
    }
    else {
        System.out.println("Connection is not OK");
    }
    }
    static Connection cnn;

    {
        try {
            cnn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=QuanlySinhvien;user=sa;password=linhlinhtk12");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean checkConnection (Connection cnn) {
       if (cnn!=null) {
           return true;
        }
       else {
           return false;
       }
    }

}

