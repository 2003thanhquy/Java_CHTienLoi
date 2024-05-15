/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.LapTrinhTienTien.ui.Admin;

import lombok.Setter;
import org.LapTrinhTienTien.TableModel.EmployeeSalaryViecTableModel;
import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.model.customModel.EmployeeSalary;
import org.LapTrinhTienTien.service.NhanVienService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author quyth
 */
public class LuongNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form LuongNhanVien
     */
    @Setter
    private NhanVienService nhanVienService;
    EmployeeSalaryViecTableModel employeeSalaryViecTableModel;
    public LuongNhanVien(NhanVienService nhanVienService) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.nhanVienService = nhanVienService;
        NhanVien nv = nhanVienService.getMaV("NV001");
        System.out.println(nv.getLichLam().size());
        loadData();
        events();
    }

    private void events() {
        btnLoad.addActionListener(e -> {
            loadData();
        });
        btnThoat.addActionListener(e -> {
            this.dispose();
        });
        btnXuatExcel.addActionListener(e -> {
           btnXuatExcelAction();
        });
        btnTimKiem.addActionListener(e -> {
            btnTimKiemAction();
        });

    }

    private void btnTimKiemAction() {
        try {
            String thangStr = tf_thang.getText();
            String namStr = tf_nam.getText();
            String manv = tf_manv.getText()+"";

            int month = Integer.parseInt(thangStr);
            int year = Integer.parseInt(namStr);

            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Tháng phải nằm trong khoảng từ 1 đến 12.");
            }
            if (year < 1900 || year > LocalDate.now().getYear()) {
                throw new IllegalArgumentException("Năm không hợp lệ.");
            }

            List<EmployeeSalary> employerSalaries = nhanVienService.findSalaryEmployeeInMonthAndYear(manv,month, year);

             displayResults(employerSalaries);

        } catch (NumberFormatException e) {

            showErrorDialog("Vui lòng nhập tháng và năm hợp lệ.");
        } catch (IllegalArgumentException e) {

            showErrorDialog(e.getMessage());
        } catch (Exception e) {

            e.printStackTrace();
            showErrorDialog("Đã xảy ra lỗi khi tìm kiếm. Vui lòng thử lại.");
        }
    }

    // Placeholder method to display the results
    private void displayResults(List<EmployeeSalary> employerSalaries) {
        employeeSalaryViecTableModel.setLstEmployeeSalarys(employerSalaries);
        employeeSalaryViecTableModel.fireTableDataChanged();
    }

    // Placeholder method to show error messages
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }


    private void btnXuatExcelAction() {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Salaries");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Mã NV", "Tên NV", "Ca Sáng", "Ca Chiều", "Ca Tối", "Tổng Tiền"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // Populate data rows
        List<EmployeeSalary> employeeSalaries = employeeSalaryViecTableModel.getLstEmployeeSalarys();
        int rowNum = 1;
        for (EmployeeSalary salary : employeeSalaries) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(salary.getManv());
            row.createCell(1).setCellValue(salary.getTennv());
            row.createCell(2).setCellValue(salary.getMorning());
            row.createCell(3).setCellValue(salary.getAfternoon());
            row.createCell(4).setCellValue(salary.getEvening());
            row.createCell(5).setCellValue(salary.getTotalMoney());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        String desktopPath = System.getProperty("user.home") + "/Desktop/";

        // Ghi dữ liệu ra file
        String filePath = desktopPath + "EmployeeSalaries-"+tf_thang.getText()+"/"+tf_nam.getText()+".xls"; // Đường dẫn tới file trên Desktop
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) { // Thay đổi phần mở rộng thành .xls
            workbook.write(fileOut);
        } catch (IOException e) {
            showErrorDialog("Đã xảy ra lỗi khi xuất dữ liệu ra Excel. Vui lòng thử lại.");
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(null, "Dữ liệu đã được xuất thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void loadData() {
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue() - 1;
        int year = currentDate.getYear();
        tf_manv.setText("");
        tf_thang.setText(month+"");
        tf_nam.setText(year+"");
        List<EmployeeSalary> employerSalaries = nhanVienService.findSalaryEmployeeInMonthAndYear("",month, year);
        employeeSalaryViecTableModel = new EmployeeSalaryViecTableModel(employerSalaries);
        tblLuongNhanVien.setModel(employeeSalaryViecTableModel);
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
        tblLuongNhanVien = new javax.swing.JTable();
        tf_thang = new javax.swing.JTextField();
        tf_nam = new javax.swing.JTextField();
        btnLoad = new org.LapTrinhTienTien.ui.customItem.button();
        btnThoat = new org.LapTrinhTienTien.ui.customItem.button();
        btnXuatExcel = new org.LapTrinhTienTien.ui.customItem.button();
        btnTimKiem = new org.LapTrinhTienTien.ui.customItem.button();
        tf_manv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(tblLuongNhanVien);

        tf_thang.setToolTipText("Tháng");

        tf_nam.setToolTipText("năm");

        btnLoad.setText("Reload");

        btnThoat.setText("Thoát");

        btnXuatExcel.setText("Xuất Excel");

        btnTimKiem.setText("Tìm Kiếm");

        tf_manv.setToolTipText("mã nhân viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tf_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tf_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tf_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(LuongNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LuongNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LuongNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LuongNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new LuongNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.LapTrinhTienTien.ui.customItem.button btnLoad;
    private org.LapTrinhTienTien.ui.customItem.button btnThoat;
    private org.LapTrinhTienTien.ui.customItem.button btnTimKiem;
    private org.LapTrinhTienTien.ui.customItem.button btnXuatExcel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLuongNhanVien;
    private javax.swing.JTextField tf_manv;
    private javax.swing.JTextField tf_nam;
    private javax.swing.JTextField tf_thang;
    // End of variables declaration//GEN-END:variables
}
