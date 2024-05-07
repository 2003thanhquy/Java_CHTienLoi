package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.ChiTietHoaDon;
import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.model.IdClass.ChiTietHoaDonId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ChiTietHoaDonRepository extends CrudRepository<ChiTietHoaDon, ChiTietHoaDonId> {
    List<ChiTietHoaDon> findAllByHoaDon(HoaDon hoaDon);
}
