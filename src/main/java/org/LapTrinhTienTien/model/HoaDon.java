package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Entity
@Data
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "MaHD", length = 10)
    private String maHD;

    @Column(name = "NgayXuat", nullable = false)
    private LocalDate ngayXuat;

    @Column(name = "GiaTri", nullable = false)
    private int giaTri;

    @Column(name = "DiemTich", nullable = false)
    private int diemTich;

    @Column(name = "DiemSuDung", nullable = false)
    private int diemSuDung;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="HD_KH",nullable = false, referencedColumnName = "id")
    private KhachHang khachHang;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name ="HD_NV",nullable = false, referencedColumnName = "MaNV")
    private NhanVien nhanVien;

    // Constructors, getters, and setters
}