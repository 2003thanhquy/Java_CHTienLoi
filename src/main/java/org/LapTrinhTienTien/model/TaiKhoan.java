package org.LapTrinhTienTien.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "TaiKhoan", length = 30,unique=true)
    private String taiKhoan;

    @Column(name = "MatKhau", length = 30)
    private String matKhau;
//

    @OneToOne
    @JoinColumn(name = "Tk_NV",referencedColumnName = "MaNV")

    private NhanVien nhanVien;

    // Constructors, getters, and setters
}
