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
//        tbDIEM();
        setCbMSSV();
        setCbMAMON();
        setCbTENMON();
        setCbTENLOP();
    }

    public void setCbTENMON()
    //TODO hiển thị tên môn lên combobox
    {
        try {
            String sql = "Select TENMON from MONHOC ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbTENMON.addItem(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCbTENLOP()
        //TODO hiển thị tên lớp lên combobox
    {
        try {
            String sql = "Select TENLOP from LOP ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbTENLOP.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void tbDIEM() {
//        try {
//            String sql = "select * from DIEM";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            tbDIEM.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    public void setCbMSSV()
    //TODO hiển thị mã sinh viên lên combobox
    {
        try {
            String sql = "SELECT MSSV FROM SinhVien WHERE MSSV IN (SELECT MSSV FROM DIEM WHERE SinhVien.MSSV=DIEM.MSSV)";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbMSSV.addItem(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCbMAMON()
    //TODO hiển thị mã môn lên combobox
    {
        try {
            String sql = "select * from MONHOC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cbMAMON.addItem(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//
    private void scrollPane2MouseClicked() {
        // TODO add your code here
    }

    private void tbDIEMMouseClicked() {
        // TODO add your code here
//        try{
//            int row = tbDIEM.getSelectedRow();// lấy số dòng được chọn(getSelectedRow())
//            String tableClick = (tbDIEM.getModel().getValueAt(row, 0).toString());// lấy giá trị ở dòng và cột được chọn(getValueAt())
//            String sql = "select * from DIEM where MSSV = '" + tableClick + "'";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            if(rs.next()){
//                String add1 = rs.getInt(1)+"";
//                cbMSSV.setSelectedItem(add1);
//                String add2 = rs.getInt(2)+"";
//                cbMAMON.setSelectedItem(add2);
//                String add3 = rs.getString("DIEMTHI");
//                txtDIEMTHI.setText(add3);
//                String add4 = rs.getString("DIEMTP");
//                txtDIEMTP.setText(add4);
//            }
//        }catch(Exception ex){
//            JOptionPane.showMessageDialog(null, ex);
//            }
    }
//            txttest.setText(String.valueOf(row));
//            get number of selected row
//
//            int [] rows = tbDIEM.getSelectedRows();
//            txttest.setText(rows[0]+"" + rows[1]+"" + rows[2] + "" + rows[3]);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private void btnXOA() {
        // TODO xóa điểm sinh viên đã chọn
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

    private void btnTHEM() {
        // TODO thêm điểm theo mã môn học và mã sinh viên cho bảng ghi
        String sql = "insert into DIEM values(?,?,?,?,0)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, (Integer) cbMSSV.getItemAt(cbMSSV.getSelectedIndex()));// getItemAt(cbMSSV.getSelectedIndex()) lấy thứ tự của phần tự đã chọn
            // getSelectedIndex() lấy vị trí từ phần tử đã chọn
            pst.setInt(2, (Integer) cbMAMON.getItemAt(cbMAMON.getSelectedIndex()));
            pst.setFloat(3, Float.parseFloat(txtDIEMTHI.getText()));
            pst.setFloat(4, Float.parseFloat(txtDIEMTP.getText()));

            JOptionPane.showMessageDialog(null, "Đã thêm " + pst.executeUpdate() + " điểm của mã môn " + (Integer) cbMAMON.getItemAt(cbMAMON.getSelectedIndex()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void btnLOC() {
        // TODO lọc bảng theo mã môn và tên lớp
        try {
            String sql = "SELECT DIEM.MSSV, HOTENSV, DIEMTP, DIEMTHI, DIEMTB FROM DIEM, SinhVien WHERE DIEM.MSSV IN (SELECT MSSV FROM SinhVien WHERE MALOP IN (SELECT MALOP FROM LOP WHERE TENLOP=?) ) \n" +
                    " AND MAMON IN (SELECT MAMON FROM MONHOC WHERE TENMON=?) AND DIEM.MSSV=SinhVien.MSSV " ;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, (String) cbTENLOP.getItemAt(cbTENLOP.getSelectedIndex()));
            pst.setString(2, (String) cbTENMON.getItemAt(cbTENMON.getSelectedIndex()));
            ResultSet rs = pst.executeQuery();
            tbDIEM.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void btnTHOAT() {
        // TODO thoát giao diện điểm
        System.exit(0);
    }

    private void btnSUA() {
        // TODO sửa điểm theo mã môn, mã sinh viên trong bảng ghi
        String sql = "update DIEM set DIEMTHI = ?, DIEMTP = ? where MSSV = ? and MAMON = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setFloat(1, Float.parseFloat(txtDIEMTHI.getText()));
            pst.setFloat(2, Float.parseFloat(txtDIEMTP.getText()));
            pst.setInt(3, (Integer) cbMSSV.getItemAt(cbMSSV.getSelectedIndex()));
            pst.setInt(4, (Integer) cbMAMON.getItemAt(cbMAMON.getSelectedIndex()));
            JOptionPane.showMessageDialog(null, "Đã sửa " + pst.executeUpdate() + " điểm của mã môn " + (Integer) cbMAMON.getItemAt(cbMAMON.getSelectedIndex()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        cbMSSV = new JComboBox();
        label3 = new JLabel();
        cbMAMON = new JComboBox();
        label4 = new JLabel();
        txtDIEMTP = new JTextField();
        label5 = new JLabel();
        txtDIEMTHI = new JTextField();
        scrollPane2 = new JScrollPane();
        tbDIEM = new JTable();
        btnTHEM = new JButton();
        btnSUA = new JButton();
        btnXOA = new JButton();
        btnTHOAT = new JButton();
        btnLOC = new JButton();
        label6 = new JLabel();
        cbTENMON = new JComboBox();
        label7 = new JLabel();
        cbTENLOP = new JComboBox();

        //======== this ========
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("MSSV:");

        //---- label3 ----
        label3.setText("MAMON:");

        //---- label4 ----
        label4.setText("DIEMTP:");

        //---- label5 ----
        label5.setText("DIEMTHI:");

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
        btnTHEM.addActionListener(e -> btnTHEM());

        //---- btnSUA ----
        btnSUA.setText("S\u1eeda");
        btnSUA.addActionListener(e -> btnSUA());

        //---- btnXOA ----
        btnXOA.setText("X\u00f3a");
        btnXOA.addActionListener(e -> btnXOA());

        //---- btnTHOAT ----
        btnTHOAT.setText("Tho\u00e1t");
        btnTHOAT.addActionListener(e -> btnTHOAT());

        //---- btnLOC ----
        btnLOC.setText("C\u1eadp nh\u1eadt");
        btnLOC.addActionListener(e -> btnLOC());

        //---- label6 ----
        label6.setText("TENMON:");

        //---- label7 ----
        label7.setText("TENLOP:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap(18, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label6)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbTENMON, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(cbMAMON, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(cbMSSV, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGap(73, 73, 73)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbTENLOP, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtDIEMTP, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtDIEMTHI, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGap(128, 128, 128))
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnTHEM)
                            .addGap(32, 32, 32)
                            .addComponent(btnSUA)
                            .addGap(38, 38, 38)
                            .addComponent(btnXOA)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addComponent(btnLOC)
                            .addGap(27, 27, 27)
                            .addComponent(btnTHOAT, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMSSV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDIEMTHI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMAMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDIEMTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTENMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTENLOP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGap(32, 32, 32)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLOC)
                        .addComponent(btnTHEM)
                        .addComponent(btnXOA)
                        .addComponent(btnSUA)
                        .addComponent(btnTHOAT))
                    .addGap(64, 64, 64))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JComboBox cbMSSV;
    private JLabel label3;
    private JComboBox cbMAMON;
    private JLabel label4;
    private JTextField txtDIEMTP;
    private JLabel label5;
    private JTextField txtDIEMTHI;
    private JScrollPane scrollPane2;
    private JTable tbDIEM;
    private JButton btnTHEM;
    private JButton btnSUA;
    private JButton btnXOA;
    private JButton btnTHOAT;
    private JButton btnLOC;
    private JLabel label6;
    private JComboBox cbTENMON;
    private JLabel label7;
    private JComboBox cbTENLOP;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    static Connection conn;
}
