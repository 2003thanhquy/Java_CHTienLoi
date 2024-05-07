package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    public HoaDon getHoaDon(String maHD){
        return hoaDonRepository.findByMaHD(maHD);
    }
    public List<HoaDon> getAllHoaDon(){
        return (List<HoaDon>) hoaDonRepository.findAll();
    }

    public HoaDon saveHoaDon(HoaDon hoaDon){
        return hoaDonRepository.save(hoaDon);
    }

    public String generateMaHD() {
        String prefix = "HD";
        String generatedId = null;
        int maxId = 0;

        // Tìm mã HoaDon lớn nhất trong cơ sở dữ liệu
        Optional<HoaDon> maxHoaDon = hoaDonRepository.findFirstByOrderByMaHDDesc();

        if (maxHoaDon.isPresent()) {
            String lastMaHD = maxHoaDon.get().getMaHD();
            // Lấy phần số tự tăng từ mã HoaDon cuối cùng
            String numericPart = lastMaHD.substring(prefix.length());
            // Chuyển phần số tự tăng thành số nguyên
            maxId = Integer.parseInt(numericPart);
        }

        // Tạo mã HoaDon mới với số tự tăng tăng lên 1
        generatedId = prefix + String.format("%03d", maxId + 1);

        return generatedId;
    }

}
