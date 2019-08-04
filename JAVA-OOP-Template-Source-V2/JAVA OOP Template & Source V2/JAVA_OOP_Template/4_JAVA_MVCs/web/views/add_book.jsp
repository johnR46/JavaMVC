<%--
    Document   : confirm
    Created on : Nov 11, 2017, 3:27:41 PM
    Author     : Admin
--%>

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


        ${alert}

        <p><a href="ShowBooksController">ดูรายการหนังสือ</a></p>
        <p><a href="FormBookController">เพิ่มหนังสือ</a></p>

    </body>
</html>
