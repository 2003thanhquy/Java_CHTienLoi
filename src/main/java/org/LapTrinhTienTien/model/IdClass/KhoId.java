package org.LapTrinhTienTien.model.IdClass;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class KhoId {
    @Column(name = "MaSP")
    private String maSP;
    @Column(name = "MaCH")
    private String maCH;
}
