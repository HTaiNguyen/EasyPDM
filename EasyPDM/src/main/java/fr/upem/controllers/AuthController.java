/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controllers;

import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("authController")
@RequestScoped
public class AuthController implements Serializable{
   

    private final static String USER_KEY = "userSession";
    
    private String userName;
    private String password;
    
    @EJB
    private UsersDAO dao;
    
    public AuthController() {
    }
    
    public boolean isLogin() {
       return FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get(USER_KEY) != null;
    }
    
    public String login() {
        //Find User in Database
        Users userDB = dao.findByLogin(userName);
        
        //Test if userName exist
        if(userDB == null) {
            return null;
        }

        //Compare the password
        if(!password.equals(userDB.getPassword())) {
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put(USER_KEY, userDB);
        return "index";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove(USER_KEY);
        return "../connection.xhtml";
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
