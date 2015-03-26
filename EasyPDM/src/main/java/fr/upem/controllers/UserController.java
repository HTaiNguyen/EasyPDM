/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controllers;

import fr.upem.easypdm.dao.implement.OrganisationDAO;
import fr.upem.easypdm.dao.implement.RoleDAO;
import fr.upem.easypdm.dao.implement.UseRoleDAO;
import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RACs;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("userController")
@RequestScoped
public class UserController {
    @EJB
    private UsersDAO usersDAO;
    
    @EJB
    private UseRoleDAO useRoleDAO;
    
    @EJB
    private OrganisationDAO orgDAO;
    
    @EJB
    private RoleDAO roleDAO;
    
    private RACs racs;
    private Users user;
    
    private Long user_id;
    private Long role_id;
    private Long org_id;
    
    public UserController() {
        this.user = new Users();
    }
    
    @PostConstruct
    public void init() {
        Users user = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("userSession");
        racs = new RACs(useRoleDAO.findByUser(user));
    }
    
    public void addUser() {
        if(racs.isPermitOperation(EntityType.USERS, Operation.CREATE, null)) {
            user.setPassword(encodePasswordSHA1(user.getPassword()));
            usersDAO.create(user);   
        }
    }
    
    public void removeUser(Users user) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.DELETE, null)) {
            usersDAO.remove(user);   
        }
    }

    public void updateUser() {
        if(racs.isPermitOperation(EntityType.USERS, Operation.MODIFY, null)) {
            usersDAO.update(user);
        }
    }
    
    public List<Users> getAllUsers() {
        if(racs.isPermitOperation(EntityType.USERS, Operation.READ, null)) {
            return usersDAO.findAll();   
        }
        return new ArrayList<>();
    }
    
    public List<Users> getOrganisationUsers(Organisation org) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.READ, null)) {
            //TODO DAO pour recuperer Users par Organisation
        }
        return new ArrayList<>();
    }
    
    public void addUserRoleInOrganisation() {
        if(racs.isPermitOperation(EntityType.USEROLE, Operation.CREATE, null)) {
            useRoleDAO.create(new UseRole(usersDAO.find(user_id), orgDAO.find(org_id), roleDAO.find(role_id)));
        }
    }
    
    public Users findUserBy(long id) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.READ, null)) {
            return usersDAO.find(id);   
        }
        // A voir pour la gestion des erreurs
        return new Users();
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }
    
    private static String encodePasswordSHA1(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(key.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            // handle error case to taste
        }
        
        return null;
    }
}
