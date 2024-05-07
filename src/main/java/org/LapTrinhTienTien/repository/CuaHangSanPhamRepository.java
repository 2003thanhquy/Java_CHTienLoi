package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.CuaHangSanPham;
import org.LapTrinhTienTien.model.IdClass.CuaHangSanPhamKey;
import org.LapTrinhTienTien.model.KhachHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuaHangSanPhamRepository extends CrudRepository<CuaHangSanPham, CuaHangSanPhamKey> {
    List<CuaHangSanPham> findAll();
}
