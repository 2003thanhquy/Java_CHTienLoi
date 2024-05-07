package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "MaHD", length = 10)
    private String maHD;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "maCH",nullable = false)
    private CuaHang cuaHang;

    @Column(name = "NgayXuat", nullable = false)
    private LocalDateTime ngayXuat;

    @Column(name = "TongHoaDon")
    private float giaTri;

    @Column(name = "ThanhTien")
    private float ThanhTien;
    @Column(name = "MaKhuyenMai",nullable = true)
    private String maKhuyenMai;

    @Column(name = "DiemTich", nullable = false)
    private int diemTich;

    @Column(name = "DiemSuDung", nullable = true)
    private int diemSuDung;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="HD_KH",nullable = true, referencedColumnName = "id")
    private KhachHang khachHang;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name ="HD_NV",nullable = false, referencedColumnName = "MaNV")
    private NhanVien nhanVien;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<ChiTietHoaDon> chiTietHoaDon= new HashSet<>();

    // Constructors, getters, and setters
}