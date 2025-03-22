/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.entity;

/**
 *
 * @author maing
 */
public class DanhMuc {
    private String MaDM;
    private String TenDM;
    private String MoTa;

    public DanhMuc() {
    }

    public DanhMuc(String MaDM, String TenDM, String MoTa) {
        this.MaDM = MaDM;
        this.TenDM = TenDM;
        this.MoTa = MoTa;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }

    public String getTenDM() {
        return TenDM;
    }

    public void setTenDM(String TenDM) {
        this.TenDM = TenDM;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return this.TenDM;
    }
    
}
