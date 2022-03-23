package etc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Created by JFormDesigner on Sat Mar 19 23:09:13 ICT 2022
 */



/**
 * @author unknown
 */
public class test extends JFrame {

    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-DPLN7UU\\SQLEXPRESS:1433;database=QuanlySinhvien;user=sa;password=12345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        if (conn != null) {
            JOptionPane.showMessageDialog(null,"Kết nối thành công");
        } else {
            JOptionPane.showMessageDialog(null,"Kết nối thất bại");
        }

        test t = new test();
        t.setVisible(true);
    }

    public test() throws SQLException {
        initComponents();
    }

    private void btn_add(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_edit(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_del(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();

        //======== frame1 ========
        {
            var frame1ContentPane = frame1.getContentPane();

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGap(0, 686, Short.MAX_VALUE)
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGap(0, 323, Short.MAX_VALUE)
                    );
                }
                tabbedPane1.addTab("text", panel1);

                //======== panel2 ========
                {

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGap(0, 686, Short.MAX_VALUE)
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGap(0, 323, Short.MAX_VALUE)
                    );
                }
                tabbedPane1.addTab("text", panel2);
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPane1)
                        .addContainerGap())
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPane1)
                        .addContainerGap())
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
