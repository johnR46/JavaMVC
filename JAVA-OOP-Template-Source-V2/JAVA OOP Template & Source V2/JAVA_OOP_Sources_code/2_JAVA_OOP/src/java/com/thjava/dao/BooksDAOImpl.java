package com.thjava.dao;

import com.thjava.db.Database;
import com.thjava.m.Books;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BooksDAOImpl implements BooksDAOInterface {

    private Database db;

    public BooksDAOImpl(Database db) {
        this.db = db;
    }
    
    @Override
    public List<Books> getAllBooks() {
        List<Books> bList = new ArrayList<>();
        
        String sql = "SELECT * FROM BOOKS;";    
        List<Map<String, Object>> result = db.queryList(sql);  
        
        for (Map<String, Object> map : result) {
            Books b = new Books((Integer)map.get("id"),
                                (String)map.get("title"),
                                (Integer)map.get("price"));   
            
            bList.add(b);   
        }
        
        return bList;
    }

    @Override
    public boolean isAddBook(Books book) {
        
        String sql = "INSERT INTO BOOKS VALUES (?, ?, ?);"; 
        int row = db.add(sql, book.getId(),
                              book.getTitle(),
                              book.getPrice());  
        
       return row > 0;  
    }

} // class BooksDAOImpl


