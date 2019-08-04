package com.thjava.desktop.c;

import com.thjava.dao.BooksDAOImpl;
import com.thjava.dao.BooksDAOInterface;
import com.thjava.db.Database;
import com.thjava.m.Books;
import com.thjava.s.ServicePromotion;
import com.thjava.views.ShowBooks2;
import java.util.List;


public class ShowBooksController {
    
    private ShowBooks2 view;
    private Database db;
    private BooksDAOInterface dao;

    public ShowBooksController(ShowBooks2 view) {   
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
        view.showBooks(ServicePromotion.discount(bList));   
//        for (Books b : bList) {
//            System.out.println(b);
//        }
        
    }
    

} // class ShowBooksController
