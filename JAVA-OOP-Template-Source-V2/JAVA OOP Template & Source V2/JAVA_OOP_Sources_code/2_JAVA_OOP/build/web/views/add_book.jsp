<%--
    Document   : confirm
    Created on : Nov 11, 2017, 3:27:41 PM
    Author     : Admin
--%>

<%@page import="com.thjava.dao.BooksDAOImpl"%>
<%@page import="com.thjava.dao.BooksDAOInterface"%>
<%@page import="com.thjava.db.Database"%>
<%@page import="com.thjava.m.Books"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>เพิ่มข้อมูล</title>
    </head>
    <body>
        <%
           // เซตภาษา
           request.setCharacterEncoding("UTF-8");
           response.setContentType("text/html;charset=UTF-8");
        %>

        <%
            // เพิ่มข้อมูล  
            // 1. เตรียมข้อมูลที่จะเพิ่ม
            String title = request.getParameter("title").trim();
            String price = request.getParameter("price").trim();
            Books book = new Books();
            book.setTitle(title);
            book.setPrice(Integer.parseInt(price)); 
            
            // 2. เตรียมฐานข้อมูล
            Database db = new Database();
            // 3. เตรียม dao
            BooksDAOInterface dao = new BooksDAOImpl(db);   
            // 4. เรียกใช้เมธอดที่ต้องการ
            boolean result = dao.isAddBook(book);    
            // 5. แจ้งผลลัพธ์
            if(result) {
                out.print("<h3>บันทึกสำเร็จ</h3>");
            } else {
                out.print("<h3>บันทึกไม่สำเร็จ</h3>");
            }
            // 6. ปิดการเชื่อมต่อฐานข้อมูล
            db.close();
        %>

        <p><a href="show_books.jsp">ดูรายการหนังสือ</a></p>

    </body>
</html>
