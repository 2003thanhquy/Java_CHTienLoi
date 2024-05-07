package org.LapTrinhTienTien.service;

import org.LapTrinhTienTien.StaticApp.Global;
import org.LapTrinhTienTien.model.*;
import org.LapTrinhTienTien.repository.CuaHangSanPhamRepository;
import org.LapTrinhTienTien.repository.SanPhamRepository;
import org.LapTrinhTienTien.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuaHangSanPhamService {
    @Autowired
    CuaHangSanPhamRepository cuaHangSanPhamRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired TaiKhoanService taiKhoanService;
    final  int SEARCH_LIMIT = 4;

    public List<GioHang> searchTenSP(String search){
        List<GioHang> lstSearch = new ArrayList<GioHang>();
        CuaHang cuaHang = Global.account.getNhanVien().getCuaHang();
       List<CuaHangSanPham> cuaHangSanPhams = cuaHangSanPhamRepository.findAllByCuaHang(cuaHang);

       for (CuaHangSanPham chsp : cuaHangSanPhams) {
           SanPham sanPham = chsp.getSanPham();
           System.out.println(sanPham.getTenSP());
           if(sanPham.getTenSP().toLowerCase().contains(search.toLowerCase())){
               String tensp = sanPham.getTenSP();
               String masp = sanPham.getMaSP();
               float giaTien = sanPham.getTienThanhToan();
               String image = sanPham.getImage();
               lstSearch.add(new GioHang(masp,tensp,image,1,giaTien));
           }
           if(lstSearch.size() >=SEARCH_LIMIT) {
               return lstSearch;
           }
       }
        return lstSearch;

    }
    public Response isCheckSoLuong(String maSP,int sl){
        String maCH;
        try{
           maCH = Global.account.getNhanVien().getCuaHang().getMaCH();
        }catch (Exception e){
            return new Response("Tài khoản bị lỗi, yêu cầu login",false,null);
        }


        if(sl<0) return new Response("Kiểu dữ liệu không hợp lệ",false,null);
        CuaHangSanPham chsp =  cuaHangSanPhamRepository.findBySanPham_MaSPAndCuaHang_MaCH(maSP,maCH);
        if(chsp==null){
            return new Response("Sản Phẩm không tồn tại.",false,null);
        }
        if(chsp.getSoLuong()==0)
            return new Response("Sản phẩm đang hết hàng!!!!",false,null);
        if(chsp.getSoLuong()<sl)
            return new Response("Số lượng trong kho không đủ. kho còn lại "+ chsp.getSoLuong(),false,null);
        return new Response("Số lượn Trong kho đủ",true,null);
    }

    public Response updateSoLuong(String maSP, int soLuong) {
        String maCH;
        try{
            maCH = Global.account.getNhanVien().getCuaHang().getMaCH();
        }catch (Exception e){
            return new Response("Tài khoản bị lỗi, yêu cầu login",false,null);
        }
        Response response =  isCheckSoLuong(maSP,soLuong);
        if(!response.getFlag()){
            return  response;
        }
        // Lấy thông tin chi tiết sản phẩm trong kho hàng
        CuaHangSanPham chsp = cuaHangSanPhamRepository.findBySanPham_MaSPAndCuaHang_MaCH(maSP,maCH);
        if (chsp != null) {
            // Cập nhật số lượng sản phẩm
            int soLuongHienTai = chsp.getSoLuong();
            chsp.setSoLuong(soLuongHienTai - soLuong);
            // Lưu cập nhật vào cơ sở dữ liệu
            cuaHangSanPhamRepository.save(chsp);
            return new Response("cập nhật thành công",true,null);
        }
        return new Response("Cap nhật không thành công",false,null);
    }
}
