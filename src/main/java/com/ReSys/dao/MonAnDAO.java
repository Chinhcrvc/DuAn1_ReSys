/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.entity.Ban;
import com.ReSys.entity.MonAn;
import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buian
 */
public class MonAnDAO extends ReSysDAO<MonAn, String>{
    final String INSERT_SQL = "INSERT INTO MonAn VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_SQL = "UPDATE MonAn SET TenMon=?,DonGia=?,MoTa=?,HinhAnh=?,TrangThai=?,MaDM=? WHERE MaMon =?";
    final String DELETE_SQL = "DELETE FROM MonAn WHERE MaMon = ?";
    final String SELECT_ALL_SQL = "select * from MonAn";
    final String SELECT_BY_ID_SQL = "select * from MonAn where MaMon = ?";

    @Override
    public void insert(MonAn entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaMon(),
                entity.getTenMon(),
                entity.getDonGia(),
                entity.getMoTa(),
                entity.getHinhAnh(),
                entity.isTrangThai(),
                entity.getDanhMuc());
    }

    @Override
    public void update(MonAn entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getTenMon(),
                entity.getDonGia(),
                entity.getMoTa(),
                entity.getHinhAnh(),
                entity.isTrangThai(),
                entity.getDanhMuc(),
                entity.getMaMon());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<MonAn> selectAll() {
        return (List<MonAn>) selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public MonAn selectByID(String id) {
         List<MonAn> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<MonAn>selectByName( String maDM,String keyword){
        String sql = "select * from MonAn where maDM=? and TenMon like ?";
        return  this.selectBySql(sql, maDM, "%"+keyword+"%");
    }

    @Override
    public List<MonAn> selectBySql(String sql, Object... args) {
        List<MonAn> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                MonAn entity = new MonAn();
                entity.setMaMon(rs.getString("MaMon"));
                entity.setTenMon(rs.getString("TenMon"));
                entity.setDonGia(rs.getDouble("DonGia"));
                entity.setMoTa(rs.getString("Mota"));
                entity.setHinhAnh(rs.getString("HinhAnh"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setDanhMuc(rs.getString("MaDM"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<MonAn> selectByDanhMuc(String maDM){
       String sql =  "select * from MonAn where MaDM = ? and TrangThai= 1";
       return selectBySql(sql, maDM);
    }
}
