package org.LapTrinhTienTien.repository;
import org.LapTrinhTienTien.model.HoaDon;
import org.springframework.data.repository.CrudRepository;

public interface HoaDonRepository extends CrudRepository<HoaDon,String> {
    HoaDon findByMaHD(String maHD);

}
