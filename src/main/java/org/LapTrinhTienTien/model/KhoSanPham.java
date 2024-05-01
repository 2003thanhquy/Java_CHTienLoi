//package org.LapTrinhTienTien.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//import java.io.Serializable;
//
//@Entity
//@Table(name = "Kho_SanPham")
//@Getter
//@Setter
//@NoArgsConstructor
//public class KhoSanPham implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "maSP", referencedColumnName = "MaSP")
//    private SanPham sanPham;
//
//    @ManyToOne
//    @JoinColumn(name = "maCH", referencedColumnName = "MaCH")
//    private Kho kho;
//
//    @Column(name = "soLuong")
//    private int soLuong;
//}
