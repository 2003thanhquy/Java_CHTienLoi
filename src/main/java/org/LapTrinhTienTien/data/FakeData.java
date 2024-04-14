package org.LapTrinhTienTien.data;

import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FakeData   implements CommandLineRunner{
    private final NhanVienRepository nhanVienRepository;
    @Autowired
    public  FakeData(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        insertNhanVien();

    }
    private  void insertNhanVien(){
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV("NV002");
            nhanVien.setHoTenNV("John Doe");
            nhanVien.setNgaySinh(LocalDate.of(1990, 5, 15));
            nhanVien.setNgayVaoLam(LocalDate.now());
            nhanVien.setSdt("1234567890");
            nhanVien.setDiaChi("123 Street, City");
            nhanVien.setCccd("123456789012");
            nhanVien.setGioiTinh("Male");
            nhanVien.setUrlImage("https://example.com/image.jpg");


//            List<NhanVien>  lst =(List<NhanVien>) nhanVienRepository.findAll();
//            lst.forEach(nv -> System.out.println(nv.getChucVu().getMaCV()));
//            ChucVu chucVu = (ChucVu) chucVuRepository.findByMaCV(ChucVuEnum.NHAN_VIEN.getMaCV());

//            // You can set other properties as needed
//
//            HoaDon   hoaDon = new HoaDon();
//            hoaDon.setMaHD("HD002");
//            hoaDon.setNgayXuat(LocalDate.now());
//            hoaDon.setGiaTri(100); // Giả sử giá trị hóa đơn là 100
//            hoaDon.setDiemTich(10); // Giả sử số điểm tích là 10
//            hoaDon.setDiemSuDung(5); // Giả sử số điểm sử dụng là 5
//            nhanVien.setHonDon(new HashSet<HoaDon>());
//            nhanVien.getHonDon().add(hoaDon);
//            hoaDon.setNhanVien(nhanVien);
//            nhanVienRepository.save(nhanVien);

//            NhanVien nvhd = nhanVienRepository.findByMaNV("NV001");
//            hoaDon.setNhanVien(nvhd);
        // Assuming you have a ChucVu object for this employee, set it accordingly
//            ChucVu chucVu = new ChucVu();
//            Ch
//            chucVu.setMaCV("CV001");
//            nhanVien.setChucVu(chucVu);
//            ChucVuEnum chucVu = ChucVuEnum.NHAN_VIEN;
//            ChucVu chucVu1 = new ChucVu(chucVu);

        // Save the NhanVien object using the repository
//       nhanVien.setChucVu(chucVu1);
//            nhanVienRepository.save(nhanVien);

//            HoaDon hoaDon = new HoaDon();

//            // Thiết lập các thuộc tính cho đối tượng HoaDon
//            hoaDon.setMaHD("HD001");
//            hoaDon.setNgayXuat(LocalDate.now());
//            hoaDon.setGiaTri(100); // Giả sử giá trị hóa đơn là 100
//            hoaDon.setDiemTich(10); // Giả sử số điểm tích là 10
//            hoaDon.setDiemSuDung(5); // Giả sử số điểm sử dụng là 5
//            NhanVien nvhd = nhanVienRepository.findByMaNV("NV001");
//            hoaDon.setNhanVien(nvhd);
//            //nvhd.setHonDon(hoaDon);
//            // Lưu đối tượng HoaDon vào cơ sở dữ liệu
//            hoaDonRepository.save(hoaDon);
        //NhanVien nvhd = nhanVienRepository.findByMaNV("NV001");
//            NhanVien nvhd = nhanVienRepository.findByMaNV("NV001");
//            nvhd.getHonDon().forEach(hd->System.out.println(hd.getMaHD()));


    }
}
