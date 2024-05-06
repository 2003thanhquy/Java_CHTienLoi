/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.LapTrinhTienTien.ui.HoaDon;
import org.LapTrinhTienTien.StaticApp.Global;
import org.LapTrinhTienTien.TableModel.GioHangTableModel;
import org.LapTrinhTienTien.model.GioHang;
import org.LapTrinhTienTien.service.*;
import org.LapTrinhTienTien.ui.HoaDon.search.*;
import org.LapTrinhTienTien.ui.HoaDon.tablecustom.*;
import org.LapTrinhTienTien.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


@Controller
public class CreateBill extends javax.swing.JFrame {
    @Autowired
    CuaHangSanPhamService khoService;

    private JPopupMenu menu;
    private PanelSearch search;
    private GioHangTableModel hoaDonTableModel;
    List<GioHang> gioHangs = new ArrayList<>();
    List<GioHang> storegioHang = new ArrayList<>();
    public CreateBill() {
        initComponents();
        menu = new JPopupMenu();
        search = new PanelSearch();
        hoaDonTableModel = new GioHangTableModel(gioHangs);
        tblHoaDon.setModel(hoaDonTableModel);
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        tblHoaDon.setRowHeight(40);
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.err.println("onEdit");
            }

            @Override
            public void onDelete(int row) {
                System.err.println("onDelete");
            }

            @Override
            public void onView(int row) {
               System.err.println("onView");
            }
        };
        
        tblHoaDon.getColumnModel().getColumn(1).setCellEditor(new TableTextViewEditer(new EventCellInputChange() {
            @Override
            public void inputChanged() {
               gioHangs.forEach(gioHang-> System.out.println(gioHang.getTongTien()));
            }
        }));
        tblHoaDon.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
        search.addEventClick(new EventClick() {
            private Boolean isCheckSPAdd(GioHang data){
                for(GioHang gh : gioHangs){
                    if(gh.getMaSP().equals(data.getMaSP())){
                        JOptionPane.showMessageDialog(CreateBill.this,"San Pham đã tồn tại trong giỏ hàng");
                        return false;
                    }
                }
                return true;
            }
            @Override
            public void itemClick(GioHang data) {
                menu.setVisible(false);
                txtSearch.setText("");
                if(isCheckSPAdd(data)){
                    gioHangs.add(data);
                    hoaDonTableModel.fireTableDataChanged();
                }
                menu.setVisible(false);
                hoaDonTableModel.fireTableDataChanged();
            }

            @Override
            public void itemRemove(Component com, GioHang data) {
                //search.remove(com);
               // removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                 menu.setVisible(false);
                txtSearch.setText("");
                String maCh = Global.account.getNhanVien().getCuaHang().getMaCH();
                Response response =  khoService.isCheckSoLuong(data.getMaSP(),data.getSoLuong());
                if(response.getFlag()){
                    if(isCheckSPAdd(data)){
                        gioHangs.add(data);
                        hoaDonTableModel.fireTableDataChanged();
                    }
                }else {
                    JOptionPane.showMessageDialog(CreateBill.this,response.getMessage());
                }

                 
               // System.out.println("Remove Item : " + data.getText());
            }
        });
        events();
    }
    private void events(){
        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThanhToanPerformed(e);
            }
        });
        btnBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBillPerformed(e);
            }
        });
    }
    private void btnBillPerformed(ActionEvent e) {
        bill.setText("                         The Little mall \n");
        bill.setText(bill.getText() + "\tSố 1, Võ Văn Ngân \n");
        bill.setText(bill.getText() + "\tThủ đức, Thành phố Hồ Chí Minh, \n");
        bill.setText(bill.getText() + "\t+084 123456789, \n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
        bill.setText(bill.getText() + " Iteam \tQty \tPrice \n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");

//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        for (int i = 0; i < jTable1.getRowCount(); i++) {
//
//            String name = df.getValueAt(i, 0).toString();
//            String qt = df.getValueAt(i, 1).toString();
//            String prc = df.getValueAt(i, 2).toString();
//
//            bill.setText(bill.getText() + name+"\t"+qt+"\t"+prc+" \n");
//
//        }
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
        //bill.setText(bill.getText() + "SubTotal :\t"+Too.getText()+"\n");
        bill.setText(bill.getText() + "====================================\n");
        bill.setText(bill.getText() +"                     Thanks For Your Business...!"+"\n");
        bill.setText(bill.getText() + "----------------------------------------------------------------\n");
    }
    protected  void btnThanhToanPerformed(ActionEvent e){
        if(gioHangs.size() ==0){
            JOptionPane.showMessageDialog(this,"Vừa lòng chọn sản phẩm thanh toán");
            return;
        }
        for(GioHang gh : gioHangs){
            Response response = khoService.isCheckSoLuong(gh.getMaSP(),gh.getSoLuong());
            if(!response.getFlag()){
                JOptionPane.showMessageDialog(CreateBill.this,response.getMessage());
                return;
            }
        }

    }
    private void loadData(){

        storegioHang.add(new GioHang("SP001", 2, 100));
        storegioHang.add(new GioHang("SP002", 3, 150));
        storegioHang.add(new GioHang("SP003", 3, 150));
        storegioHang.add(new GioHang("SP004", 3, 150));
        storegioHang.add(new GioHang("SP005", 3, 150));
        //hoaDonTableModel.fireTableDataChanged();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtSearch = new org.LapTrinhTienTien.ui.HoaDon.search.MyTextField();
        btnThanhToan = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tblHoaDon);

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");

        btnBill.setText("Tạo Hóa đơn");

        bill.setColumns(20);
        bill.setRows(5);
        jScrollPane2.setViewportView(bill);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBill)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBill))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
       System.out.println("----------");
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String text = txtSearch.getText().trim().toLowerCase();
        search.setData(search(text));
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(txtSearch, 0, txtSearch.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
        } else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private List<GioHang> search(String search) {
        int limitData = 7;
        return khoService.searchTenSP(search);
    }
    String dataStory[] = {"300 - Rise of an Empire",
        "Empire Records",
        "Empire State",
        "Frozen",
        "The Courier"};

    private void removeHistory(String text) {
        for (int i = 0; i < dataStory.length; i++) {
            String d = dataStory[i];
            if (d.toLowerCase().equals(text.toLowerCase())) {
                dataStory[i] = "";
            }
        }
    }

    private boolean isStory(String text) {
        for (String d : dataStory) {
            if (d.toLowerCase().equals(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

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
            java.util.logging.Logger.getLogger(CreateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private org.LapTrinhTienTien.ui.HoaDon.search.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
