/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Element;
import fr.upem.easypdm.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
public class ElementDAO extends DAO <Element> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    @OneToOne
    private Users userLockId;
    
    public ElementDAO() {
        super(Element.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}