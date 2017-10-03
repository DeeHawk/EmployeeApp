<%-- 
    Document   : viewuserlogin
    Created on : Feb 14, 2016, 5:26:29 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User Login</title>
    </head>
   <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
        <br/>
        <table border="1">
            <tr>
                <td> User Name </td>
                <td> User Password </td>
                <td> Security Level </td>               
            </tr>            
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
              <c:forEach var="userlogin" items="${userlogins}">
            <tr>
                        <td>${userlogin.userName}</td>
                        <td>${userlogin.userPassword}</td>
                        <td>${userlogin.securityLevel}</td>                   
                </tr>                
                 </c:forEach>
        </table>          
    </body>
</html>
