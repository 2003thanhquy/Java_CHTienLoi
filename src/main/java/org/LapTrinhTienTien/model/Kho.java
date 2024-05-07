//package org.LapTrinhTienTien.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.LapTrinhTienTien.model.IdClass.KhoId;
//import org.antlr.v4.runtime.misc.NotNull;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "Kho")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Kho  implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "MaCH")
//    private CuaHang cuaHang;
//
//    // Other fields...
//
//    @OneToMany(mappedBy = "kho",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<KhoSanPham> sanPhamKhoSet = new HashSet<>();
//
//    @NotNull
//    @Column(name = "TenKho", length = 100)
//    private String tenKho;
//
//    // Constructors, getters, and setters
//}
