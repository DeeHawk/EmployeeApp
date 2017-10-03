/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Employee;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDB {

    public static int insert(Employee emp) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;

//create a String called query with an explicit insert statement
        String query = "INSERT INTO tblPersonnel (FirstName, LastName, PayRate, StartDate, EndDate) VALUES (?,?,?,?,?)";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setDouble(3, emp.getPayRate());
            ps.setString(4, emp.getStartDate());
            ps.setString(5, emp.getEndDate());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(Employee emp) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;
  
//create a String called query with an explicit insert statement
        String query = "UPDATE tblPersonnel  SET  FirstName=?, LastName=?, PayRate=?, StartDate=?, EndDate=? WHERE ID=?";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setDouble(3, emp.getPayRate());
            ps.setString(4, emp.getStartDate());
            ps.setString(5, emp.getEndDate());
            ps.setInt(6, emp.getID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Employee emp) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;

//create a String called query with an explicit insert statement
        String query = "DELETE FROM tblPersonnel WHERE ID = ? ";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, emp.getID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Employee> selectEmployees(String lastName) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();
//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();
//create a PreparedStatement
        PreparedStatement ps = null;
        ResultSet rs = null;
//create a String called query with an explicit insert statement
        String query;
        if (lastName == null) {
            query = "Select * FROM tblPersonnel";
        } else {
            query = "Select * FROM tblPersonnel WHERE LastName like ?";
        }

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
use a catch {} to handle any exceptions thrown
use a finally{} to close the PreparedStatement and free the Connection */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + lastName + "%");
            rs = ps.executeQuery();
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setID(rs.getInt("ID"));
                emp.setFirstName(rs.getString("FirstName"));
                emp.setLastName(rs.getString("LastName"));
                emp.setPayRate(rs.getDouble("PayRate"));
                emp.setStartDate(rs.getString("StartDate"));
                emp.setEndDate(rs.getString("EndDate"));
                employees.add(emp);
            }
            return employees;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Employee selectEmployee(int ID) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();
//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();
//create a PreparedStatement
        PreparedStatement ps = null;
        ResultSet rs = null;
//create a String called query with an explicit insert statement
        String query;
        query = "Select * FROM tblPersonnel WHERE ID= ?";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
use a catch {} to handle any exceptions thrown
use a finally{} to close the PreparedStatement and free the Connection */
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            Employee emp = new Employee();
            while (rs.next()) {
                emp.setID(rs.getInt("ID"));
                emp.setFirstName(rs.getString("FirstName"));
                emp.setLastName(rs.getString("LastName"));
                emp.setPayRate(rs.getDouble("PayRate"));
                emp.setStartDate(rs.getString("StartDate"));
                emp.setEndDate(rs.getString("EndDate"));
            }
            return emp;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
