package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.StaticApp.Global;
import org.LapTrinhTienTien.model.ChucVu;
import jakarta.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.LapTrinhTienTien.model.CuaHang;
import org.LapTrinhTienTien.model.NhanVien;
import org.LapTrinhTienTien.model.TaiKhoan;
import org.LapTrinhTienTien.model.customModel.EmployeeSalary;
import org.LapTrinhTienTien.repository.NhanVienRepository;
import org.LapTrinhTienTien.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;


    @Transactional
    public NhanVien themNhanVien(String hoTenNV, String cccd, LocalDate ngaySinh, LocalDate ngayVaoLam, String sdt, String diaChi, String gioiTinh, String urlImage, ChucVu chucVu, CuaHang cuaHang) {
        NhanVien nhanVien = new NhanVien();
        try {
            // Xác định Mã nhân viên mới
            NhanVien lastNhanVien = nhanVienRepository.findTopByOrderByMaNVDesc();
            String lastMaNV = lastNhanVien.getMaNV().trim();
            int lastNumber = Integer.parseInt(lastMaNV.substring(4));
            String newMaNV = "NV00" + (lastNumber + 1);

            // Lưu thông tin nhân viên vào cơ sở dữ liệu
            nhanVien.setMaNV(newMaNV);
            nhanVien.setHoTenNV(hoTenNV);
            nhanVien.setCccd(cccd);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setNgayVaoLam(ngayVaoLam);
            nhanVien.setSdt(sdt);
            nhanVien.setDiaChi(diaChi);
            if(gioiTinh.equals("Nam")){
                nhanVien.setGioiTinh("Nam");
            }
            else nhanVien.setGioiTinh("Nữ");
            

            // Đường dẫn đầy đủ của tệp ảnh mới, sử dụng đường dẫn tương đối
            String newImagePath = "src/main/resources/NhanVien/" + newMaNV + ".jpg";
            
            // Copy tệp ảnh đến đường dẫn mới
            File source = new File(urlImage);
            File destination = new File(newImagePath);
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Cập nhật đường dẫn ảnh trong đối tượng nhân viên
            nhanVien.setUrlImage(newImagePath);
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            // Lưu thông tin nhân viên vào cơ sở dữ liệu
            nhanVienRepository.save(nhanVien);
             // Tạo tài khoản mới cho nhân viên
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setTaiKhoan(newMaNV); // Mã tài khoản sẽ giống với mã nhân viên mới
            taiKhoan.setMatKhau(newMaNV); // You can set a default password if needed
            taiKhoan.setNhanVien(nhanVien); // Gán nhân viên tương ứng cho tài khoản

            // Lưu thông tin tài khoản vào cơ sở dữ liệu
            taiKhoanRepository.save(taiKhoan);

       
            // Tạo tài khoản mới cho nhân viên và lưu vào cơ sở dữ liệu
            // Các thao tác tạo tài khoản ở đây

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return nhanVien;
    }


    public NhanVienService() {

    }
    public NhanVien getMaV(String manv){
        return nhanVienRepository.findByMaNV(manv);
    }
    
    public void xoaNhanVien(String maNV) {
        // Xóa nhân viên từ cơ sở dữ liệu dựa trên mã nhân viên
        NhanVien nhanVien = nhanVienRepository.findByMaNV(maNV);
        if (nhanVien != null) {
            nhanVienRepository.delete(nhanVien);
        } else {
            // Xử lý trường hợp không tìm thấy nhân viên có mã tương ứng
            // Ví dụ: thông báo lỗi hoặc xử lý khác theo logic của bạn
        }
    }
    public List<NhanVien> timNhanVienTheoTen(String tenNV) {
        return nhanVienRepository.findByHoTenNVContainingIgnoreCase(tenNV);
    }
    public List<NhanVien> findALlNhanVien() {
        List<NhanVien> lstNhanVien =  nhanVienRepository.findAll();
        String mach = Global.account.getNhanVien().getCuaHang().getMaCH();
        lstNhanVien = lstNhanVien.stream().filter(nv->nv.getCuaHang().getMaCH().equals(mach)&& nv.getTrangThai()==null).toList();

        return lstNhanVien;

    }
    public List<EmployeeSalary> findSalaryEmployeeInMonthAndYear(String manv,int month, int year) {
        List<NhanVien> lstNhanVien = findALlNhanVien();
        List<EmployeeSalary> lstEmployeeSalary = new ArrayList<>();

        List<EmployeeSalary> finalLstEmployeeSalary = lstEmployeeSalary;
        lstNhanVien.forEach(nv -> {
            EmployeeSalary employeeSalary = new EmployeeSalary();
            employeeSalary.setManv(nv.getMaNV());
            employeeSalary.setTennv(nv.getHoTenNV());
            employeeSalary.setMorning(0);
            employeeSalary.setAfternoon(0);
            employeeSalary.setEvening(0);
            employeeSalary.setTotalMoney(0);

            nv.getLichLam().forEach(lichLam -> {
                LocalDate ngayThangNam = lichLam.getId().getNgayThangNam();
                int mm = ngayThangNam.getMonthValue();
                int yyyy = ngayThangNam.getYear();

                if (mm == month && yyyy == year) {
                    String maca = lichLam.getCaLamViec().getMaCa();
                    switch (maca) {
                        case "CA001":
                            employeeSalary.setMorning(employeeSalary.getMorning() + 1);
                            break;
                        case "CA002":
                            employeeSalary.setAfternoon(employeeSalary.getAfternoon() + 1);
                            break;
                        case "CA003":
                            employeeSalary.setEvening(employeeSalary.getEvening() + 1);
                            break;
                        default:
                            break;
                    }
                    employeeSalary.setTotalMoney(employeeSalary.getTotalMoney() + lichLam.getGiaTien());
                }
            });

            finalLstEmployeeSalary.add(employeeSalary);
        });
        lstEmployeeSalary= finalLstEmployeeSalary;
        if(!manv.isEmpty()){
            lstEmployeeSalary = lstEmployeeSalary.stream().filter(es->es.getManv().equals(manv)).toList();
        }

        return lstEmployeeSalary;
    }

}
