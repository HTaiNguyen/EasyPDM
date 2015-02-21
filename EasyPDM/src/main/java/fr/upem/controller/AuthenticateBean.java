/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

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
@Named("AuthenticateBean")
@RequestScoped
public class AuthenticateBean implements Serializable{
   

    private final static String AUTH_KEY = "userSession";
    
    private Users user;
    
    @EJB
    private UsersDAO dao;
    
    public AuthenticateBean() {
        user = new Users();
    }
    
    public Users getUser() {
        return user;
    }
    
    public boolean isLogin() {
       return FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get(AUTH_KEY) != null;
    }
    
    public String login() {
        //Find User in Database
        //TODO
        Users userDB = new Users();
        
        //Test if userName exist
        if(userDB == null) {
            return null;
        }

        //Compare the password
        if(!user.getPassword().equals(userDB.getPassword())) {
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put(AUTH_KEY, user);
        return "index";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove(AUTH_KEY);
        return null;
    }
}
