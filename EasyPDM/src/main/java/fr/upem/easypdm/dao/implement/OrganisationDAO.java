/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Organisation;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
public class OrganisationDAO extends DAO <Organisation> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager; 
    
    public OrganisationDAO() {
        super(Organisation.class);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
 /*   @Override
    public void create(Organisation t) {
         String values = "('" + t.getId() 
                + "','" + t.getId() + "','" 
                 + t.getDescription() + "','" 
                 + t.getName() + "')";
        
        getEntityManager()
                .createQuery("insert into " + Organisation.class 
                        + "(ID, DESCRIPTION, NAME) values" 
                        + values);
    }*/
}
