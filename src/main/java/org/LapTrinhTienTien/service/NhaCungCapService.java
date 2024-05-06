/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.LapTrinhTienTien.service;

import jakarta.transaction.Transactional;
import org.LapTrinhTienTien.model.KhachHang;
import org.LapTrinhTienTien.model.NhaCungCap;
import org.LapTrinhTienTien.repository.NhaCungCapRepository;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class NhaCungCapService {
    
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    
    
    @Transactional
    public NhaCungCap addNCC(String tenNCC, String diaChi, String sdt) {
        NhaCungCap ncc = new NhaCungCap();
        try {
            // Xác định Mã nhà cung cấp mới
            NhaCungCap lastNCC = nhaCungCapRepository.findTopByOrderByMaNCCDesc();
            String lastMaNCC = lastNCC.getMaNCC().trim();
            int lastNumber = Integer.parseInt(lastMaNCC.substring(4));
            String newMaNCC = "NCC" + (lastNumber + 1);
            
            // Lưu thông tin nhà cung cấp vào đối tượng
            ncc.setMaNCC(newMaNCC);
            ncc.setTenNCC(tenNCC);
            ncc.setDiaChi(diaChi);
            ncc.setSdt(sdt);
            
            // Lưu thông tin nhà cung cấp vào cơ sở dữ liệu
            nhaCungCapRepository.save(ncc);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return ncc;
    }
    public void updateNCC(String maNCC, String tenNCC, String diaChi, String sdt)
    {
        NhaCungCap ncc = nhaCungCapRepository.findById(maNCC).orElse(null);
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setSdt(sdt);
        
        nhaCungCapRepository.save(ncc);
    }
}
