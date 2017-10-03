<%-- 
    Document   : menu
    Created on : Jan 9, 2016, 9:12:28 PM
    Author     : D!L
--%>

<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page import= "business.UserLogin" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>>Academy of Computer and Information Technology</title>
    </head>
    <body>
        <img src="Images/logo.fw.png" width="450" height="125" alt="logo.fw"/>
        <h1>Main Menu</h1>
        <form name="frmCalculator" action="calculator.jsp" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td><img src="Images/calculator.png" width="40" height="30" alt="calculator"/>
                        </td>
                        <td><input type="submit" value="CALCULATE ANNNUAL SALARY" name="btnCalculator" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <c:if test="${loggedInUser.securityLevel=='A'}">  
            <form name="frmAddEmployee" action="addemployee.jsp" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><img src="Images/newEmployee.jpg" width="40" height="30" alt="add Employee"/>
                            </td>
                            <td><input type="submit" value="ADD EMPLOYEE" name="btnAddEmployee" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:if>
        <form name="frmViewEmployee" action="viewPersonnel" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td><img src="Images/viewEmployee.png" width="40" height="30" alt="add Employee"/>
                        </td>
                        <td><input type="submit" value="VIEW EMPLOYEES" name="btnViewEmployee" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <c:if test="${loggedInUser.securityLevel=='A'}">  

            <form name="frmSearchEmployee" action="searchemployee.jsp" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><img src="Images/searchEmployee.png" width="40" height="30" alt="add Employee"/>
                            </td>
                            <td><input type="submit" value="SEARCH EMPLOYEE" name="btnSearchEmployee" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form name="frmEditEmployee" action="updatePersonnel" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><img src="Images/editEmployee.jpg" width="40" height="30" alt="calulator"/>
                            </td>
                            <td><input type="submit" value="EDIT EMPLOYEE" name="btnEditEmployee" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <form name="frmAddUserLogin" action="adduserlogin.jsp" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td><img src="Images/login.png" width="40" height="30" alt="add Employee"/>

                            </td>
                            <td><input type="submit" value="ADD USER LOGINS" name="btnAddUserLogin" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </form>
        <form name="frmViewUserLogin" action="viewUserLogin" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td><img src="Images/users.png" width="40" height="30" alt="add Employee"/>
                        </td>
                        <td><input type="submit" value="VIEW USER LOGINS" name="btnViewUserLogin" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <form name="frmEditUserLogin" action="updateUserLogin" method="POST">           
            <table border="1">
                <tbody>
                    <tr>
                        <td><img src="Images/srch.jpg" alt=" " width="40" height="30" alt="add Employee"/>                            
                        </td>
                        <td><input type="submit" value="EDIT USER LOGINS" name="btnEditUserLogin" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </c:if>  
</body>
</html>
