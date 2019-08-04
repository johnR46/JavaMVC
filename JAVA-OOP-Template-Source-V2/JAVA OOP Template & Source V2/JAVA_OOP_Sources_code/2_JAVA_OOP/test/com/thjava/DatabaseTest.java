package com.thjava;

import com.thjava.db.Database;
import java.util.List;
import java.util.Map;

public class DatabaseTest {
    public static void main(String[] args) {
        
        // ทดสอบการเชื่อมต่อ
        Database db = new Database();   
        
        // ทดสอบ: เมธอด queryList(...);
        List<Map<String, Object>> list = db.queryList("SELECT * FROM BOOKS;"); 
        
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }

        // ทดสอบ: เมธอด add(...)
//        String sql = "INSERT INTO BOOKS VALUES (?, ?, ?);"; 
//        Object[] book = new Object[3]; // ขนาด:3, แต่ index เริ่มที่ 0
//        // กำหนดค่า
//        book[0] = 0;
//        book[1] = "คิดใหญ่ ไม่คิดเล็ก";
//        book[2] = 220;
//        
//        int result = db.add(sql, book);  
//        if(result > 0) {
//            System.out.println("บันทึกสำเร็จ");
//        } else {
//            System.out.println("บันทึกไม่สำเร็จ");
//        }
    

        // ปิดการเชื่อมต่อฐานข้อมูล
        db.close();
    }
    
} // class DatabaseTest
