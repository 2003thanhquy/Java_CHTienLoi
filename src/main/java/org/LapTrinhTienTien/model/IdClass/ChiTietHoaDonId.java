package org.LapTrinhTienTien.model.IdClass;

import jakarta.persistence.*;
import org.LapTrinhTienTien.model.CuaHang;
import org.LapTrinhTienTien.model.HoaDon;
import org.LapTrinhTienTien.model.SanPham;

import java.io.Serializable;
@Embeddable
public class ChiTietHoaDonId implements Serializable {

    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "MaCH")
    private String maCH;

    @Column(name = "MaHD")
    private String maHD;
}
