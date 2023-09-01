/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

/**
 *
 * @author nguye
 */
public class UserDTO {
    private String userID;
    private String fullName;
    private String role;
    private String pass;

    public UserDTO(String userID, String fullName, String role, String pass) {
        this.userID = userID;
        this.fullName = fullName;
        this.role = role;
        this.pass = pass;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", fullName=" + fullName + ", role=" + role + ", pass=" + pass + '}';
    }
    
    
}
