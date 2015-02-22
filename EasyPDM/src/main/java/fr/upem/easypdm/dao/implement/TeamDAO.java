/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Team;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
@Stateless
public class TeamDAO extends DAO <Team> {
   @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
   
    public TeamDAO() {
        super(Team.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(Organisation team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}