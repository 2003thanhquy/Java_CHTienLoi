package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "Kho")
@Builder
@Getter
public class Kho  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CH_Kho", nullable = false,referencedColumnName = "MaCH")
    private CuaHang cuaHang;

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CH_SP", nullable = false,referencedColumnName = "MaSP")
    private SanPham sanPham;

    @NotNull
    @Column(name = "TenKho", length = 100)
    private String tenKho;

    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;

    // Constructors, getters, and setters
}
