<%--
    Document   : list_books
    Created on : Nov 11, 2017, 3:27:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
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
                <c:forEach items="${bList}" var="b">
                <tr>
                    <td align ="center">${b.id}</td>
                    <td>${b.title}</td>
                    <td align ="right">${b.price}</td>
                </tr>
                </c:forEach>
                <!-- ส่วนแสดงผล -->

            </tbody>

        </table>
        <h3>รวม: ${fn:length(bList)} เล่ม</h3>
    </body>
</html>
