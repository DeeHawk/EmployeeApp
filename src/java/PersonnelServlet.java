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
import business.Employee;
import data.EmployeeDB;

/**
 *
 * @author D!L
 */
public class PersonnelServlet extends HttpServlet {

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

        String url = "/viewemployee.jsp";

        // get current action
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("display_emp")) {
                int i = Integer.parseInt(request.getParameter("EmpID"));
                Employee emp = EmployeeDB.selectEmployee(i);
                session.setAttribute("emp", emp);
                url = "/updateemployee.jsp";
            } 
            
            else if (action.equals("delete_emp")) {
                int i = Integer.parseInt(request.getParameter("EmpID"));
                Employee emp = EmployeeDB.selectEmployee(i);

                // delete the Employee
                EmployeeDB.delete(emp);

                // get and set updated Employees
                ArrayList<Employee> employees = EmployeeDB.selectEmployees("");
                request.setAttribute("employees", employees);
                url = "/viewemployee.jsp";
            }
        }

        // perform action and set URL to appropriate page
        if (request.getParameter("btnSubmit") != null) {
            String fn = request.getParameter("txtFirstName");
            String ln = request.getParameter("txtLastName");
            double pr = Double.parseDouble(request.getParameter("txtPayRate"));
            String sd = request.getParameter("txtStartDate");
            String ed = request.getParameter("txtEndDate");

            Employee e = new Employee(fn, ln, pr, sd, ed);

            url = "/employeeoutput.jsp";
            int numRows = EmployeeDB.insert(e);
            request.setAttribute("sqlResult", numRows);
            if (numRows == 1) {
                request.setAttribute("sqlResult", "The information was successfully saved!");
            } else {
                request.setAttribute("sqlResult", "The information was NOT saved!");
            }
            request.setAttribute("employees", e);
            
        } else if (request.getParameter("btnSearchEmployee") != null) {
            String lastName = request.getParameter("txtSearch");
            ArrayList<Employee> employees = EmployeeDB.selectEmployees(lastName);
            request.setAttribute("employees", employees);
            url = "/viewemployee.jsp";
        } else if (request.getParameter("btnViewEmployee") != null) {
            ArrayList<Employee> employees = EmployeeDB.selectEmployees("");
            request.setAttribute("employees", employees);
            url = "/viewemployee.jsp";
        } else if (request.getParameter("btnEditEmployee") != null) {
            ArrayList<Employee> employees = EmployeeDB.selectEmployees("");
            request.setAttribute("employees", employees);
            url = "/editemployee.jsp";
        } else if (request.getParameter("btnUpdate") != null) {
            // get parameters from the request
            String firstName = request.getParameter("txtFirstName");
            String lastName = request.getParameter("txtLastName");
            double payRate = Double.parseDouble(request.getParameter("txtPayRate"));
            String startDate = request.getParameter("txtStartDate");
            String endDate = request.getParameter("txtEndDate");
            int empID = Integer.parseInt(request.getParameter("txtID"));
            // get and update emp
            Employee emp = (Employee) session.getAttribute("emp");
            emp.setFirstName(firstName);
            emp.setLastName(lastName);
            emp.setPayRate(payRate);
            emp.setStartDate(startDate);
            emp.setEndDate(endDate);
            emp.setID(empID);
            EmployeeDB.update(emp);

            // get and set updated Employees
            ArrayList<Employee> employees = EmployeeDB.selectEmployees("");
            request.setAttribute("employees", employees);
            url = "/viewemployee.jsp";
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
