/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.repository.KhoSanPhamRepository;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class KhoSanPhamService {
    @Autowired
    private KhoSanPhamRepository khoSanPhamRepository;
    
}
