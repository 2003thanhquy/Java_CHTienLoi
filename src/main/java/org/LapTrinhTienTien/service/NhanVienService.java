package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public NhanVienService() {

    }
    public NhanVien getMaV(String manv){
        return nhanVienRepository.findByMaNV(manv);
    }
}
