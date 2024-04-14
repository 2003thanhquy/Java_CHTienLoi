package org.LapTrinhTienTien.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "LichLam")
@Getter
@Setter
@NoArgsConstructor
public class LichLam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name = "LL_NV",referencedColumnName = "MaNV")
    private NhanVien nhanVien;
    @Id
    @Column(name = "NgayThangNam", nullable = false)
    private LocalDate ngayThangNam;

    @Column(name = "MaCa", length = 10)
    private String maCa;

    // Constructors, getters, and setters
}
