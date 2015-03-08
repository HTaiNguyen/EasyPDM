/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Tome;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
@Stateless
public class ChapterDAO extends DAO <Chapter> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public ChapterDAO() {
        super(Chapter.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public List<Chapter> findByTome(Tome tome){
        return entityManager.createNamedQuery("Chapter.findByTome", Chapter.class)
         .setParameter("tome", tome)
         .getResultList();  
    }
}