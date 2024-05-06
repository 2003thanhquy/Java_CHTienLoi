/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.LapTrinhTienTien.model;

/**
 *
 * @author quyth
 */
public class GioHang {
    String maSP;
    String tenSP;
    String image;
    int soLuong;
    float giaTien;
    float tongTien;

    public GioHang(String maSP, int soLuong, float giaTien) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        setTongTien(); // Gọi phương thức tính tổng tiền khi khởi tạo sản phẩm
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        setTongTien();
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public float getTongTien() {
        return tongTien;
    }

    // Cập nhật phương thức tính tổng tiền
    public void setTongTien() {
        this.tongTien = soLuong * giaTien;
    }
}
