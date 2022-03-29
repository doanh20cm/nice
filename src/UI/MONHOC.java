/*
 * Created by JFormDesigner on Tue Mar 29 13:47:11 ICT 2022
 */

package UI;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Connection;

/**
 * @author unknown
 */
public class MONHOC extends JFrame {
    public MONHOC(Connection conn) {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        cbMAMON = new JComboBox();
        label2 = new JLabel();
        cbTENMON = new JComboBox();
        label3 = new JLabel();
        cbMAKHOA = new JComboBox();
        label4 = new JLabel();
        txtSOTIET = new JTextField();
        scrollPane1 = new JScrollPane();
        tbMonhoc = new JTable();
        btnThem = new JButton();
        btnXoa = new JButton();
        btnSua = new JButton();
        btnThoat = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("MAMON:");

        //---- label2 ----
        label2.setText("TENMON:");

        //---- label3 ----
        label3.setText("MAKHOA:");

        //---- label4 ----
        label4.setText("SOTIET:");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tbMonhoc);
        }

        //---- btnThem ----
        btnThem.setText("Th\u00eam");

        //---- btnXoa ----
        btnXoa.setText("X\u00f3a");

        //---- btnSua ----
        btnSua.setText("S\u1eeda");

        //---- btnThoat ----
        btnThoat.setText("Tho\u00e1t");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(12, 12, 12)
                                    .addComponent(cbMAMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbTENMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(60, 60, 60)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(cbMAKHOA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSOTIET, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGap(75, 75, 75)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnXoa)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnThoat))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnThem)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSua))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(58, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMAMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(label3)
                        .addComponent(cbMAKHOA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem)
                        .addComponent(btnSua))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(cbTENMON, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(txtSOTIET, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa)
                        .addComponent(btnThoat))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox cbMAMON;
    private JLabel label2;
    private JComboBox cbTENMON;
    private JLabel label3;
    private JComboBox cbMAKHOA;
    private JLabel label4;
    private JTextField txtSOTIET;
    private JScrollPane scrollPane1;
    private JTable tbMonhoc;
    private JButton btnThem;
    private JButton btnXoa;
    private JButton btnSua;
    private JButton btnThoat;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
