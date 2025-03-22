/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ReSys.utis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author maing
 */
public class JdbcHelper {
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url ="jdbc:sqlserver://localhost:1433;databaseName=ReSys_Nhom_1;encrypt=false";
    private static String user ="sa";
    private static String password="123";
    static{
        try{
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
        Connection con = DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt=null;
        if(sql.trim().startsWith("{")){
            pstmt= con.prepareCall(sql);
        }else{
            pstmt= con.prepareStatement(sql);
        }
        for(int i=0;i< args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    public static void update (String sql,Object...args){
        try{
            PreparedStatement stmt=getStmt(sql, args);
            try{
                 stmt.executeUpdate();
            }finally{
                stmt.getConnection().close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static ResultSet query(String sql, Object...args){
        try{
            PreparedStatement stmt=getStmt(sql, args);
            return stmt.executeQuery();
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
      
    }
    public static Object value(String sql, Object...args){
        try{
            ResultSet rs=query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
        return null;
    }
}
