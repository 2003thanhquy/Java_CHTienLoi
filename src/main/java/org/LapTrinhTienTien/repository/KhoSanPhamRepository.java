package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.KhachHang;
import org.LapTrinhTienTien.model.KhoSanPham;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KhoSanPhamRepository extends CrudRepository<KhoSanPham, Long> {
    List<KhoSanPham> findAll();
}
