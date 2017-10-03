<%-- 
    Document   : adduserlogin
    Created on : Feb 14, 2016, 5:24:39 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Login</title>
    </head>
        <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>                    
              <form name="frmAddUserLogin" action="addUserLogin" method="POST" onsubmit="return checkIt()">
            <table border="1">
                <tbody>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="txtUserName" id="txtUserName"  value="" /></td>
                    </tr>
                    <tr>
                        <td>User Password:</td>
                        <td><input type="text" name="txtUserPassword" id="txtUserPassword"  value="" /></td>
                    </tr>  
                    <tr>
                        <td>Security Level:</td>
                        <td><input type="text" name="txtSecurityLevel" id="txtSecurityLevel" value="" /></td>
                    </tr>                    
                    <tr>
                        <td><input type="submit" value="Submit" name="btnSubmit" /></td>
                        <td><input type="reset" value="Clear" name="btnClear" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="View UserLogins" name="btnViewUserLogins" />
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
</html>
