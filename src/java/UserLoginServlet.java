/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import business.UserLogin;
import data.MailUtilLocal;
import data.UserLoginDB;
import javax.mail.MessagingException;

/**
 *
 * @author D!L
 */
public class UserLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonnelServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonnelServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String url = "/viewuserlogin.jsp";

        // get current action
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("display_userlogin")) {
                int i = Integer.parseInt(request.getParameter("UserLoginID"));
                UserLogin userLogin = UserLoginDB.selectUserLogin(i);
                session.setAttribute("userlogin", userLogin);
                url = "/updateuserlogin.jsp";
            } else if (action.equals("delete_userlogin")) {
                int i = Integer.parseInt(request.getParameter("UserLoginID"));
                UserLogin userLogin = UserLoginDB.selectUserLogin(i);

                // delete the Employee
                UserLoginDB.delete(userLogin);

                // get and set updated Employees
                ArrayList<UserLogin> userLogins = UserLoginDB.selectUserLogins();
                request.setAttribute("userlogins", userLogins);
                url = "/viewuserlogin.jsp";
            }
        }
        // perform action and set URL to appropriate page
        if (request.getParameter("btnSubmit") != null) {
            String userName = request.getParameter("txtUserName");
            String userPassword = request.getParameter("txtUserPassword");
            String securityLevel = request.getParameter("txtSecurityLevel");

            UserLogin ul = new UserLogin(userName, userPassword, securityLevel);

            url = "/userloginoutput.jsp";
            int numRows = UserLoginDB.insert(ul);
            request.setAttribute("sqlResult", numRows);
            if (numRows == 1) {
                request.setAttribute("sqlResult", "The information was successfully saved!");
            } else {
                request.setAttribute("sqlResult", "The information was NOT saved!");
            }
            request.setAttribute("userlogins", ul);

        } else if (request.getParameter("btnViewUserLogin") != null) {
            ArrayList<UserLogin> userlogins = UserLoginDB.selectUserLogins();
            request.setAttribute("userlogins", userlogins);
            url = "/viewuserlogin.jsp";
        } else if (request.getParameter("btnEditUserLogin") != null) {
            ArrayList<UserLogin> userlogins = UserLoginDB.selectUserLogins();
            request.setAttribute("userlogins", userlogins);
            url = "/edituserlogin.jsp";
        } else if (request.getParameter("btnUpdate") != null) {
            // get parameters from the request
            String userName = request.getParameter("txtUserName");
            String userPassword = request.getParameter("txtUserPassword");
            String securityLevel = request.getParameter("txtSecurityLevel");
            int userLoginID = Integer.parseInt(request.getParameter("txtID"));
            // get and update emp
            UserLogin userLogin = (UserLogin) session.getAttribute("userlogin");
            userLogin.setUserName(userName);
            userLogin.setUserPassword(userPassword);
            userLogin.setSecurityLevel(securityLevel);
            userLogin.setID(userLoginID);
            UserLoginDB.update(userLogin);

            // get and set updated Employees
            ArrayList<UserLogin> userLogins = UserLoginDB.selectUserLogins();
            request.setAttribute("userlogins", userLogins);
            url = "/viewuserlogin.jsp";
        } else if (request.getParameter("btnLogin") != null) {
            String userName = request.getParameter("txtUserName");
            String userPassword = request.getParameter("txtUserPassword");
            UserLogin userLogin = UserLoginDB.checkLogin(userName, userPassword);
            if (userLogin != null) {
                session.setAttribute("loggedInUser", userLogin);
                url = "/menu.jsp";
            } else {
                request.setAttribute("loggedInUser", null);

                // send email to user
                String to = "dhawk@devry.edu";
                String from = "dhawk@devry.edu";
                String subject = "Login Incorrect";
                String body = "The login failed for " + userName + userPassword;
                boolean isBodyHTML = false;

                try {
                    MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                } catch (MessagingException e) {
                    String errorMessage
                            = "ERROR: Unable to send email. "
                            + "Check Tomcat logs for details.<br>"
                            + "ERROR MESSAGE: " + e.getMessage();
                    request.setAttribute("errorMessage", errorMessage);
                    this.log(
                            "Unable to send email. \n"
                            + "Here is the email you tried to send: \n"
                            + "=====================================\n"
                            + "TO: " + to + "\n"
                            + "FROM: " + from + "\n"
                            + "SUBJECT: " + subject + "\n"
                            + "\n"
                            + body + "\n\n");
                }
                url = "/emailsent.jsp";
            }
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
