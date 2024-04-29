package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
