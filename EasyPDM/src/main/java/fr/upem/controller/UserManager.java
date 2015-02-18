/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.RACWriter;
import java.util.List;

/**
 *
 * @author Denis
 */
public class UserManager {
    
    private static final UsersDAO usersDAO = new UsersDAO();
    private final Users user;
    //private final ROAWriter roaWriter; 
    
    public UserManager(Users user) {
        this.user = user;
        //roaWriter = new ROAWriter()
    }
    
    public void addUser(Users user) {
        
        usersDAO.create(user);
    }
    
    public void removeUser(Users user) {
        usersDAO.remove(user);
    }

    public void updateUser(Users user) {
        usersDAO.update(user);
    }
    
    public List<Users> getAllUsers() {
        return usersDAO.findAll();
    }
    
    public List<Users> getOrganisationUsers(Organisation org) {
        //TODO
        return null;
    }
    
    public void addUserRoleInOrganisation(Users user, Role role, Organisation org) {
        //TODO
    }
    
    public Users getUser(long id) {
        return usersDAO.find(id);
    }
}
