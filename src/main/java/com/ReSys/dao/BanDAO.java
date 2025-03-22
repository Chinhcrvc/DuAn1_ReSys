/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import com.ReSys.entity.Ban;
import com.ReSys.utis.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buian
 */
public class BanDAO extends ReSysDAO<Ban, String>{
    final String INSERT_SQL = "INSERT INTO Ban (MaBan, MoTa) VALUES (?,?)";
    final String UPDATE_SQL = "UPDATE Ban SET MoTa = ? WHERE MaBan = ?";
    final String DELETE_SQL = "DELETE FROM Ban WHERE MaBan = ?";
    final String SELECT_ALL_SQL = "select * from Ban";
    final String SELECT_BY_ID_SQL = "select * from Ban where MaBan = ?";

    @Override
    public void insert(Ban entity) {
        JdbcHelper.update(INSERT_SQL, 
                entity.getMaBan(),
                entity.getMoTa());
    }

    @Override
    public void update(Ban entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getMoTa(),
                entity.getMaBan());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Ban> selectAll() {
        return (List<Ban>) selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Ban selectByID(String id) {
        List<Ban> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Ban> selectBySql(String sql, Object... args) {
        List<Ban> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Ban entity = new Ban();
                entity.setMaBan(rs.getString("MaBan"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
}
