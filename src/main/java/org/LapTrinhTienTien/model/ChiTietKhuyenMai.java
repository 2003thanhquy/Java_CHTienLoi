//package org.LapTrinhTienTien.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.LapTrinhTienTien.model.IdClass.ChiTietKhuyenMaiId;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "ChiTietKhuyenMai")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ChiTietKhuyenMai implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @EmbeddedId
//    private ChiTietKhuyenMaiId chiTietKhuyenMaiId;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @MapsId("maCT")
//    private ChuongTrinhKhuyenMai  chuongTrinhKhuyenMai;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @MapsId("maSP")
//    private SanPham sanPham;
//
//    // Constructors, getters, and setters
//}