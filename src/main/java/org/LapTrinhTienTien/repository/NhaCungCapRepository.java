package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.NhaCungCap;
import org.springframework.data.repository.CrudRepository;

public interface NhaCungCapRepository extends CrudRepository<NhaCungCap, String> {
    NhaCungCap findByMaNCC(String nhaCungCap);
}
