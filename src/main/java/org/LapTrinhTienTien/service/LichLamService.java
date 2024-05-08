package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.LichLam;
import org.LapTrinhTienTien.repository.LichLamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.LapTrinhTienTien.model.IdClass.LichLamId;

@Service
public class LichLamService {
    
    private final LichLamRepository lichLamRepository;

    
    public LichLamService(@Autowired LichLamRepository lichLamRepository) {
        this.lichLamRepository = lichLamRepository;
    }

    public List<LichLam> findLichLamByMaCa(String maCaLamViec) {
      //  return lichLamRepository.findByCaLamViecMaCaLamViec(maCaLamViec);
      return null;
    }

    public List<LichLam> findLichLamByNgayThangNam(List<LichLam> danhSachLichLam, LocalDate ngayThangNam) {
        return danhSachLichLam.stream()
                .filter(lichLam -> lichLam.getId().getNgayThangNam().equals(ngayThangNam))
                .collect(Collectors.toList());
    }

    public String findMaNVByMaCaAndNgayThangNam(String maCaLamViec, LocalDate ngayThangNam) {
        List<LichLam> danhSachLichLam = findLichLamByMaCa(maCaLamViec);
        List<LichLam> lichLamTheoNgayThangNam = findLichLamByNgayThangNam(danhSachLichLam, ngayThangNam);
        return lichLamTheoNgayThangNam.isEmpty() ? null : lichLamTheoNgayThangNam.get(0).getId().getMaNV();
    }
}