package org.LapTrinhTienTien.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CaLamViec")
@Setter
@Getter
@NoArgsConstructor
public class CaLamViec {
    @Id
    @Column(name = "MaCa", length = 10)
    private String maCa;

    @Column(name = "GioBatDau", nullable = false, unique = true)
    private LocalDateTime gioBatDau;

    @Column(name = "GiaKetThuc", nullable = false, unique = true)
    private LocalDateTime giaKetThuc;

    @Column(name = "PhanTramThuongThem", nullable = false)
    private int phanTramThuongThem;

    // Constructors, getters, and setters
}