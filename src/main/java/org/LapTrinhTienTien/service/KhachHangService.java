package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.TaiKhoan;
import org.LapTrinhTienTien.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService {
    @Autowired
    TaiKhoanRepository khRepository;
    public Iterable<TaiKhoan> getAllKhachHang() {
        return khRepository.findAll();
    }
}
