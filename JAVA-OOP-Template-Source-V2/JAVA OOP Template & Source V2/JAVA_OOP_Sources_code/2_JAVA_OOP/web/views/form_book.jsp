<%--
    Document   : add_book
    Created on : Nov 11, 2017, 3:27:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ฟอร์มเพิ่มหนังสือ</title>
    </head>
    <body>
        <h1>เพิ่มหนังสือ</h1>

        <form action="add_book.jsp" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>ชื่อหนังสือ: </td>
                        <td><input type="text" name="title" required /></td>
                    </tr>
                    <tr>
                        <td>ราคา : </td>
                        <td><input type="text" name="price" required /></td>
                    </tr>
                    <tr >
                        <td></td>
                        <td colspan="2" align="center">
                            <input type="submit" value="บันทึก" />
                            <input type="reset" value="ยกเลิก" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
