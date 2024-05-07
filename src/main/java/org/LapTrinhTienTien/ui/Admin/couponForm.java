/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LapTrinhTienTien.ui.Admin;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.LapTrinhTienTien.TableModel.KhuyenMaiTableModel;
import org.LapTrinhTienTien._enum.Status;
import org.LapTrinhTienTien.model.ChuongTrinhKhuyenMai;
import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.service.ChuongTrinhKhuyenMaiService;
import org.LapTrinhTienTien.ui.model.modelCard;
import org.LapTrinhTienTien.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hi
 */
@Service
public class couponForm extends javax.swing.JPanel {

    /**
     * Creates new form couponForm
     */
    ChuongTrinhKhuyenMaiService chuongTrinhKhuyenMaiService;
    KhuyenMaiTableModel khuyenMaiTableModel;
    List<ChuongTrinhKhuyenMai> chuongTrinhKhuyenMaiList = new ArrayList<ChuongTrinhKhuyenMai>();
    Boolean isLuu = false;
    public couponForm(@Autowired ChuongTrinhKhuyenMaiService service) {
        initComponents();
        this.chuongTrinhKhuyenMaiService = service;
        init();
        //cardThongtin.setData(new modelCard(new ImageIcon(getClass().getResource("/coupon.png")),"Tên SP", "HD001", "20/04", "200000$"));
        loadData();
        events();
    }
    private void init() {

    }
    private void loadData(){
        chuongTrinhKhuyenMaiList = chuongTrinhKhuyenMaiService.getAllKhuyenMai();
        khuyenMaiTableModel = new KhuyenMaiTableModel(chuongTrinhKhuyenMaiList);
        tblKhuyenMai.setModel(khuyenMaiTableModel);
    }
    private void events(){
        btnThem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnThemPerformed(e);
            }
        });
        btnLuu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnLuuPerformed(e);
            }
        });
        btnKLuu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnKLuuPerformed(e);
            }
        });
        btnSua.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnSuaPerformed(e);
            }
        });
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        tblKhuyenMai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(isLuu){
                    if (!e.getValueIsAdjusting()) { // Đảm bảo sự kiện chỉ được kích hoạt một lần khi chọn hàng
                        int index = tblKhuyenMai.getSelectedRow();
                        ChuongTrinhKhuyenMai ctkm = khuyenMaiTableModel.getRow(index);
                        tf_maCH.setEditable(false);
                        tf_maCH.setText(ctkm.getMaCT());
                        tf_TenCH.setText(ctkm.getTenChuongTrinh());
                        tf_giam.setText(String.valueOf(ctkm.getPhanTramGiamGia()));
                        tf_DK.setText(String.valueOf(ctkm.getTonghonDon()));
                        dcNgayBD.setDate(Date.from(ctkm.getNgayApDung().atZone(ZoneId.systemDefault()).toInstant()));
                        dcNgayKT.setDate(Date.from(ctkm.getNgayKetThuc().atZone(ZoneId.systemDefault()).toInstant()));
                        cmbTrangThai.setSelectedItem(ctkm.getStatus().toString());

                    }
                }

            }
        });
    }
    private boolean isValidData() {
        // Kiểm tra mã chương trình không được để trống
        if (tf_maCH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã chương trình.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (tf_TenCH.getText().isEmpty() || tf_giam.getText().isEmpty() || tf_DK.getText().isEmpty() ||
                dcNgayBD.getDate() == null || dcNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra ngày bắt đầu phải trước ngày kết thúc
        LocalDateTime ngayApDung = LocalDateTime.ofInstant(dcNgayBD.getDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime ngayKetThuc = LocalDateTime.ofInstant(dcNgayKT.getDate().toInstant(), ZoneId.systemDefault());
        if (ngayApDung.isAfter(ngayKetThuc)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int giamGia = Integer.parseInt(tf_giam.getText());
            if (giamGia < 0 || giamGia > 100) {
                throw new NumberFormatException(); // Nếu không nằm trong khoảng 0-100, sẽ ném lỗi để bắt
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giảm giá phải là một số nguyên trong khoảng từ 0 đến 100.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            float dieuKien = Float.parseFloat(tf_DK.getText());
            if (dieuKien <= 0) {
                throw new NumberFormatException(); // Nếu không lớn hơn 0, sẽ ném lỗi để bắt
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Điều kiện áp dụng phải là một số lớn hơn 0.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void btnThemPerformed(ActionEvent e) {
        if(isLuu) return;
        if (!isValidData()) {
            return;
        }
        String maCT = tf_maCH.getText();
        String tenChuongTrinh = tf_TenCH.getText();
        Integer phanTramGiamGia = Integer.parseInt(tf_giam.getText());
        LocalDateTime ngayApDung = LocalDateTime.ofInstant(dcNgayBD.getDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime ngayKetThuc = LocalDateTime.ofInstant(dcNgayKT.getDate().toInstant(), ZoneId.systemDefault());
        float dieuKienApDung = Float.parseFloat(tf_DK.getText());
        Status status = Status.valueOf((String) cmbTrangThai.getSelectedItem());
        ChuongTrinhKhuyenMai chuongTrinhKhuyenMai = new ChuongTrinhKhuyenMai();
        chuongTrinhKhuyenMai.setMaCT(maCT);
        chuongTrinhKhuyenMai.setTenChuongTrinh(tenChuongTrinh);
        chuongTrinhKhuyenMai.setPhanTramGiamGia(phanTramGiamGia);
        chuongTrinhKhuyenMai.setNgayApDung(ngayApDung);
        chuongTrinhKhuyenMai.setNgayKetThuc(ngayKetThuc);
        chuongTrinhKhuyenMai.setTonghonDon(dieuKienApDung);
        chuongTrinhKhuyenMai.setStatus(status);


        Response response = chuongTrinhKhuyenMaiService.saveChuongTrinhKM(chuongTrinhKhuyenMai);
        JOptionPane.showMessageDialog(this, response.getMessage(), "ThongBao", JOptionPane.INFORMATION_MESSAGE);
        if(response.getFlag()){
            loadData();
            btnKLuuPerformed(null);
        }
    }
    private void btnSuaPerformed(ActionEvent e){
        isLuu = true;
    }
    private void btnKLuuPerformed(ActionEvent e){
        isLuu = false;
        tf_maCH.setEditable(true);
        tf_maCH.setText("");
        tf_TenCH.setText("");
        tf_giam.setText("");
        tf_DK.setText("");
    }
    private void btnLuuPerformed(ActionEvent e) {
        if(!isLuu) return;
        if (isValidData()) {
            // Lấy thông tin từ các trường nhập liệu
            String maCT = tf_maCH.getText();
            String tenChuongTrinh = tf_TenCH.getText();
            int phanTramGiamGia = Integer.parseInt(tf_giam.getText());
            float dieuKienApDung = Float.parseFloat(tf_DK.getText());
            LocalDateTime ngayApDung = LocalDateTime.ofInstant(dcNgayBD.getDate().toInstant(), ZoneId.systemDefault());
            LocalDateTime ngayKetThuc = LocalDateTime.ofInstant(dcNgayKT.getDate().toInstant(), ZoneId.systemDefault());
            Status trangThai = Status.valueOf(cmbTrangThai.getSelectedItem().toString());
            ChuongTrinhKhuyenMai chuongTrinhKhuyenMai = new ChuongTrinhKhuyenMai(maCT, tenChuongTrinh, phanTramGiamGia, ngayApDung, ngayKetThuc, dieuKienApDung, trangThai);
            Response response = chuongTrinhKhuyenMaiService.updateChuongTrinhKM(chuongTrinhKhuyenMai);
            JOptionPane.showMessageDialog(this, response.getMessage(), "ThongBao", JOptionPane.INFORMATION_MESSAGE);
            if(response.getFlag()){
                loadData();
                btnKLuuPerformed(null);
            }
        }
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
        myPanelBoxShadow1 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        myPanelBoxShadow2 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        lbTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new org.LapTrinhTienTien.ui.customItem.table();
        btnThem = new org.LapTrinhTienTien.ui.customItem.button();
        btnSua = new org.LapTrinhTienTien.ui.customItem.button();
        btnReload = new org.LapTrinhTienTien.ui.customItem.button();
        tf_TenCH = new javax.swing.JTextField();
        btnLuu = new org.LapTrinhTienTien.ui.customItem.button();
        dcNgayBD = new com.toedter.calendar.JDateChooser();
        dcNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_maCH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_DK = new javax.swing.JTextField();
        cmbTrangThai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tf_giam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnKLuu = new org.LapTrinhTienTien.ui.customItem.button();

        lbTittle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbTittle.setForeground(new java.awt.Color(127, 127, 127));
        lbTittle.setText("Khuyến mãi");

        jScrollPane1.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout myPanelBoxShadow2Layout = new javax.swing.GroupLayout(myPanelBoxShadow2);
        myPanelBoxShadow2.setLayout(myPanelBoxShadow2Layout);
        myPanelBoxShadow2Layout.setHorizontalGroup(
            myPanelBoxShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(myPanelBoxShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTittle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        myPanelBoxShadow2Layout.setVerticalGroup(
            myPanelBoxShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );

        btnThem.setText("Thêm");
        btnThem.setRadius(35);

        btnSua.setText("Sửa");
        btnSua.setRadius(35);

        btnReload.setText("Reload");
        btnReload.setRadius(35);

        btnLuu.setText("Lưu");
        btnLuu.setRadius(35);

        jLabel1.setText("Mã CH");

        jLabel2.setText("Tên Chương Trình");

        jLabel3.setText("Ngày BĐ");

        jLabel4.setText("Ngày KT");

        cmbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVE", "INACTIVE" }));

        jLabel5.setText("Trạng Thái");

        jLabel6.setText("Điều kiện áp đụng");

        jLabel7.setText("% Giảm ");

        btnKLuu.setText("K.Lưu");
        btnKLuu.setRadius(35);

        javax.swing.GroupLayout myPanelBoxShadow1Layout = new javax.swing.GroupLayout(myPanelBoxShadow1);
        myPanelBoxShadow1.setLayout(myPanelBoxShadow1Layout);
        myPanelBoxShadow1Layout.setHorizontalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addComponent(myPanelBoxShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_TenCH, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tf_giam, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(tf_DK, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)))
                        .addGap(26, 26, 26)
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(tf_maCH, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        myPanelBoxShadow1Layout.setVerticalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tf_maCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(tf_DK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_TenCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(tf_giam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(myPanelBoxShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private org.LapTrinhTienTien.ui.customItem.button btnKLuu;
    private org.LapTrinhTienTien.ui.customItem.button btnLuu;
    private org.LapTrinhTienTien.ui.customItem.button btnReload;
    private org.LapTrinhTienTien.ui.customItem.button btnSua;
    private org.LapTrinhTienTien.ui.customItem.button btnThem;
    private javax.swing.JComboBox<String> cmbTrangThai;
    private com.toedter.calendar.JDateChooser dcNgayBD;
    private com.toedter.calendar.JDateChooser dcNgayKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTittle;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow1;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow2;
    private org.LapTrinhTienTien.ui.customItem.panelBorder panelBorder1;
    private org.LapTrinhTienTien.ui.customItem.table tblKhuyenMai;
    private javax.swing.JTextField tf_DK;
    private javax.swing.JTextField tf_TenCH;
    private javax.swing.JTextField tf_giam;
    private javax.swing.JTextField tf_maCH;
    // End of variables declaration//GEN-END:variables
}
