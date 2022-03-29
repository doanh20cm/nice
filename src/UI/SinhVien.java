/*
 * Created by JFormDesigner on Tue Mar 29 12:11:46 ICT 2022
 */

package UI;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author unknown
 */
public class SinhVien extends JFrame {
    public SinhVien(Connection connection) {
        initComponents();
        conn = connection;
        cbMSSV();
    }

    private void cbMSSV() {
        // TODO hiển thị mã sinh viên trong combobox
        try {
            String sql = "SELECT * FROM SinhVien";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbMSSV.addItem(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        cbMSSV = new JComboBox();
        label2 = new JLabel();
        txtHOTENSV = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        cbTENLOP = new JComboBox();
        label5 = new JLabel();
        rbtnNam = new JRadioButton();
        rbtnNu = new JRadioButton();
        label6 = new JLabel();
        txtNOISINH = new JTextField();
        label7 = new JLabel();
        txtCMND = new JTextField();
        label8 = new JLabel();
        txtSDT = new JTextField();
        label9 = new JLabel();
        txtEMAIL = new JTextField();
        label10 = new JLabel();
        cbMALOP = new JComboBox();
        scrollPane1 = new JScrollPane();
        tbsinhvien = new JTable();
        btnThem = new JButton();
        btnSua = new JButton();
        btnXoa = new JButton();
        btnCapnhat = new JButton();
        btnThoat = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("MSSV:");

        //---- cbMSSV ----
        cbMSSV.addActionListener(e -> cbMSSV());

        //---- label2 ----
        label2.setText("HOTENSV:");

        //---- label3 ----
        label3.setText("NGAYSINH:");

        //---- label4 ----
        label4.setText("TENLOP:");

        //---- label5 ----
        label5.setText("GIOITINH:");

        //---- rbtnNam ----
        rbtnNam.setText("Nam");

        //---- rbtnNu ----
        rbtnNu.setText("Nu");

        //---- label6 ----
        label6.setText("NOISINH:");

        //---- label7 ----
        label7.setText("CMND:");

        //---- label8 ----
        label8.setText("SDT:");

        //---- label9 ----
        label9.setText("EMAIL:");

        //---- label10 ----
        label10.setText("MALOP:");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tbsinhvien);
        }

        //---- btnThem ----
        btnThem.setText("Th\u00eam");

        //---- btnSua ----
        btnSua.setText("S\u1eeda");

        //---- btnXoa ----
        btnXoa.setText("X\u00f3a");

        //---- btnCapnhat ----
        btnCapnhat.setText("C\u1eadp nh\u1eadt");

        //---- btnThoat ----
        btnThoat.setText("Tho\u00e1t");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(label4))
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbMSSV)
                                                    .addComponent(txtHOTENSV))
                                                .addComponent(cbTENLOP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbtnNam)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rbtnNu)))
                                    .addGap(225, 225, 225)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label7)
                                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNOISINH, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(txtCMND, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(txtEMAIL, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                        .addComponent(cbMALOP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(166, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(btnThem)
                    .addGap(66, 66, 66)
                    .addComponent(btnSua)
                    .addGap(56, 56, 56)
                    .addComponent(btnXoa)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                    .addComponent(btnCapnhat)
                    .addGap(50, 50, 50)
                    .addComponent(btnThoat)
                    .addGap(33, 33, 33))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMSSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(label6)
                        .addComponent(txtNOISINH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtHOTENSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)
                        .addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label8)
                        .addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTENLOP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(label9)
                        .addComponent(txtEMAIL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(rbtnNam)
                        .addComponent(rbtnNu)
                        .addComponent(label10)
                        .addComponent(cbMALOP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThoat)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnCapnhat))
                    .addContainerGap(46, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    static Connection conn;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox cbMSSV;
    private JLabel label2;
    private JTextField txtHOTENSV;
    private JLabel label3;
    private JLabel label4;
    private JComboBox cbTENLOP;
    private JLabel label5;
    private JRadioButton rbtnNam;
    private JRadioButton rbtnNu;
    private JLabel label6;
    private JTextField txtNOISINH;
    private JLabel label7;
    private JTextField txtCMND;
    private JLabel label8;
    private JTextField txtSDT;
    private JLabel label9;
    private JTextField txtEMAIL;
    private JLabel label10;
    private JComboBox cbMALOP;
    private JScrollPane scrollPane1;
    private JTable tbsinhvien;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapnhat;
    private JButton btnThoat;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
