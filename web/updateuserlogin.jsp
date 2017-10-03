<%-- 
    Document   : updateuserlogin
    Created on : Feb 14, 2016, 5:30:14 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>                    
              <form name="frmAddUserLogin" action="addUserLogin" method="POST" onsubmit="return checkIt()">
            <table border="1">
                <tbody>
                      </tr>  
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="txtID" id="txtID"  value="${userlogin.ID}" readonly="" /></td>
                    </tr>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="txtUserName" id="txtUserName"  value="${userlogin.userName}" /></td>
                    </tr>
                    <tr>
                        <td>User Password:</td>
                        <td><input type="text" name="txtUserPassword" id="txtUserPassword"  value="${userlogin.userPassword}" /></td>
                    </tr>
                      <tr>
                        <td>Security Level:</td>
                        <td><input type="text" name="txtSecurityLevel" id="txtSecurityLevel"  value="${userlogin.securityLevel}" /></td>
                    </tr>                    
                    <tr>
                        <td><input type="submit" value="Submit" name="btnUpdate" /></td>
                        <td><input type="reset" value="Clear" name="btnClear" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="View User Login" name="btnViewUserLogin" />
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
