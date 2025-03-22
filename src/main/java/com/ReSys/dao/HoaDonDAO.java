/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.entity.HoaDon;
import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class HoaDonDAO extends ReSysDAO<HoaDon, String> {

    final String INSERT_SQL = "insert into HoaDon values (?,?,?,?,?)";
    final String UPDATE_SQL = "update HoaDon set TrangThai=? where MaHD = ?";
    final String DELETE_SQL = "delete from HoaDon where MaHD =?";
    final String SELECT_ALL_SQL = "select * from HoaDon";
    final String SELECT_BY_ID_SQL = "select * from HoaDon where MaHD = ?";
    final String SELECT_ALLStatus_SQL = "select MaBan, TrangThai from HoaDon where TrangThai=0";

    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaBan(), entity.getMaNV(), entity.getNgayGio(),entity.isTrangThai(), entity.getGhiChu());
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.update(UPDATE_SQL,entity.isTrangThai(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selectAll() {
        return (List<HoaDon>) selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public HoaDon selectByID(String id) {
         List<HoaDon> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getInt("MaHD"));
                entity.setMaBan(rs.getString("MaBan"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayGio(rs.getDate("NgayGio"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Integer> selectDates() {
        String sql = "SELECT DISTINCT DAY(NgayGio) AS Ngay FROM HoaDon ORDER BY Ngay DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt("Ngay"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Integer> selectMonths() {
        String sql = "SELECT DISTINCT MONTH(NgayGio) AS Thang FROM HoaDon ORDER BY Thang DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt("Thang"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT YEAR(NgayGio) AS Nam FROM HoaDon ORDER BY Nam DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt("Nam"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<HoaDon> selectByMaNV(String manv) {
        String sql = "select * from HoaDon where MaNV=?";
        List<HoaDon> list = selectBySql(sql, manv);
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
    public List<HoaDon> selectHoaDonChuatt(String maBan){
        String sql="select * from HoaDon where maBan=? and trangThai=0";
        List<HoaDon> list=selectBySql(sql, maBan);
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
           
    }
    public Map<String, Boolean> fetchTableStatus() {
        Map<String, Boolean> tableStatus = new HashMap<>();
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(SELECT_ALLStatus_SQL);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaBan(rs.getString(1));
                entity.setTrangThai(rs.getBoolean(2));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (HoaDon hd : list) {
        tableStatus.put(hd.getMaBan(), hd.isTrangThai());
    }
    return tableStatus;
    }
    public int selectMaHDNew(){
        String Sql = "SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC";
        int maHD = 0; 
        try {
        ResultSet rs= JdbcHelper.query(Sql);
        if (rs.next()) {
            maHD = rs.getInt("MaHD");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return maHD;
    }
     public List<HoaDon> selectByMaBan(String maBan){
        String sql="select * from HoaDon where maBan=?";
        List<HoaDon> list=selectBySql(sql, maBan);
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
           
    }
}
