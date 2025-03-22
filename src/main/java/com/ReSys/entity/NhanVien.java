/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.entity;

/**
 *
 * @author maing
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private String matKhau;
    private boolean vaiTro;
    private boolean tinhtrang;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String matKhau, boolean vaiTro, boolean tinhTrang) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.tinhtrang = tinhTrang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhtrang = tinhTrang;
    }

    public boolean isTinhTrang() {
        return tinhtrang;
    }

    @Override
    public String toString() {
        return this.hoTen;
    }

}
