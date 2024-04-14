package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.LapTrinhTienTien.repository.HoaDonRepository;

import java.util.Set;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CTHD_SP",referencedColumnName = "MaSP")
    private SanPham sanPham;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CTHD_CH",referencedColumnName = "MaCH")
    private CuaHang cuaHang;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CTHD_HO",referencedColumnName = "MaHD")
    private HoaDon hoaDon;

    @Column(name = "GiaThanhToan", nullable = false)
    private int giaThanhToan;


    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

    @Column(name = "TongTien", nullable = false)
    private int tongTien;

    // Constructors, getters, and setters
}