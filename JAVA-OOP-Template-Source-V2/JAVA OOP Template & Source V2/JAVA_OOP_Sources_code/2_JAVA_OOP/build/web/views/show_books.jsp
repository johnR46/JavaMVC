<%--
    Document   : list_books
    Created on : Nov 11, 2017, 3:27:12 PM
    Author     : Admin
--%>

<%@page import="com.thjava.m.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.thjava.dao.BooksDAOImpl"%>
<%@page import="com.thjava.dao.BooksDAOInterface"%>
<%@page import="com.thjava.db.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>รายการหนังสือ</title>
    </head>
    <body>
        <h1>รายการหนังสือ</h1>
        <table width="40%" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ชื่อหนังสือ</th>
                    <th>ราคา</th>
                </tr>
            </thead>
            <tbody>

                <!-- ส่วนแสดงผล -->
                <%
                    // แสดงรายการหนังสือ  
                    // 1. เตรียมฐานข้อมูล
                    Database db = new Database();   
                    // 2. เตรียม dao
                    BooksDAOInterface dao = new BooksDAOImpl(db);   
                    // 3. เรียกใช้เมธอดที่ต้องการ
                    List<Books> bList = dao.getAllBooks();  
                    // 4. นำค่ามาแสดงผล
                    for (Books b : bList) {
                        // แสดงผล                       
                %>                
                <tr>
                    <td align ="center"><%= b.getId() %></td>
                    <td><%= b.getTitle() %></td>
                    <td align ="right"><%= b.getPrice() %></td>
                </tr>
                <% 
                    }
                    // 5. ปิดการเชื่อมต่อฐานข้อมูล
                    db.close(); 
                %>

                <!-- ส่วนแสดงผล -->

            </tbody>

        </table>
    </body>
</html>
