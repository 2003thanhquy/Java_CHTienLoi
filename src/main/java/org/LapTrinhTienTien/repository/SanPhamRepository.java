package org.LapTrinhTienTien.repository;

import java.util.List;
import org.LapTrinhTienTien.model.SanPham;
import org.springframework.data.repository.CrudRepository;

public interface SanPhamRepository extends CrudRepository<SanPham,String> {
    SanPham findByMaSP(String maSP);
    List<SanPham> findAll();
    List<SanPham> findByTenSPContainingIgnoreCase(String tenNV);
}
