/*
 * Created by JFormDesigner on Sun Mar 27 16:23:36 ICT 2022
 */

package UI;

import java.awt.event.*;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.*;

/**
 * @author unknown
 */
public class DIEM extends JFrame {
    public DIEM(Connection connection) {
        initComponents();
        conn = connection;
        tbDIEM();
        setCbMSSV();

    }

    public void tbDIEM() {
        try {
            String sql = "select * from DIEM";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            tbDIEM.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void setCbMSSV(){
        try {
            String sql = "select * from DIEM";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbMSSV.addItem(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void scrollPane2MouseClicked() {
        // TODO add your code here
    }

    private void tbDIEMMouseClicked() {
        // TODO add your code here
        try{
//            int row = tbDIEM.getSelectedRow();// lấy số dòng được chọn(getSelectedRow())
//            txttest.setText(String.valueOf(row));
            //get number of selected row

//            int [] rows = tbDIEM.getSelectedRows();
//            txttest.setText(rows[0]+"" + rows[1]+"" + rows[2] + "" + rows[3]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void btnXOA() {
        // TODO add your code here
        int [] rows = tbDIEM.getSelectedRows();// row = 0,3, row[0] = 0, row[1] = 3
        int length = rows.length;
        String sv = tbDIEM.getValueAt(rows[0],0).toString();
        String sv1 = tbDIEM.getValueAt(rows[1],0).toString();
        String sql ="delete from DIEM where MSSV = ?";
        String sql1 = "";
        for (int i = 0; i < length - 1; i++)// vòng lặp này dùng để xóa các dòng được chọn
        {
            sql1 = " or MSSV = ? ";

        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql+sql1);
            pst.setString(1,sv);
            pst.setString(2,sv1);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        cbMSSV = new JComboBox();
        label3 = new JLabel();
        cbMAMON = new JComboBox();
        label4 = new JLabel();
        txtDIEMTP = new JTextField();
        label5 = new JLabel();
        txtDIEMTHI = new JTextField();
        label6 = new JLabel();
        txtMADIEM = new JTextField();
        scrollPane2 = new JScrollPane();
        tbDIEM = new JTable();
        btnTHEM = new JButton();
        btnSUA = new JButton();
        btnXOA = new JButton();
        btnTHOAT = new JButton();
        txttest = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u0110i\u1ec3m Sinh Vi\u00ean");

        //---- label2 ----
        label2.setText("MSSV:");

        //---- label3 ----
        label3.setText("MAMON:");

        //---- label4 ----
        label4.setText("DIEMTP:");

        //---- label5 ----
        label5.setText("DIEMTHI:");

        //---- label6 ----
        label6.setText("MADIEM:");

        //======== scrollPane2 ========
        {
            scrollPane2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane2MouseClicked();
                }
            });

            //---- tbDIEM ----
            tbDIEM.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tbDIEMMouseClicked();
                }
            });
            scrollPane2.setViewportView(tbDIEM);
        }

        //---- btnTHEM ----
        btnTHEM.setText("Th\u00eam");

        //---- btnSUA ----
        btnSUA.setText("S\u1eeda");

        //---- btnXOA ----
        btnXOA.setText("X\u00f3a");
        btnXOA.addActionListener(e -> btnXOA());

        //---- btnTHOAT ----
        btnTHOAT.setText("Tho\u00e1t");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(cbMSSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDIEMTHI, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(btnTHEM)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSUA)
                            .addContainerGap(8, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbMAMON)
                                .addComponent(txtDIEMTP))
                            .addGap(26, 26, 26)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMADIEM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(btnXOA)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnTHOAT)
                            .addGap(0, 8, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(txttest, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 69, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMSSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDIEMTHI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTHEM)
                        .addComponent(btnSUA))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMAMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMADIEM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXOA)
                        .addComponent(btnTHOAT))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDIEMTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addComponent(txttest, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JComboBox cbMSSV;
    private JLabel label3;
    private JComboBox cbMAMON;
    private JLabel label4;
    private JTextField txtDIEMTP;
    private JLabel label5;
    private JTextField txtDIEMTHI;
    private JLabel label6;
    private JTextField txtMADIEM;
    private JScrollPane scrollPane2;
    private JTable tbDIEM;
    private JButton btnTHEM;
    private JButton btnSUA;
    private JButton btnXOA;
    private JButton btnTHOAT;
    private JTextField txttest;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    static Connection conn;
}
