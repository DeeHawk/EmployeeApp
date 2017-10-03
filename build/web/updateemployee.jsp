<%-- 
    Document   : addemployee
    Created on : Jan 16, 2016, 10:28:51 PM
    Author     : D!L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
        
        <script language="javascript">
            function checkIt()
            {                    
                var txtFirstName = document.getElementById("txtFirstName").value;
                var txtLastName = document.getElementById("txtLastName").value;
                var txtPayRate = document.getElementById("txtPayRate").value;
                var txtStartDate = document.getElementById("txtStartDate").value;
                var txtEndDate = document.getElementById("txtEndDate").value;
            
                if (!txtFirstName.match(/\S/))
                {
                    alert("First Name cannot be blank!");
                    return false;
                }
                 else if (!txtLastName.match(/\S/))
                {
                    alert("Last Name cannot be blank!");
                    return false;
                }
                else if (!txtPayRate.match(/\S/))
                {
                    alert("Pay Rate cannot be blank!");
                    return false;
                }
                else if (!txtStartDate.match(/\S/))
                {
                    alert("Start Date cannot be blank!");
                    return false;
                }
                else if (!txtEndDate.match(/\S/))
                {
                    alert("End Date cannot be blank!");
                    return false;
                }
                else                
                    document.frmAddEmployee.submit();                
        }
       </script>
    </head>
    <body>
        <a href="menu.jsp"> 
            <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        </a>                    
              <form name="frmAddEmployee" action="addPersonnel" method="POST" onsubmit="return checkIt()">
            <table border="1">
                <tbody>
                      </tr>  
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="txtID" id="txtID"  value="${emp.ID}" readonly="" /></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="txtFirstName" id="txtFirstName"  value="${emp.firstName}" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="txtLastName" id="txtLastName"  value="${emp.lastName}" /></td>
                    </tr>
                      <tr>
                        <td>Pay Rate:</td>
                        <td><input type="text" name="txtPayRate" id="txtPayRate"  value="${emp.payRate}" /></td>
                    </tr>  
                    <tr>
                        <td>Start Date:</td>
                        <td><input type="text" name="txtStartDate" id="txtStartDate" value="${emp.startDate}" /></td>
                    </tr>  
                    <tr>
                        <td>End Date:</td>
                        <td><input type="text" name="txtEndDate" id="txtEndDate"  value="${emp.endDate}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" name="btnUpdate" /></td>
                        <td><input type="reset" value="Clear" name="btnClear" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="View Personnel" name="btnViewEmployee" />
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
