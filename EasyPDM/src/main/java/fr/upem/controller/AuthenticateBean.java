/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Organisation;
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
   

    private final static String USER_KEY = "userSession";
    private final static String ORG_KEY = "orgSession";
    
    private Users user;
    private Organisation organisation;
    
    @EJB
    private UsersDAO dao;
    
    public AuthenticateBean() {
        user = new Users();
    }
    
    public Users getUser() {
        return user;
    }
    
    public Organisation getOrganisation() {
        return organisation;
    }
    
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
    
    public boolean isLogin() {
       return FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get(USER_KEY) != null;
    }
    
    public String login() {
        //Find User in Database
        //TODO
        Users userDB = dao.findByLogin(user.getLogin());
        
        //Test if userName exist
        if(userDB == null) {
            return null;
        }

        //Compare the password
        if(!user.getPassword().equals(userDB.getPassword())) {
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put(USER_KEY, user);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .put(ORG_KEY, organisation);
        return "index";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove(USER_KEY);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove(ORG_KEY);
        return null;
    }
}
