<%-- 
    Document   : salaryoutput
    Created on : Jan 9, 2016, 10:03:21 PM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academy of Computer and Information Technology</title>
    </head>
    <body>
         <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
         <%
             String strHours = request.getParameter("txthours");
             String strRate = request.getParameter("txtrate");
             
             double dblHours = Double.parseDouble(strHours);             
             double dblRate = Double.parseDouble(strRate);
             double dblPay = dblRate * dblHours;          
           
             %>
             
             <table border="1">
                <tbody>
                     <tr>
                         <td>Hours:</td>
                         <td><%=strHours%></td>
                     </tr>
                     <tr>
                         <td>Rate:</td>
                         <td><%=strRate%></td>
                     </tr>
                     <tr>
                         <td>Pay:</td>
                         <td><%=dblPay %></td>
                     </tr>
                </tbody>
             </table>
    </body>
</html>
