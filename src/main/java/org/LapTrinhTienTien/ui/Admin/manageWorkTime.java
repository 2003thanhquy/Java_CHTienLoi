/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.LapTrinhTienTien.ui.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.LapTrinhTienTien.TableModel.LichLamTableModel;
import org.LapTrinhTienTien.model.LichLam;
import org.LapTrinhTienTien.service.LichLamService;
import org.LapTrinhTienTien.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.LapTrinhTienTien.model.CaLamViec;
import org.LapTrinhTienTien.model.IdClass.LichLamId;
import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.repository.CaLamViecRepository;
import org.LapTrinhTienTien.repository.LichLamRepository;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Hi
 */
@Controller
public class manageWorkTime extends javax.swing.JPanel {

    /**
     * Creates new form manageWorkTime
     */
    @Autowired CaLamViecRepository caLamViecRepository;
    @Autowired NhanVienRepository nhanVienRepository;
    @Autowired LichLamRepository lichLamRepository;
    @Autowired
    NhanVienService nhanVienService;
    LichLamService lichLamService;
    LichLamTableModel llTableModel;
    List<LichLam> lichLamList = new ArrayList<>();
    public manageWorkTime( @Autowired LichLamService lichLamService) {
        initComponents();
        this.lichLamService = lichLamService;
        events();
    }

    private void events() {
        btnReload.addActionListener(e -> {
            loadData();
        });
        btnTimKiem.addActionListener(e -> {
           btnTimKiemAction();
        });
        btnLuong.addActionListener(e->{
            btnLuongAction();
        });
    }
    private void btnLuongAction(){
        LuongNhanVien luongNhanVien = new LuongNhanVien(nhanVienService);
        luongNhanVien.setLocationRelativeTo(null);
        luongNhanVien.setVisible(true);
    }
    private void btnTimKiemAction() {
        String manv = tf_manv.getText()+"";
        String calv = tf_maca.getText()+"";
        LocalDate ngaybd = getSelectedDate(dcNgayBD.getDate());
        LocalDate ngaykt = getSelectedDate(dcNgayKT.getDate());
        List<LichLam> lichLams= lichLamService.timKiemLichLam(manv,calv,ngaybd,ngaykt);
        System.out.println("---ll Find--"+lichLams.size());
        llTableModel.setLstLichLams(lichLams);
        llTableModel.fireTableDataChanged();
    }
    private void loadData() {
        tf_maca.setText("");
        tf_manv.setText("");
        LocalDate ngayHienTai = LocalDate.now();
        java.sql.Date date = java.sql.Date.valueOf(ngayHienTai);
        dcNgayBD.setDate(date);
        dcNgayKT.setDate(date);
        lichLamList.clear();
        lichLamList = lichLamService.getAllLichLam();
        System.out.println("------listll----"+ lichLamList.size());
        llTableModel = new LichLamTableModel(lichLamList);
        tblLichLam.setModel(llTableModel);
    }
    public LocalDate getSelectedDate(Date date) {
        if (date != null) {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            return null;
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

        jLabel5 = new javax.swing.JLabel();
        myPanelBoxShadow1 = new org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichLam = new javax.swing.JTable();
        btnThemExcel = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        tf_manv = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dcNgayBD = new com.toedter.calendar.JDateChooser();
        tf_maca = new javax.swing.JTextField();
        dcNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnLuong = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(618, 459));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Ngày kết thúc:");

        jScrollPane1.setViewportView(tblLichLam);

        btnThemExcel.setText("Excel");
        btnThemExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemExcelActionPerformed(evt);
            }
        });

        btnReload.setText("reload");

        btnTimKiem.setText("Tìm Kiếm");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Mã NV: ");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Ca làm:");

        btnLuong.setText("Tính Lương");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Ngày bắt đầu:");

        javax.swing.GroupLayout myPanelBoxShadow1Layout = new javax.swing.GroupLayout(myPanelBoxShadow1);
        myPanelBoxShadow1.setLayout(myPanelBoxShadow1Layout);
        myPanelBoxShadow1Layout.setHorizontalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_maca, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnReload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThemExcel)
                        .addGap(91, 91, 91))
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                                .addComponent(btnTimKiem)
                                .addGap(234, 234, 234)
                                .addComponent(btnLuong))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        myPanelBoxShadow1Layout.setVerticalGroup(
            myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThemExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanelBoxShadow1Layout.createSequentialGroup()
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addComponent(dcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_maca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addComponent(dcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanelBoxShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(429, 429, 429))
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanelBoxShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemExcelActionPerformed
        // Open file dialog and select Excel file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn file Excel");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Excel", "xls", "xlsx");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                // Read data from Excel file
                FileInputStream fis = new FileInputStream(file);
                Workbook workbook = WorkbookFactory.create(fis); // Use WorkbookFactory for newer formats
                Sheet sheet = workbook.getSheetAt(0);

                // Iterate through rows in the sheet
                for (Row row : sheet) {
                    if (isRowEmpty(row)) {
                        System.out.println("Dòng rỗng");
                        continue; // Skip empty rows
                    }

                    // Extract data from specific columns
                    String maCa = row.getCell(0).getStringCellValue().trim();
                    String maNV = row.getCell(1).getStringCellValue().trim();
                    LocalDate ngay = LocalDate.parse(row.getCell(2).getStringCellValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    String giatienStr = row.getCell(3).getStringCellValue();
                    float giatien = Float.parseFloat(giatienStr);
                    // Create LichLam object and validate data
                    LichLam lichLam = new LichLam();
                    CaLamViec caLamViec = caLamViecRepository.findByMaCa(maCa);
                    NhanVien nhanVien = nhanVienRepository.findByMaNV(maNV);
                    if (caLamViec == null || nhanVien == null) {
                        System.out.println("Mã ca hoặc mã nhân viên không hợp lệ: " + row.getRowNum());
                        continue; // Skip invalid rows
                    }

                    lichLam.setId(new LichLamId(nhanVien.getMaNV(), ngay));
                    lichLam.setGiaTien(giatien);
                    lichLam.setCaLamViec(caLamViec);
                    lichLam.setNhanVien(nhanVien);

                    // Save LichLam object to database
                    lichLamRepository.save(lichLam);
                }

                // Close file input stream
                fis.close();

                // Reload data on the work schedule table
                loadData();

                // Display success message
                JOptionPane.showMessageDialog(this, "Thêm lịch làm từ file Excel thành công!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ trong file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemExcelActionPerformed
    private boolean isRowEmpty(Row row) {
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false; // Dòng không rỗng
            }
        }
        return true; // Dòng rỗng
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuong;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnThemExcel;
    private javax.swing.JButton btnTimKiem;
    private com.toedter.calendar.JDateChooser dcNgayBD;
    private com.toedter.calendar.JDateChooser dcNgayKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.LapTrinhTienTien.ui.customItem.MyPanelBoxShadow myPanelBoxShadow1;
    private javax.swing.JTable tblLichLam;
    private javax.swing.JTextField tf_maca;
    private javax.swing.JTextField tf_manv;
    // End of variables declaration//GEN-END:variables
}
