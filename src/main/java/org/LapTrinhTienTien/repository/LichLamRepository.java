package org.LapTrinhTienTien.repository;

import org.LapTrinhTienTien.model.IdClass.LichLamId;
import org.LapTrinhTienTien.model.LichLam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichLamRepository  extends CrudRepository<LichLam, LichLamId> {

}
