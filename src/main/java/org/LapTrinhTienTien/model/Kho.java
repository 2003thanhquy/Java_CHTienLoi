package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.*;
import org.LapTrinhTienTien.model.IdClass.KhoId;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Kho")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Kho  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private KhoId khoId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("maCH")
    private CuaHang cuaHang;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("maSP")
    private SanPham sanPham;

    @NotNull
    @Column(name = "TenKho", length = 100)
    private String tenKho;

    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;

    // Constructors, getters, and setters
}
