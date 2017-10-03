<%-- 
    Document   : searchEmployee
    Created on : Jan 27, 2016, 5:32:24 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Search Employee</title>
    </head>
    <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
        <br/>
        <form action="searchPersonnel" method="POST">
        Search for employee by last name:
        <input type="text" name="txtSearch"/>
        <input type="submit" value="Search" name="btnSearchEmployee"               
        </form>        
    </body>
</html>
