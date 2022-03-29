/*
 * Created by JFormDesigner on Sat Mar 26 09:27:24 ICT 2022
 */

package UI;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author unknown
 */
public class giaovien extends JFrame {
    public giaovien(Connection connection) {
        initComponents();
        conn = connection;
    }

    private void them() {
        // TODO: chức năng thêm
        try{
            String sql = "insert into GIANGVIEN values (?,?,?,?,?)"; ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(magv.getText()));
            ps.setString(2,tengv.getText());
            ps.setInt(3, Integer.parseInt(mamon.getText()));
            ps.setInt(4,Integer.parseInt(malop.getText()));
            ps.setInt(5,Integer.parseInt(sdthoai.getText()));
            showMessageDialog(null, "Đã thêm " + ps.executeUpdate() + " giáo viên");
        } catch (Exception ignored){
            showMessageDialog(null,"Thêm thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sua() {
        // TODO chức năng sửa
        try {
            String sql = " update GIANGVIEN  set MAGV= ? where MAMON = ? and MALOP = ? and TENGV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(magv.getText()));
            ps.setInt(2, Integer.parseInt(mamon.getText()));
            ps.setInt(3, Integer.parseInt(malop.getText()));
            ps.setString(4, tengv.getText());
            JOptionPane.showMessageDialog(null, "Đã sửa" + ps.executeUpdate() + "giáo viên");
        } catch (Exception ex)
        {
            ex.printStackTrace();
            showMessageDialog(null, " Sửa thất bại", "Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void xoa() {
        // TODO chức năng xoá
        try {
            String sql = "delete from GIANGVIEN where TENGV = ? and MAMON = ? and MALOP = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tengv.getText());
            ps.setInt(2, Integer.parseInt(mamon.getText()));
            ps.setInt(3, Integer.parseInt(malop.getText()));
            showMessageDialog(null, "Đã xoá " + ps.executeUpdate() + " giáo viên");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void xem() {
        // TODO add your code here
    }

    private void thoat() {
        // TODO thoát chương trình
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        mamon = new JTextField();
        sdthoai = new JTextField();
        magv = new JTextField();
        tengv = new JTextField();
        malop = new JTextField();
        scrollPane1 = new JScrollPane();
        giangvien = new JTable();
        them = new JButton();
        sua = new JButton();
        xoa = new JButton();
        xem = new JButton();
        thoat = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("M\u00e3 gi\u00e1o vi\u00ean");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("T\u00ean gi\u1ea3ng vi\u00ean");
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label3 ----
        label3.setText("M\u00e3 l\u1edbp");
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label4 ----
        label4.setText("M\u00e3 m\u00f4n");
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label5 ----
        label5.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i");
        label5.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(giangvien);
        }

        //---- them ----
        them.setText("Th\u00eam");
        them.addActionListener(e -> them());

        //---- sua ----
        sua.setText("S\u1eeda");
        sua.addActionListener(e -> sua());

        //---- xoa ----
        xoa.setText("Xo\u00e1");
        xoa.addActionListener(e -> xoa());

        //---- xem ----
        xem.setText("Xem");
        xem.addActionListener(e -> xem());

        //---- thoat ----
        thoat.setText("Tho\u00e1t");
        thoat.addActionListener(e -> thoat());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(41, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 20, Short.MAX_VALUE))
                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(sdthoai)
                                .addComponent(malop)
                                .addComponent(mamon)
                                .addComponent(magv, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tengv))))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(them)
                        .addComponent(sua)
                        .addComponent(xoa)
                        .addComponent(xem)
                        .addComponent(thoat))
                    .addGap(23, 23, 23))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(magv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(them)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                            .addComponent(tengv, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addComponent(sua))
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(mamon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sdthoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(malop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(xoa)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(xem)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(thoat)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    static Connection conn;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField mamon;
    private JTextField sdthoai;
    private JTextField magv;
    private JTextField tengv;
    private JTextField malop;
    private JScrollPane scrollPane1;
    private JTable giangvien;
    private JButton them;
    private JButton sua;
    private JButton xoa;
    private JButton xem;
    private JButton thoat;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
