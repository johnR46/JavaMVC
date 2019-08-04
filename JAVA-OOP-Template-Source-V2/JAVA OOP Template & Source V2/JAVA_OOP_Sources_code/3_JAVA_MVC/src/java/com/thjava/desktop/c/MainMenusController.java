package com.thjava.desktop.c;

import com.thjava.m.Books;
import com.thjava.views.AddBook;
import com.thjava.views.MainMenus;
import com.thjava.views.ShowBooks;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenusController implements ActionListener {
    
    private MainMenus view; 

    public MainMenusController(MainMenus view) {
        this.view = view;
        view.setVisible(true);  
        
        // set commands
        view.getBtnShowBooks().setActionCommand("show");
        view.getBtnAddBook().setActionCommand("add");
        
        view.getBtnShowBooks().addActionListener(this);
        view.getBtnAddBook().addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if(command.equals("show")) {
            //System.out.println("รายการหนังสือ...");
            ShowBooks view = new ShowBooks();
            new ShowBooksController(view);  
        }
        
        if(command.equals("add")) {
            //System.out.println("เพิ่มหนังสือ...");
            Books model = new Books();
            AddBook view = new AddBook();   
            new AddBookController(model, view); 
        }
        
    }
    
} // class MainMenusController
