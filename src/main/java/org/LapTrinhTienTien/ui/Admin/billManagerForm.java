/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LapTrinhTienTien.ui.Admin;

import javax.swing.ImageIcon;
import org.LapTrinhTienTien.ui.model.modelCard;

/**
 *
 * @author Hi
 */
public class billManagerForm extends javax.swing.JPanel {

    /**
     * Creates new form billManagerForm
     */
    public billManagerForm() {
        initComponents();
        cardThongtin.setData(new modelCard(new ImageIcon(getClass().getResource("/user.png")),"Bùi Trọng Trí", "HD001", "20/04", "200000$"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new org.LapTrinhTienTien.ui.customItem.panelBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new org.LapTrinhTienTien.ui.customItem.table();
        cardThongtin = new org.LapTrinhTienTien.ui.customItem.card();
        myPanelBoxShadow1 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        jLabel1 = new javax.swing.JLabel();
        myPanelBoxShadow2 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        myPanelBoxShadow3 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table1);

        cardThongtin.setColor1(new java.awt.Color(142, 142, 250));
        cardThongtin.setColor2(new java.awt.Color(123, 123, 245));

        myPanelBoxShadow1.setBackground(new java.awt.Color(109, 216, 234));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 123, 142));
        jLabel1.setText("Thao tác");

        myPanelBoxShadow2.setBackground(new java.awt.Color(10, 200, 186));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/find.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Chi tiết");

        javax.swing.GroupLayout myPanelBoxShadow2Layout = new javax.swing.GroupLayout(myPanelBoxShadow2);
        myPanelBoxShadow2.setLayout(myPanelBoxShadow2Layout);
        myPanelBoxShadow2Layout.setHorizontalGroup(
            myPanelBoxShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        myPanelBoxShadow2Layout.setVerticalGroup(
            myPanelBoxShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(myPanelBoxShadow2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        myPanelBoxShadow3.setBackground(new java.awt.Color(10, 200, 186));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Xóa");

        javax.swing.GroupLayout myPanelBoxShadow3Layout = new javax.swing.GroupLayout(myPanelBoxShadow3);
        myPanelBoxShadow3.setLayout(myPanelBoxShadow3Layout);
        myPanelBoxShadow3Layout.setHorizontalGroup(
            myPanelBoxShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        myPanelBoxShadow3Layout.setVerticalGroup(
            myPanelBoxShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(myPanelBoxShadow3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction.png"))); // NOI18N

        javax.swing.GroupLayout myPanelBoxShadow1Layout = new javax.swing.GroupLayout(myPanelBoxShadow1);
        myPanelBoxShadow1.setLayout(myPanelBoxShadow1Layout);
        myPanelBoxShadow1Layout.setHorizontalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(myPanelBoxShadow3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(myPanelBoxShadow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        myPanelBoxShadow1Layout.setVerticalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myPanelBoxShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanelBoxShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(cardThongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardThongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.LapTrinhTienTien.ui.customItem.card cardThongtin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow1;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow2;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow3;
    private org.LapTrinhTienTien.ui.customItem.panelBorder panelBorder1;
    private org.LapTrinhTienTien.ui.customItem.table table1;
    // End of variables declaration//GEN-END:variables
}