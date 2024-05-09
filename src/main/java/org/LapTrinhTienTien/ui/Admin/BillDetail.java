/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.LapTrinhTienTien.ui.Admin;

import ch.qos.logback.core.util.Loader;
import lombok.Setter;
import org.LapTrinhTienTien.TableModel.ChiTietHoaDonTableModel;
import org.LapTrinhTienTien.model.ChiTietHoaDon;
import org.LapTrinhTienTien.model.GioHang;
import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quyth
 */
@Controller
public class BillDetail extends javax.swing.JFrame {

    /**
     * Creates new form BillDetail
     */

    ChiTietHoaDonService chiTietHoaDonService;
    ChiTietHoaDonTableModel chiTietHoaDonTableModel;
    List<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
    @Setter
    HoaDon hoaDon;
    public BillDetail(@Autowired ChiTietHoaDonService chiTietHoaDonService) {
        initComponents();
        jTextField1.setEditable(false);
        bill.setEditable(false);
        this.chiTietHoaDonService = chiTietHoaDonService;
        this.setLocationRelativeTo(null);
        events();

    }
    private void events(){
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("Mã HD: " + hoaDon.getMaHD());
                loadData();
                loadBill();
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThoatPerformed();
            }
        });
    }
    private void btnThoatPerformed(){
        this.dispose();
    }

    private void loadData(){
        chiTietHoaDonList.clear();
        chiTietHoaDonList  = chiTietHoaDonService.getListCTHD(hoaDon);
        System.out.println("-------lst-chitiet----"+ chiTietHoaDonList.size());
        chiTietHoaDonTableModel = new ChiTietHoaDonTableModel(chiTietHoaDonList);
        tblCTHD.setModel(chiTietHoaDonTableModel);
        chiTietHoaDonTableModel.fireTableDataChanged();
    }
    private void loadBill() {
        /*bill.setText("                         The Little mall \n");
        bill.setText(bill.getText() + "\tSố 1, Võ Văn Ngân \n");
        bill.setText(bill.getText() + "\tThủ đức, Thành phố Hồ Chí Minh, \n");
        bill.setText(bill.getText() + "\t+084 123456789, \n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
        bill.setText(bill.getText() + " Ten \tSo Luong \tGia \tThanh Tien \n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");


        for(ChiTietHoaDon gh : chiTietHoaDonList){

            String name =gh.getSanPham().getTenSP();
            String qt =String.valueOf(gh.getSoLuong()) ;
            String prc =String.valueOf( gh.getGiaThanhToan());
            String tongtien = String.valueOf(gh.getTongTien());
            bill.setText(bill.getText() + name+"\t  "+qt+"\t"+prc+"S\t"+tongtien+" \n");

        }
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
        bill.setText(bill.getText() + "Tổng Tiền :\t"+hoaDon.getGiaTri()+"\n");
        bill.setText(bill.getText() + "Giam gia:\t"+(hoaDon.getThanhTien()-hoaDon.getGiaTri())+"\n");
        bill.setText(bill.getText() + "Thành Tiền :\t"+hoaDon.getThanhTien()+"\n");
        bill.setText(bill.getText() + "====================================\n");
        bill.setText(bill.getText() +"                     Thanks For Your Business...!"+"\n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
*/
        String billText = "";

// Header section with consistent indentation, centered alignment, top and bottom borders, and adjusted spacing
        billText += String.format("╔════════════════════════════════════════════════════╗\n");
        billText += String.format("%45s\n", "The Little Mall");  // Adjust spacing for centered alignment
        billText += String.format("\n");  // Add extra line spacing
        billText += String.format("%20sSố 1, Võ Văn Ngân\n", "");
        billText += String.format("%20sThủ Đức, Thành phố Hồ Chí Minh,\n", "");
        billText += String.format("%20s+084 123456789\n", "");
        billText += String.format("╚════════════════════════════════════════════════════╝\n");

// Title row with clear separation, alignment, top and bottom borders, and adjusted spacing
        billText += String.format("╔════════════════════════════════════════════════════╗\n");
        billText += String.format("| %-20s | %8s | %8s | %12s |\n", "Tên", "Số lượng", "Đơn giá", "Thành tiền");
        billText += String.format("╠════════════════════════════════════════════════════╗\n");

// Loop through ChiTietHoaDon entries with formatted output, consistent borders, and adjusted spacing
        for (ChiTietHoaDon gh : chiTietHoaDonList) {
            String name = gh.getSanPham().getTenSP();
            String qt = String.valueOf(gh.getSoLuong());
            String prc = String.valueOf(gh.getGiaThanhToan()) + "S";
            String tongtien = String.valueOf(gh.getTongTien());
            billText += String.format("| %-20s | %8s | %8s | %12s |\n", name, qt, prc, tongtien);
        }

        billText += String.format("╠════════════════════════════════════════════════════╗\n");

// Summary section with alignment, formatting, top and bottom borders, and adjusted spacing
        billText += String.format("| %-25s | %10s |\n", "Tổng Tiền :", hoaDon.getGiaTri());
        billText += String.format("| %-25s | %10s |\n", "Giảm giá:", hoaDon.getThanhTien() - hoaDon.getGiaTri());
        billText += String.format("| %-25s | %10s |\n", "Thành Tiền :", hoaDon.getThanhTien());
        billText += String.format("╚════════════════════════════════════════════════════╝\n");

        billText += "============================================================\n";
        billText += String.format("%45s\n", "Thanks For Your Business...!");
        billText += "----------------------------------------------------------------\n";

// Update the bill text view with the formatted string
        bill.setText(billText);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bill.setEditable(false);
        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        jScrollPane3.setViewportView(tblCTHD);

        jTextField1.setText("Mã  HD:");

        btnLoad.setText("Load ");

        btnThoat.setText("Thoát");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new BillDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnThoat;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblCTHD;
    // End of variables declaration//GEN-END:variables
}
