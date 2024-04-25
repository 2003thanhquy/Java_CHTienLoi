package org.LapTrinhTienTien.model.IdClass;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.LapTrinhTienTien.model.NhanVien;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LichLamId {

    @Column(name= "MaNV")
    private String maNV;

    @Column(name = "NgayThangNam", nullable = false)
    private LocalDate ngayThangNam;
}
