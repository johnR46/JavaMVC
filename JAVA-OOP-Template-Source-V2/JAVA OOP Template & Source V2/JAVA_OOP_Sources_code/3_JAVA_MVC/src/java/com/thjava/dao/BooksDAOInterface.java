package com.thjava.dao;

import com.thjava.m.Books;
import java.util.List;

public interface BooksDAOInterface {
    
    // 1. ดึงข้อมูลหนังสือ
    List<Books> getAllBooks();
    // 2. เพิ่มข้อมูลหนังสือ
    boolean isAddBook(Books book);
    
} // interface BooksDAOInterface


