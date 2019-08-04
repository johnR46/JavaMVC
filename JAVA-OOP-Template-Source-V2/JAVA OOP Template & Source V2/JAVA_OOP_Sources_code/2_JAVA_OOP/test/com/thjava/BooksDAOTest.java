package com.thjava;

import com.thjava.dao.BooksDAOImpl;
import com.thjava.dao.BooksDAOInterface;
import com.thjava.db.Database;
import com.thjava.m.Books;
import java.util.List;

public class BooksDAOTest {
    public static void main(String[] args) {
        
        // 1. สร้างออบเจ็กต์จากคลาส Database
        Database db = new Database();
        // 2. สร้างออบเจ็กต์จากคลาส DAO
        BooksDAOInterface dao = new BooksDAOImpl(db);
        // 3. เรียกใช้เมธอดที่ต้องการ
        List<Books> bList = dao.getAllBooks();  
        // 4. นำผลลัพธ์มาใช้งาน
        for (Books b : bList) {
            System.out.println(b);
        }

        // ทดสอบ: เมธอด isAddBook(...)
        //Books book = new Books(0, "เงิน 4 ด้าน", 225);    
        //boolean result = dao.isAddBook(new Books(0, "เงิน 4 ด้าน", 225));    
//        if(dao.isAddBook(new Books(0, "เงิน 4 ด้าน", 225))) { 
//            System.out.println("บันทึกสำเร็จ");
//        } else {
//            System.out.println("บันทึกไม่สำเร็จ");
//        }
        
        // 5. ปิดการเชื่อมต่อฐานข้อมูล
        db.close(); 
        
    }

} // class BooksDAOTest
