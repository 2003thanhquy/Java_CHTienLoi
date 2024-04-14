package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "ChuongTrinhKhuyenMai")
@Setter
@Getter
@NoArgsConstructor
public class ChuongTrinhKhuyenMai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaCT", length = 10)
    private String maCT;

    @Column(name = "TenChuongTrinh", length = 100, nullable = false)
    private String tenChuongTrinh;

    @Column(name = "PhanTramGiamGia", nullable = false)
    private Integer phanTramGiamGia;
    @OneToOne(mappedBy = "chuongTrinhKhuyenMai",cascade = CascadeType.ALL)
    private ChiTietKhuyenMai chiTietKhuyenMai;
    // Constructors, getters, and setters
}
