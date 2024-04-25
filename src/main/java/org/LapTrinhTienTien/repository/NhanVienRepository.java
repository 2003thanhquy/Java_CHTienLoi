package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.NhanVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends CrudRepository<NhanVien,String> {
    NhanVien findByMaNV(String maNV);
}
