/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tai
 */
@Stateless
public class UsersDAO extends DAO <Users> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public UsersDAO() {
        super(Users.class);
    }
    
    public Users findByLogin(String login) {
        try {
            TypedQuery<Users> query = getEntityManager().createQuery(
                    "SELECT u FROM User1 u WHERE u.login = \"" + login + "\"", Users.class
            );
            
            return query.getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
