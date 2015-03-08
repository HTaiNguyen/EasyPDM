/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Book;
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
public class TomeDAO extends DAO <Tome> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public TomeDAO() {
        super(Tome.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public List<Tome> findByBook(Book book){
        return entityManager.createNamedQuery("Tome.findByBook", Tome.class)
            .setParameter("book", book)
            .getResultList();  
    }
}