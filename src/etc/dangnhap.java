package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class dangnhap {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-DPLN7UU\\SQLEXPRESS:1433;database=QuanlySinhvien;user=sa;password=12345");
        if (conn != null) {
            System.out.println("Kết nối thành công");
        } else {
            System.out.println("Kết nối thất bại");
        }

        Scanner sc = new Scanner(System.in);

        // thêm
        System.out.println("nhập id đi bruh: ");
        int id = sc.nextInt();
        System.out.println("nhập tên đi bủh: ");
        String name = sc.next();
        String sql =  "insert into test values (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2,name);
        System.out.println("Đã thêm " + stmt.executeUpdate() + " dòng");;

        // sửa
//        System.out.println("Tìm id cần sửa: ");
//        int id = sc.nextInt();
//        System.out.println("Tìm name cần sửa: ");
//        String name = sc.next();
//        System.out.println("sua thanh id: ");
//        int idafter = sc.nextInt();
//        System.out.println("sua thanh name: ");
//        String nameafter = sc.next();
//        String sql = "update test set id = ?, name = ? where id = ? and name = ?";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1,idafter);
//        stmt.setString(2,nameafter);
//        stmt.setInt(3,id);
//        stmt.setString(4,name);
//        stmt.executeUpdate();

        // xóa
//        System.out.println("Tim id can xoa: ");
//        int id = sc.nextInt();
//        String sql = "delete from test where id = ?";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1,id);
//        stmt.executeUpdate();

        // xem
//        System.out.println("Danh sach bruh");
//        String sql = "select * from test";
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            System.out.println(rs.getInt(1) + " " + rs.getString(2));
//        }

        // đăng nhập (tìm kiếm == select có điều kiện)
//        System.out.println("Nhập tên đăng nhập: ");
//        int id = sc.nextInt();
//        System.out.println("Nhập mật khẩu: ");
//        String name = sc.next();
//        String sql = "select * from test where id= ? and name = ?";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setString(1,id);
//        stmt.setString(2,name);
//        ResultSet rs = stmt.executeQuery();
//        if (rs.next()) {
//            System.out.println("Đăng nhập thành công");
//        } else {
//            System.out.println("Đăng nhập thất bại");
//        }
    }
}