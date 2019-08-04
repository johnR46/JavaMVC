package com.thjava.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    
    private Connection connect;
    
    // 1. เชื่อมต่อฐานข้อมูล
    public Database() {
        
        try {
            
            Class.forName(Config.DRIVER);
            connect = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            //System.out.println("เชื่อมต่อสำเร็จ");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    // 2. ดึงข้อมูล
    public List<Map<String, Object>> queryList(String sql) {
        List<Map<String, Object>> list = new ArrayList();
        
        try {
            
            // 1. เตรียมคำสั่ง SQL
            PreparedStatement ps =connect.prepareStatement(sql);
            // 2. สั่งประมวลผลคำสั่ง SQL
            ResultSet result = ps.executeQuery();
            // 3. ดึงข้อมูล Metadata 
            ResultSetMetaData md = result.getMetaData();
            
            // 4. นำข้อมูลใส่ใน map
            while (result.next()) {                
                Map<String, Object> map = new HashMap();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    map.put(md.getColumnLabel(i), result.getObject(i));
                }
                // 5. นำ map ใส่ใน list
                list.add(map);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // 3. เพิ่มข้อมูล
    public int add(String sql, Object... args) {
        int result = 0;
        
        try {
            
            // 1. เตรียมคำสั่ง SQL
            PreparedStatement ps = connect.prepareStatement(sql);
            // 2. เซ็ตค่า args 
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            
            // 3  สั่งประมวลผลคำสั่ง SQL
            result = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    // 4. ปิดการเชื่อมต่อฐานข้อมูล
    public void close() {
        try {
            
            if(connect != null) {
                connect.close();
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

} // class Database                                  








