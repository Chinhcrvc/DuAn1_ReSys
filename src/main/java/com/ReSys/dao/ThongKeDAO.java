/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getThongKeDoanhThuTheoNgay(Integer Nam, Integer Thang) {
        String sql = "{CALL sp_ThongKeTheoNgay(?, ?)}";
        String[] cols = {"Ngay", "SoLuotKhach", "HoaDonThapNhat", "HoaDonCaoNhat", "HoaDonTrungBinh", "TongDoanhThu"};
        return getListOfArray(sql, cols, Nam, Thang);
    }

    public List<Object[]> getThongKeDoanhThuTheoThang(Integer Nam) {
        String sql = "{CALL sp_ThongKeTheoThang(?)}";
        String[] cols = {"Thang", "SoLuotKhach", "HoaDonThapNhat", "HoaDonCaoNhat", "HoaDonTrungBinh", "TongDoanhThu"};
        return getListOfArray(sql, cols, Nam);
    }

    public List<Object[]> getThongKeDoanhThuTheoNam() {
        String sql = "{CALL sp_ThongKeTheoNam}";
        String[] cols = {"Nam", "SoLuotKhach", "HoaDonThapNhat", "HoaDonCaoNhat", "HoaDonTrungBinh", "TongDoanhThu"};
        return getListOfArray(sql, cols);
    }

    public List<Object[]> getThongKeSoLuongMon(Integer Nam, Integer Thang, Integer Ngay) {
        String sql = "{CALL sp_ThongKeSoLuongMonTheoNgay(?, ?, ?)}";
        String[] cols = {"MaMonAn", "TenDanhMuc", "TenMonAn", "SoLuongBanDuoc"};
        return getListOfArray(sql, cols, Nam, Thang, Ngay);
    }

    public List<Object[]> getThongKeHoaDon() {
        String sql = "{CALL sp_ThongKeHoaDon}";
        String[] cols = {"MaHD", "MaBan", "MaNV", "NgayGio", "TrangThai", "TongTien"};
        List<Object[]> data = getListOfArray(sql, cols);
        for (Object[] row : data) {
            boolean trangThai =  (boolean) row[4]; // Lấy giá trị TrangThai
            if (trangThai == true) {
                row[4] = "Đã Thanh Toán"; // Hoặc "Đã Thanh Toán"
            } else {
                row[4] = "Chưa Thanh Toán"; // Hoặc "Chưa Thanh Toán"
            }
        }
        return data;
    }

    public List<Object[]> getHDCT(String ban) {
        String sql = "{CALL sp_hdct(?)}";
        String[] cols = {"MaHDCT","MaHD","TenMon", "SoLuong", "ThanhTien","GhiChu"};
        return getListOfArray(sql, cols, ban);
    }
    public List<Object[]> getHDCTTheoMaHD(int maHD) {
        String sql = "{CALL sp_hdctTheoMaHoaDon(?)}";
        String[] cols = {"MaHDCT","TenMon","SoLuong","DonGia", "ThanhTien"};
        return getListOfArray(sql, cols, maHD);
    }
     public List<Object[]> getHDCTTheoMaHD2(int maHD) {
        String sql = "{CALL sp_hdctTheoMaHoaDon(?)}";
        String[] cols = {"TenMon","SoLuong","DonGia", "ThanhTien"};
        return getListOfArray(sql, cols, maHD);
    }
}
