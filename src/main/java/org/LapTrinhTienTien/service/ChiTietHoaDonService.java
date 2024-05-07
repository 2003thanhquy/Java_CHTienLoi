package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.model.ChiTietHoaDon;
import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.repository.ChiTietHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietHoaDonService {
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

    public List<ChiTietHoaDon> getListCTHD(HoaDon hoaDon){
        return chiTietHoaDonRepository.findAllByHoaDon(hoaDon);
    }
    public void thongKeToanTgian(List<ChiTietHoaDon> chiTietHd, String maSP) {
        int totalQuantity = 0;

        for (ChiTietHoaDon chiTiet : chiTietHd) {
            if (chiTiet.getSanPham().getMaSP().equals(maSP)) {
                totalQuantity += chiTiet.getSoLuong();
            }
        }

        System.out.println("Mã sản phẩm " + maSP + ": Tổng số lượng = " + totalQuantity);
    }

}
