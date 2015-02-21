/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tai
 */
public class BookDAO extends DAO <Book> {
    @PersistenceContext(unitName = "EasyPDMPU")
    private EntityManager entityManager;
    
    public BookDAO() {
        super(Book.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}