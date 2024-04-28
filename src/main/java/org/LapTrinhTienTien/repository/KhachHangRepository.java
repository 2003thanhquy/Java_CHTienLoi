package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.KhachHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KhachHangRepository extends CrudRepository<KhachHang, Long> {
    KhachHang findBySdt(String sdt);
    //KhachHang getAllByHoTenKH(String Hoten);
    List<KhachHang> findAll();

}
