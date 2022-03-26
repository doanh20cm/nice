/*
 * Created by JFormDesigner on Thu Mar 24 00:03:18 ICT 2022
 */

package etc;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author unknown
 */
public class test3 extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new test3();
        frame.setVisible(true);
    }

    public test3() {
        initComponents();
    }

    private void button1() {
        // TODO add your code here
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-DPLN7UU\\SQLEXPRESS:1433;database=Quanlysinhvien;user=sa;password=12345");

            Scanner sc = new Scanner(System.in);
            System.out.println("Username: ");
            String username = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();

            String sql = "CREATE LOGIN [" + username + "] WITH PASSWORD= N'" + password + "', DEFAULT_DATABASE=[QuanlySinhvien], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
//            sql = "CREATE USER [bruhhh] FOR LOGIN [lmao3]";
//            ps = conn.prepareStatement(sql);
//            ps.execute();


            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        textField3 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Add");
        button1.addActionListener(e -> button1());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(145, 145, 145))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textField3)
                        .addComponent(textField2, GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
                    .addGap(61, 61, 61))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
