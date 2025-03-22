/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.dao;

import java.util.List;

/**
 *
 * @author maing
 */
public abstract class ReSysDAO <EntityType,keyType>{
     public abstract void insert(EntityType entity);
    public abstract void update(EntityType entity);    
    public abstract void delete(keyType id);
    public abstract List<EntityType> selectAll();
    public abstract EntityType selectByID(keyType id);
    public abstract List<EntityType> selectBySql(String sql, Object...args);
}
