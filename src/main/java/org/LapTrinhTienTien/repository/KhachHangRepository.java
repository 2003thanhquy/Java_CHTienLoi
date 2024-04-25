package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.KhachHang;
import org.springframework.data.repository.CrudRepository;

public interface KhachHangRepository extends CrudRepository<KhachHang, Long> {
    KhachHang findBySdt(String sdt);
}
