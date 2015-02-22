/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.beans;

import fr.upem.easypdm.dao.implement.RoleDAO;
import fr.upem.easypdm.entity.Role;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("roleBean")
@RequestScoped
public class RoleBean {
    @EJB
    private RoleDAO roleDAO;
    
    private Role role;
    
    public RoleBean() {
        role = new Role();
    }
    
    public List<Role> getAllRole() {
        return roleDAO.findAll();
    }
    
    public Role getRole(Long id) {
        return roleDAO.find(id);
    }
    
    public void addRole() {
        throw new UnsupportedOperationException();
    }
    
    public void removeRole(Role role) {
        throw new UnsupportedOperationException();
    }
}
