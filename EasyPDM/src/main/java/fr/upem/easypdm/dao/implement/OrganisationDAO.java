/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Organisation;

/**
 *
 * @author Tai
 */
public class OrganisationDAO extends DAO <Organisation> {
    
    public OrganisationDAO() {
        super(Organisation.class);
    }

    @Override
    public void create(Organisation t) {
         String values = "(" + t.getId() 
                + "," + t.getId() + "," 
                 + t.getDescription() + "," 
                 + t.getName() + ")";
        
        getEntityManager()
                .createQuery("insert into " + Organisation.class 
                        + "(ID, DESCRIPTION, NAME) values" 
                        + values);
    }

    @Override
    public void remove(Organisation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
