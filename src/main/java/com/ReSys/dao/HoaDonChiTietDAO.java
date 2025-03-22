/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.entity.HoaDon;
import com.ReSys.entity.HoaDonChiTiet;
import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maing
 */
public class HoaDonChiTietDAO extends ReSysDAO<HoaDonChiTiet, String> {

    final String INSERT_SQL = "insert into ChiTietHoaDon values (?,?,?,?)";
    final String UPDATE_SQL = "update ChiTietHoaDon Set SoLuong=?,GhiChu=? where MaHDCT = ?";
    final String DELETE_SQL = "delete from ChiTietHoaDon where MaHDCT =?";
    final String SELECT_BY_ID_SQL = "select * from ChiTietHoaDon where MaHDCT = ?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaHD(), entity.getMaMon(), entity.getSoLuong(), entity.getGhiChu());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSoLuong(), entity.getGhiChu(), entity.getMaHDCT());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTiet selectByID(String id) {
         List<HoaDonChiTiet> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
         List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getInt("MaHDCT"));
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setMaMon(rs.getString("MaMon"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public int countByMaHD(int maHD) {
        String sql = "SELECT COUNT(*) FROM ChiTietHoaDon WHERE MaHD = ?";
        try {
            ResultSet rs = JdbcHelper.query(sql, maHD);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public HoaDonChiTiet selectByma(int id) {
         List<HoaDonChiTiet> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<HoaDonChiTiet> selectByMaMon(String maMon){
        String sql="select * from ChiTietHoaDon where MaMon = ?";
        List<HoaDonChiTiet> list=selectBySql(sql, maMon);
        if(list.isEmpty()){
            return  null;
        }
        return list;
    }

}


