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
public class UserLogin {
   private int ID;
   private String userName;
   private String userPassword;
   private String securityLevel;
   
   public UserLogin(){ 
    this.ID = -1;
    this.userName = "";
    this.userPassword = "";
    this.securityLevel = "";  
   }
 
   public UserLogin(String userName, String userPassword, String securityLevel){
   this.userName = userName;
   this.userPassword = userPassword;
   this.securityLevel = securityLevel;
}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }
   
}