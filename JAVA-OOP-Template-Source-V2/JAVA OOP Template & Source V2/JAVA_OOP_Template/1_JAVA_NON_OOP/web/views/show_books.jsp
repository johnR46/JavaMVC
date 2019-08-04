<%--
    Document   : list_books
    Created on : Nov 11, 2017, 3:27:12 PM
    Author     : Admin
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>รายการหนังสือ</title>
    </head>
    <body>
        <h1>รายการหนังสือ</h1>


        <%
            String driver = "com.mysql.jdbc.Driver";
            String utf_8 = "?useUnicode=true&characterEncoding=UTF-8";
            String url = "jdbc:mysql://localhost:3306/JAVA_OOP_V1" + utf_8;
            String username = "root";
            String password = "";

            Connection conntct;
            try {
                // 2. connect to db
                Class.forName(driver);
                conntct = DriverManager.getConnection(url, username, password);
                //    System.out.println("conect it's ok");

                // เตรียมคำสั่ง SQL
                String sql = "SELECT * FROM BOOKS";
                PreparedStatement ps = conntct.prepareStatement(sql);

                ResultSet result = ps.executeQuery();
                // process exec code sql


        %>






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
                <%                // show data 
                    while (result.next()) {


                %>

                <tr>
                    <td align ="center"><%=result.getInt("id")%></td>
                    <td><%= result.getString("title")%></td>
                    <td align ="right"><%= result.getInt("id")%></td>
                </tr>
                <!-- ส่วนแสดงผล -->

                <%
//            System.out.print("รหัส  : " + result.getInt("id"));
//            System.out.print("ชื่อ   : " + result.getInt("title"));
//            System.out.print("ราคา : " + result.getInt("price"));
//            System.out.println();
                        }
                        // close connect db
                        conntct.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>

            </tbody>

        </table>
    </body>
</html>
