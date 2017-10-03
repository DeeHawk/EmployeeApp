<%-- 
    Document   : login
    Created on : Feb 14, 2016, 7:16:22 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
         <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
         <form name="frmLogin" action="login" method="POST">
             Enter Username and Password:
             <table border="1">
                 <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="txtUserName" id="txtUserName"  value="" /></td>
                    </tr>
                    <tr>
                        <td>User Password:</td>
                        <td><input type="text" name="txtUserPassword" id="txtUserPassword"  value="" /></td>
                    </tr>  
               
             <tr>
                    <td><input type="submit" value="login" name="btnLogin" />
                    </tr>
             </table>
    </body>
</html>
