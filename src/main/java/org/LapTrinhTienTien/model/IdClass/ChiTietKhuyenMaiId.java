package org.LapTrinhTienTien.model.IdClass;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ChiTietKhuyenMaiId implements Serializable {

    @Column(name = "MaCT")
    private String maCT;

    @Column(name = "MaSP", length = 10)
    private String maSP;
}
