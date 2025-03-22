/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.entity.DanhMuc;
import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maing
 */
public class DanhMucDAO extends ReSysDAO<DanhMuc, String> {

    final String INSERT_SQL = "insert into DanhMuc values (?,?,?)";
    final String UPDATE_SQL = "update DanhMuc set TenDM = ?,MoTa = ? where MaDM = ?";
    final String DELETE_SQL = "delete from DanhMuc where MaDM =?";
    final String SELECT_ALL_SQL = "select * from DanhMuc";
    final String SELECT_BY_ID_SQL = "select * from DanhMuc where MaDM = ?";

    @Override
    public void insert(DanhMuc entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaDM(), entity.getTenDM(), entity.getMoTa());
    }

    @Override
    public void update(DanhMuc entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenDM(), entity.getMoTa(), entity.getMaDM());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DanhMuc> selectAll() {
        return (List<DanhMuc>) selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DanhMuc selectByID(String id) {
        List<DanhMuc> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DanhMuc entity = new DanhMuc();
                entity.setMaDM(rs.getString("MaDM"));
                entity.setTenDM(rs.getString("TenDM"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
