/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
public class RoleDAO extends DAO <Role> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public RoleDAO() {
        super(Role.class);
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

 /*   @Override
    public void create(Role t) {
         String values = "('" + t.getId() 
                + "','" + t.getDescription() + "','" + t.getName() + "','" 
                + t.getPermissions() + "')";
        
        getEntityManager()
                .createQuery("insert into " + Role.class 
                        + "(ID, DESCRIPTION, NAME, PERMISSIONS) values" 
                        + values);
    }
*/
}
