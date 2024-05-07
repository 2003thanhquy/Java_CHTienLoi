/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.LapTrinhTienTien.service;

import jakarta.transaction.Transactional;

import org.LapTrinhTienTien.model.NhaCungCap;
import org.LapTrinhTienTien.repository.NhaCungCapRepository;
import org.LapTrinhTienTien.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class NhaCungCapService {
    
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    
    
    @Transactional
    public Response addNCC(String tenNCC, String diaChi, String sdt) {
        if(!checkEmpty(tenNCC, diaChi, sdt)) {
            //JOptionPane.showMessageDialog(null, "Họ tên và số điện thoại không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new Response("Ho ten, dia chi va so dien thoai khong duoc de trong", false, null);
        }
        if (!isValidPhoneNumber(sdt)) {
            return new Response("Số điện thoại không hợp lệ", false, null);
        }
        return new Response("Them thanh cong", true, null);
    }
    public void updateNCC(String maNCC, String tenNCC, String diaChi, String sdt)
    {
        NhaCungCap ncc = nhaCungCapRepository.findById(maNCC).orElse(null);
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setSdt(sdt);
        
        nhaCungCapRepository.save(ncc);
    }
    private boolean checkEmpty(String name, String diaChi, String sdt)
        {
            return !name.isEmpty() && !diaChi.isEmpty() && !sdt.isEmpty();
        }

    private boolean isValidPhoneNumber(String sdt) {
        // Kiểm tra xem số điện thoại có đúng độ dài 10 ký tự không
        if (sdt.length() != 10) {
            return false;
        }

        // Kiểm tra xem số điện thoại có bắt đầu bằng số 0 không và có chứa toàn bộ ký tự số không
        return sdt.matches("^0\\d+$");
    }
}
