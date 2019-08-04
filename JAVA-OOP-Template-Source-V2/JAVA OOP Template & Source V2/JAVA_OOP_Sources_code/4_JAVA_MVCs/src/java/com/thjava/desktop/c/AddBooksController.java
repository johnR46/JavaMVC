package com.thjava.desktop.c;

import com.thjava.dao.BooksDAOImpl;
import com.thjava.dao.BooksDAOInterface;
import com.thjava.db.Database;
import com.thjava.m.Books;
import com.thjava.views.AddBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class AddBooksController implements ActionListener {
    
    private Books model;
    private AddBook view;
    
    private Database db;
    private BooksDAOInterface dao;

    public AddBooksController(Books model, AddBook view) {
        this.model = model;
        this.view = view;
        view.setVisible(true);
        
        view.getBtnSave().setActionCommand("save");
        view.getBtnSave().addActionListener(this);
        
        db = new Database();
        dao = new BooksDAOImpl(db);
        
    }

    // บันทึกข้อมูลหนังสือ
    private void save() {
        if(dao.isAddBook(model)) {
            JOptionPane.showMessageDialog(view, "บันทึกสำเร็จ", "ผลลัพธ์", 1);
            view.getTxtTitle().setText("");
            view.getTxtPrice().setText("");
        } else {
            JOptionPane.showMessageDialog(view, "บันทึกไม่สำเร็จ", "ผลลัพธ์", 0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("save")) {
            //System.out.println("บันทึก...");
            // ดึงข้อมูลจากหน้าจอ
            String title = view.getTxtTitle().getText().trim();
            String price = view.getTxtPrice().getText().trim();
            //System.out.println("ชื่อ: " + title + " ราคา: " + price);
            
            model.setTitle(title);
            model.setPrice(Integer.parseInt(price));
            save();
            db.close();
        }
    }
   
} // class AddBooksController
