package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.SanPham;
import org.springframework.data.repository.CrudRepository;

public interface SanPhamRepository extends CrudRepository<SanPham,String> {
    SanPham findByMaSP(String maSP);
}