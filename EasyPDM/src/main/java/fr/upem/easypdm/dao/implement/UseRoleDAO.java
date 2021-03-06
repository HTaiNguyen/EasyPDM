/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
@Stateless
public class UseRoleDAO extends DAO <UseRole> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public UseRoleDAO() {
        super(UseRole.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<UseRole> findByUser(Users user){
        return entityManager.createNamedQuery("UseRole.findByUser", UseRole.class)
         .setParameter("user", user)
         .getResultList();  
    }
}