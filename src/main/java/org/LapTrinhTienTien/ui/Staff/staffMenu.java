/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LapTrinhTienTien.ui.Staff;

import org.LapTrinhTienTien.ui.Admin.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    public staffMenu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        init();
    }
    private void init() {
        listMenu.addItem(new Model_Menu("", "Quản lý ", Model_Menu.MenuType.TITLE));
        listMenu.addItem(new Model_Menu("user", "info", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("bill", "ware house", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("warehouse", "product", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("dashboard", "supplier", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("customer", "timeTable", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
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

        listMenu = new org.LapTrinhTienTien.ui.customItem.listMenu<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));

        listMenu.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("SVNtimes new roman", 1, 24)); // NOI18N
        jLabel1.setText("Little mall");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 10, 112, 38);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopping-center.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 0, 35, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
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
    // End of variables declaration//GEN-END:variables
}