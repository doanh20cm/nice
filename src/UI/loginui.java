package UI;

import DAO.tientich;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.sql.Connection;
/*
 * Created by JFormDesigner on Mon Mar 21 18:02:03 ICT 2022
 */



/**
 * @author unknown
 */
public class loginui extends JFrame {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        loginui loginui = new loginui();
        loginui.setVisible(true);
    }

    public loginui() {
        initComponents();
    }

    private void button1() {
        // TODO: Chức năng đăng nhập cho nút đăng nhập
        Connection conn = tientich.getConnection(tf_un.getText(), String.valueOf(pf_pass.getPassword()));
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            this.dispose();
            new mainui(conn).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
        }
    }

    private void button2() {
        // TODO add your code here
        if (!FlatDarkLaf.isLafDark()) {
            FlatDarkLaf.setup();
            button2.setText("Dark");
            SwingUtilities.updateComponentTreeUI(this);
        } else {
            FlatLightLaf.setup();
            button2.setText("Light");
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        var label1 = new JLabel();
        var label2 = new JLabel();
        tf_un = new JTextField();
        pf_pass = new JPasswordField();
        var button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Username:");

        //---- label2 ----
        label2.setText("Pass:");

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> button1());

        //---- button2 ----
        button2.setText("Light");
        button2.addActionListener(e -> button2());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(button1)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(tf_un, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pf_pass, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                            .addGap(78, 78, 78))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(320, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_un, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pf_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private static JTextField tf_un;
    private static JPasswordField pf_pass;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
