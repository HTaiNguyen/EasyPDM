/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.UseRoleDAO;
import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RACs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class UserManager {
    
    private static final UsersDAO usersDAO = new UsersDAO();
    private static final UseRoleDAO useRoleDAO = new UseRoleDAO();
    private final RACs racs;
    
    public UserManager(AuthenticateBean session) {
        racs = new RACs(session.getUser().getUseRoles());
    }
    
    public void addUser(Users user) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.CREATE, null)) {
            usersDAO.create(user);   
        }
    }
    
    public void removeUser(Users user) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.DELETE, null)) {
            usersDAO.remove(user);   
        }
    }

    public void updateUser(Users user) {
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
    
    public void addUserRoleInOrganisation(Users user, Role role, Organisation org) {
        if(racs.isPermitOperation(EntityType.USEROLE, Operation.CREATE, null)) {
            useRoleDAO.create(new UseRole(user, org, role));
        }
    }
    
    public Users getUser(long id) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.READ, null)) {
            return usersDAO.find(id);   
        }
        // A voir pour la gestion des erreurs
        return new Users();
    }
}
