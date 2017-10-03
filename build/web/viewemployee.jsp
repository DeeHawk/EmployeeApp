<%-- 
    Document   : viewemployee
    Created on : Jan 27, 2016, 5:09:35 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employees</title>
    </head>
    <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
        <br/>
        <table border="1">
            <tr>
                <td> First Name </td>
                <td> Last Name </td>
                <td> Pay Rate </td>
                <td> Start Date </td>
                <td> End Date </td>
            </tr>            
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
              <c:forEach var="emp" items="${employees}">
            <tr>
                     <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.payRate}</td>
                    <td>${emp.startDate}</td>
                    <td>${emp.endDate}</td>
                </tr>
  </c:forEach>

        </table>          
    </body>
</html>
