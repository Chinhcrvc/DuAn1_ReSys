/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.entity;

/**
 *
 * @author buian
 */
public class Ban {
    private String maBan;
    private String moTa;

    public Ban() {
    }

    public Ban(String maBan, String moTa) {
        this.maBan = maBan;
        this.moTa = moTa;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
        
}
