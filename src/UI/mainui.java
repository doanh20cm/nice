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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        var button1 = new JButton();
        var scrollPane1 = new JScrollPane();
        table1 = new JTable();
        var button2 = new JButton();

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

        //---- button2 ----
        button2.setText("text");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(button1)
                            .addGap(80, 80, 80)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                    .addGap(30, 30, 30))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addGap(33, 33, 33))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    static Connection conn;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
