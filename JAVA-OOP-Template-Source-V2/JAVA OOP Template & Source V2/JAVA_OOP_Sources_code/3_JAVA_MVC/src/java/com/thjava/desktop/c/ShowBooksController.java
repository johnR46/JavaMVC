package com.thjava.desktop.c;

import com.thjava.dao.BooksDAOImpl;
import com.thjava.dao.BooksDAOInterface;
import com.thjava.db.Database;
import com.thjava.m.Books;
import com.thjava.views.ShowBooks;
import java.util.List;

public class ShowBooksController {
    
    private ShowBooks view; 
    private Database db;
    private BooksDAOInterface dao;

    public ShowBooksController(ShowBooks view) {
        this.view = view;
        view.setVisible(true);  
        
        db = new Database();
        dao = new BooksDAOImpl(db);
        showBooks();
        db.close();
    }
    
    // แสดงรายการหนังสือ
    public void showBooks() {
        
        List<Books> bList = dao.getAllBooks();
//        for (Books b : bList) {
//            System.out.println(b);
//        }

        view.showBooks(bList);
        
    }
    
    

} // class ShowBooksController
