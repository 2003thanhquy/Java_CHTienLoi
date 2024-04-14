package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChiTietKhuyenMai")
@Getter
@Builder
public class ChiTietKhuyenMai implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MaCT",referencedColumnName = "MaCT")
    private ChuongTrinhKhuyenMai  chuongTrinhKhuyenMai;


    @Column(name = "MaSP", length = 10)
    private String maSP;


    @Column(name = "NgayApDung", nullable = false)
    private LocalDateTime ngayApDung;

    @Column(name = "NgayKetThuc", nullable = false)
    private LocalDateTime ngayKetThuc;
    // Constructors, getters, and setters
}