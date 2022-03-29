package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
/*
 * Created by JFormDesigner on Mon Mar 21 18:33:20 ICT 2022
 */


/**
 * @author unknown
 */
public class mainui extends JFrame {

    public mainui(Connection connection) {
        initComponents();
        conn = connection;

    }

    private void button1() {
        // TODO add your code here
        try {
            String sql = "SELECT name, principal_id,is_disabled,cast(create_date as date),cast(modify_date as date)\n" + "FROM sys.server_principals \n" + "where default_database_name = 'QuanlySinhvien'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//            table1.setModel(DbUtils.resultSetToTableModel(rs));

            int numberOfColumns = rs.getMetaData().getColumnCount();
            Vector<String> columnNames = new Vector<>();
            columnNames.addElement("Tên");
            columnNames.addElement("ID");
            columnNames.addElement("Trạng thái");
            columnNames.addElement("Ngày tạo");
            columnNames.addElement("Ngày sửa");
            // Get the column names


            // Get all rows.
            Vector<Vector<Object>> rows = new Vector<>();

            while (rs.next()) {
                Vector<Object> newRow = new Vector<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i == 3) {
                        if (rs.getBoolean(3)) {
                            newRow.addElement("Đã bị khóa");
                        } else {
                            newRow.addElement("Đang hoạt động");
                        }
                    } else {
                        newRow.addElement(rs.getObject(i));
                    }
                }
                rows.addElement(newRow);
            }
            DefaultTableModel model = new DefaultTableModel(rows, columnNames);
            table1.setModel(model);
            // disable edit table
            table1.setDefaultEditor(Object.class, null);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }



    private void btn_edit_sv() {
        // TODO gọi ra giao diện sinh viên
        SinhVien sv = new SinhVien(conn);
        sv.setVisible(true);
    }


    private void btnThoat() {
        // TODO thoát phần mềm
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    private void btn_edit_gv() {
        // TODO gọi ra giao diện giảng viên
        giaovien gv = new giaovien(conn);
        gv.setVisible(true);
    }

    private void btn_edit_diem() {
        // TODO gọi ra giao diện điểm sinh viên
        DIEM diem = new DIEM(conn);
        diem.setVisible(true);
    }

    private void btn_edit_mh() {
        // TODO gọi ra giao diện môn học
        MONHOC mh = new MONHOC(conn);
        mh.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        var button1 = new JButton();
        var scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btn_edit_sv = new JButton();
        btnThoat = new JButton();
        btn_edit_gv = new JButton();
        btn_edit_diem = new JButton();
        btn_edit_mh = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Xem");
        button1.addActionListener(e -> button1());

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- btn_edit_sv ----
        btn_edit_sv.setText("Sinh vi\u00ean");
        btn_edit_sv.addActionListener(e -> btn_edit_sv());

        //---- btnThoat ----
        btnThoat.setText("Tho\u00e1t");
        btnThoat.addActionListener(e -> btnThoat());

        //---- btn_edit_gv ----
        btn_edit_gv.setText("Gi\u1ea3ng vi\u00ean");
        btn_edit_gv.addActionListener(e -> btn_edit_gv());

        //---- btn_edit_diem ----
        btn_edit_diem.setText("K\u1ebft qu\u1ea3");
        btn_edit_diem.addActionListener(e -> btn_edit_diem());

        //---- btn_edit_mh ----
        btn_edit_mh.setText("M\u00f4n h\u1ecdc");
        btn_edit_mh.addActionListener(e -> btn_edit_mh());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(31, 31, 31)
                            .addComponent(btn_edit_diem)
                            .addGap(43, 43, 43)
                            .addComponent(btn_edit_sv)
                            .addGap(26, 26, 26)
                            .addComponent(btn_edit_gv)
                            .addGap(18, 18, 18)
                            .addComponent(btn_edit_mh)
                            .addContainerGap(122, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnThoat)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 21, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(btn_edit_sv)
                        .addComponent(btn_edit_diem)
                        .addComponent(btn_edit_gv)
                        .addComponent(btn_edit_mh))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addComponent(btnThoat)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    static Connection conn;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTable table1;
    private JButton btn_edit_sv;
    private JButton btnThoat;
    private JButton btn_edit_gv;
    private JButton btn_edit_diem;
    private JButton btn_edit_mh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
