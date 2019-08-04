/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thjava.web.c;

import com.thjava.dao.BooksDAOImpl;
import com.thjava.dao.BooksDAOInterface;
import com.thjava.db.Database;
import com.thjava.m.Books;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AddBookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        // เพิ่มข้อมูลหนังสือ
        // 1. เตรียมข้อมูลที่จะเพิ่ม
        String title = request.getParameter("title").trim();
        String price = request.getParameter("price").trim();
        
        Books b = new Books(title, Integer.parseInt(price));
        
        // 2. เตรียมฐานข้อมูล
        Database db = new Database();
        // 3. เพิ่มข้อมูลผ่าน DAO
        BooksDAOInterface dao = new BooksDAOImpl(db);
        boolean result = dao.isAddBook(b);
        // 4. ปิดการเชื่อมต่อฐานข้อมูล
        db.close();
        
        // 5. แจ้งผลลัพธ์
        if(result) {
            String alert = "<script> alert('บันทึกสำเร็จ'); </script>";
            RequestDispatcher rd = request.getRequestDispatcher("views/add_book.jsp");
            request.setAttribute("alert", alert);
            rd.forward(request, response);
        } else {
            String alert = "<script> alert('บันทึกไม่สำเร็จ'); </script>";
            RequestDispatcher rd = request.getRequestDispatcher("views/add_book.jsp");
            request.setAttribute("alert", alert);
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
