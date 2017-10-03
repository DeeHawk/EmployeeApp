/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.UserLogin;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author D!L
 */
public class UserLoginDB {
    public static int insert(UserLogin userLogin) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;

//create a String called query with an explicit insert statement
        String query = "INSERT INTO tblUserLogin (UserName, UserPassword, SecurityLevel) VALUES (?,?,?)";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userLogin.getUserName());
            ps.setString(2, userLogin.getUserPassword());
            ps.setString(3, userLogin.getSecurityLevel());           
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(UserLogin userLogin) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;
      
//create a String called query with an explicit insert statement
        String query = "UPDATE tblUserLogin  SET  UserName=?, UserPassword=?, SecurityLevel=? WHERE ID=?";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userLogin.getUserName());
            ps.setString(2, userLogin.getUserPassword());
            ps.setString(3, userLogin.getSecurityLevel());
            ps.setInt(4, userLogin.getID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(UserLogin userLogin) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();

//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();

//create a PreparedStatement
        PreparedStatement ps = null;

//create a String called query with an explicit insert statement
        String query = "DELETE FROM tblUserLogin WHERE ID = ? ";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
*use a catch {} to handle any exceptions thrown
*use a finally{} to close the PreparedStatement and free the Connection 
         */
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userLogin.getID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<UserLogin> selectUserLogins(){
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();
//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();
//create a PreparedStatement
        PreparedStatement ps = null;
        ResultSet rs = null;
//create a String called query with an explicit insert statement
        String query;
        query = "SELECT * FROM tblUserLogin";
        
        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
use a catch {} to handle any exceptions thrown
use a finally{} to close the PreparedStatement and free the Connection */
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<UserLogin> userLogins = new ArrayList<UserLogin>();
            while (rs.next()) {
                 UserLogin userLogin = new UserLogin();
                 userLogin.setID(rs.getInt("ID"));
                 userLogin.setUserName(rs.getString("UserName"));
                 userLogin.setUserPassword(rs.getString("UserPassword"));
                 userLogin.setSecurityLevel(rs.getString("SecurityLevel"));
                 userLogins.add(userLogin);
            }
            return userLogins;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static UserLogin selectUserLogin(int ID) {
//create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();
//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();
//create a PreparedStatement
        PreparedStatement ps = null;
        ResultSet rs = null;
//create a String called query with an explicit insert statement
        String query;
        query = "SELECT * FROM tblUserLogin WHERE ID= ?";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
use a catch {} to handle any exceptions thrown
use a finally{} to close the PreparedStatement and free the Connection */
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            UserLogin userLogin = new UserLogin();
            while (rs.next()) {
                 userLogin.setID(rs.getInt("ID"));
                 userLogin.setUserName(rs.getString("UserName"));
                 userLogin.setUserPassword(rs.getString("UserPassword"));
                 userLogin.setSecurityLevel(rs.getString("SecurityLevel"));
                 }
            return userLogin;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static UserLogin checkLogin(String userName, String userPassword)
    {
        //create a ConnectionPool object
        ConnectionPool pool = ConnectionPool.getInstance();
//create a Connection object using the ConnectionPool
        Connection connection = pool.getConnection();
//create a PreparedStatement
        PreparedStatement ps = null;
        ResultSet rs = null;
//create a String called query with an explicit insert statement
        String query;
        query = "SELECT * FROM tblUserLogin WHERE UserName= ? AND UserPassword=?";

        /* use a try {} to create the PreparedStatement object, set the parameters for the insert and execute the statement 
use a catch {} to handle any exceptions thrown
use a finally{} to close the PreparedStatement and free the Connection */
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();
            UserLogin userLogin = new UserLogin();
            if (rs.next()) {
                 userLogin.setID(rs.getInt("ID"));
                 userLogin.setUserName(rs.getString("UserName"));
                 userLogin.setUserPassword(rs.getString("UserPassword"));
                 userLogin.setSecurityLevel(rs.getString("SecurityLevel"));
                 } else
            {
                return null;
            }
            return userLogin;
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
