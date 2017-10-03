<%-- 
    Document   : calculator
    Created on : Jan 9, 2016, 9:15:27 PM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Academy of Computer and Information Technology</title>
    </head>
     <script language="JavaScript">
            function checkIt()
            { 
              var txtrate = document.getElementById("txtrate").value;
              var txthours = document.getElementById("txthours").value;
            
                 if (!txtrate.match(/\S/))
                {
                    alert("Text Rate is not in right format!");
                    return false;
                }
                else if (!txthours.match(/\S/))
                {
                    alert("Text Hours is not in right format!");
                    return false;
                }
                else
                {
                    document.frmAnnualSalary.submit();
                }
        }
       </script>
            
    <body>
        <a href="menu.jsp"><img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/></a>
          <form name="frmAnnualSalary" action="salaryoutput.jsp" method="POST" onsubmit="return checkIt()">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Rate:</td>
                        <td><input type="text" name="txtrate" id="txtrate" value="" /></td>
                    </tr>
                    <tr>
                         <td>Hours:</td>
                        <td><input type="text" name="txthours" id="txthours" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="CALCULATE" name="submit" /></td>
                    </tr>
                </tbody>
            </table>              
        </form>
    </body>
</html>
