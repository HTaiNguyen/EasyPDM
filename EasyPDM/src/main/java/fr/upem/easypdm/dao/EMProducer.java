/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Denis
 */
@Singleton
public class EMProducer {
    @Produces
    @PersistenceContext(unitName = "EasyPDMPU")
    private static EntityManager em;
    
    
}
