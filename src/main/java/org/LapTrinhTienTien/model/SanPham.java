package org.LapTrinhTienTien.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name = "MaSP", length = 10)
    private String maSP;

    @Column(name = "TenSP", length = 30, nullable = false)
    private String tenSP;

    @Column(name = "NoiSanXuat", length = 100, nullable = false)
    private String noiSanXuat;

    @Column(name = "TrangThai", length = 10, nullable = false)
    private String trangThai;

    @Column(name = "TienGoc", nullable = false)
    private int tienGoc;

    @Column(name = "TienThanhToan", nullable = false)
    private int tienThanhToan;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayNhapHang", nullable = false)
    private Date ngayNhapHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="SP_NCC",referencedColumnName = "MaNCC")
    private NhaCungCap nhaCungCap;
    //them hoac khong
    @OneToOne(mappedBy="sanPham", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Kho kho;
    // Constructors, getters, and setters
}
