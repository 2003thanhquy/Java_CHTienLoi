package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien._enum.ChucVuEnum;
import org.LapTrinhTienTien.model.ChucVu;
import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.LapTrinhTienTien.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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
