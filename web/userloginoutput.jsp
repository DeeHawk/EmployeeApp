<%-- 
    Document   : userloginoutput
    Created on : Feb 14, 2016, 5:25:52 AM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login Output</title>
    </head>
   
        <%
            String strUserName = request.getParameter("txtUserName");
            String strUserPassword = request.getParameter("txtUserPassword");
            String strSecurityLevel = request.getParameter("txtSecurityLevel");            
        %>
          <body>
       <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
        <br/>
        <textarea name="textAreaOutput" rows="5" cols="80">
            <%=strUserName%>
            <%=strUserPassword%>
            <%=strSecurityLevel%>            
        </textarea>
        <p> <b> SQL Result </b></p>
        ${sqlResult}
        <form action="viewUserLogin" method="POST">
             <input type="submit" value="View User Login" name="btnViewUserLogin" />
        </form>
    </body>
</html>
