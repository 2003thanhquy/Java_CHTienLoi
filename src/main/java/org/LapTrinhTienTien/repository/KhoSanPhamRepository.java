package org.LapTrinhTienTien.repository;

import java.util.List;
import org.LapTrinhTienTien.model.KhoSanPham;
import org.springframework.data.repository.CrudRepository;

public interface KhoSanPhamRepository extends CrudRepository<KhoSanPham, Long> {
    /*
    KhoSanPham findByMaSP(String maSP);
    List<KhoSanPham> findAll();
    List<KhoSanPham> findByTenSPContainingIgnoreCase(String tenNV);
    KhoSanPham findTopByOrderByMaSPDesc();
*/
}
