<%--
    Document   : confirm
    Created on : Nov 11, 2017, 3:27:41 PM
    Author     : Admin
--%>

<%@page import="java.sql.*"%>
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
            // 1. ประกาศตัวแปร และกำหนดค่าเริ่มต้น
            String driver = "com.mysql.jdbc.Driver";
            String utf_8 = "?useUnicode=true&characterEncoding=UTF-8";
            String url = "jdbc:mysql://localhost:3306/JAVA_OOP_V1" + utf_8;
            String username = "root";
            String password = "";

            Connection connect;
            
            try {
            
            // 2. เตรียมข้อมูลที่จะบันทึก
            String title = request.getParameter("title").trim();
            String price = request.getParameter("price").trim();
            //System.out.println("ชื่อ: " + title + " ราคา: " + price);
            
            // 3. เชื่อมต่อฐานข้อมูล
            Class.forName(driver);
            connect = DriverManager.getConnection(url, username, password);
            //System.out.println("เชื่อมต่อสำเร็จ");
            
            // 4. เตรียมคำสั่ง SQL
            String sql = "INSERT INTO BOOKS VALUES (?, ?, ?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, title);
            ps.setInt(3, Integer.parseInt(price));
            
            // 5. ประมวลผลคำสั่ง SQL
            int result = ps.executeUpdate();
            
            // 6. แจ้งผลลัพธ์
            if(result > 0) {
                //System.out.println("บันทึกสำเร็จ");
                //JOptionPane.showMessageDialog(this, "บันทึกสำเร็จ", "แจ้งผลลัพธ์", 1);
                out.print("<h3>บันทึกสำเร็จ</h3>");
            }
            
            // 7. ปิดการเชื่อมต่อฐานข้อมูล
            connect.close();
            
        } catch (Exception e) {
            //System.out.println("บันทึกไม่สำเร็จ");
            //JOptionPane.showMessageDialog(this, "บันทึกไม่สำเร็จ", "แจ้งผลลัพธ์", 0);
            out.print("<h3>บันทึกไม่สำเร็จ</h3>");
            //System.exit(0);
            e.printStackTrace();
        }

        %>

        <p><a href="show_books.jsp">ดูรายการหนังสือ</a></p>

    </body>
</html>
