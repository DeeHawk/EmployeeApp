/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author D!L
 */
public class Employee {
    
    private int ID;
    private String firstName;
    private String lastName;
    private String startDate;
    private String endDate;
    private Double payRate;
 
public Employee()
    {
        this.ID = -1;
        this.firstName = "";
        this.lastName = "";
        this.startDate = "";
        this.endDate = "";
        this.payRate = 0.0;               
    }
 
    public Employee(String fn, String ln, double pr, String sd, String ed) {
        this.firstName =  fn;
        this.lastName = ln;
        this.startDate = sd;
        this.endDate = ed;
        this.payRate = pr;   
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getPayRate() {
        return payRate;
    }

    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }
    
}
