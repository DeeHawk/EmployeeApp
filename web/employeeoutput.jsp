<%-- 
    Document   : employeeoutput
    Created on : Jan 16, 2016, 10:29:42 PM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Output</title>
    </head>
    <body>
       <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>
        <%
            String strFirstName = request.getParameter("txtFirstName");
            String strLastName = request.getParameter("txtLastName");
            String strPayRate = request.getParameter("txtPayRate");
            String strStartDate = request.getParameter("txtStartDate");
            String strEndDate = request.getParameter("txtEndDate");
        %>
        <br/>
        <textarea name="textAreaOutput" rows="5" cols="80">
            <%=strFirstName%>
            <%=strLastName%>
            <%=strPayRate%>
            <%=strStartDate%>
            <%=strEndDate%>
        </textarea>
        <p> <b> SQL Result </b></p>
        ${sqlResult}
        <form action="viewPersonnel" method="POST">
             <input type="submit" value="View Personnel" name="btnViewEmployee" />
        </form>
    </body>
</html>
