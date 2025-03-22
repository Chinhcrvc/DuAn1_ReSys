/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.entity;

/**
 *
 * @author maing
 */
public class HoaDonChiTiet {
    private int maHDCT;
    private int maHD;
    private String maMon;
    private int soLuong;
    private String ghiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int maHDCT, int maHD, String maMon, int soLuong, String ghiChu) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maMon = maMon;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
