/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LapTrinhTienTien.ui.Staff;

import org.LapTrinhTienTien.ui.Admin.*;

import java.awt.*;
import javax.swing.*;

import org.LapTrinhTienTien.ui.events.EventMenuSelected;
import org.LapTrinhTienTien.ui.model.Model_Menu;

/**
 *
 * @author Hi
 */

public class staffMenu extends javax.swing.JPanel {

    /**
     * Creates new form menu
     */
    private EventMenuSelected event;
    public JFrame parentForm;
    loginForm login;
    public void setParentForm(JFrame parentForm)
    {
        this.parentForm = parentForm;
    }

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    public staffMenu() {
        initComponents();
        logOutLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        listMenu.setOpaque(false);
        init();
    }
    public void setLogin(loginForm login){
        this.login = login;
    }
    private void init() {
        listMenu.addItem(new Model_Menu("", "Quản lý ", Model_Menu.MenuType.TITLE));
        listMenu.addItem(new Model_Menu("user", "info", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("warehouse", "ware house", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("customer", "timeTable", Model_Menu.MenuType.MENU));
        //listMenu.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "Chức năng", Model_Menu.MenuType.TITLE));
        listMenu.addItem(new Model_Menu("coupon", "invoice", Model_Menu.MenuType.MENU));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logOutLbl = new javax.swing.JLabel();
        listMenu = new org.LapTrinhTienTien.ui.customItem.listMenu<>();

        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("SVNtimes new roman", 1, 24)); // NOI18N
        jLabel1.setText("Little mall");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 10, 112, 38);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopping-center.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 0, 35, 40);

        logOutLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        logOutLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutLblMousePressed(evt);
            }
        });

        listMenu.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logOutLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutLbl)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logOutLblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutLblMousePressed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            parentForm.dispose();
            login.setVisible(true);
        }
    }//GEN-LAST:event_logOutLblMousePressed
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private org.LapTrinhTienTien.ui.customItem.listMenu<String> listMenu;
    private javax.swing.JLabel logOutLbl;
    // End of variables declaration//GEN-END:variables
}