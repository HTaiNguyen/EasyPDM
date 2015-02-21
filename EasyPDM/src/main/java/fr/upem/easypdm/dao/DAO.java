/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Tai
 */

public abstract class DAO<T> {
    private Class<T> persistentClass;
    
    public DAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    /**
     * Find all the content from a table
     * @return a List of result
     */
    public List<T> findAll() {
       /* return getEntityManager()
                .createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
                .getResultList();*/
        return getEntityManager().createQuery("from " + persistentClass.getName()).getResultList();
    }
    
    /**
     * Find an specified row from a table with his id
     * @param id
     * @return 
     */
    public T find(long id) {
        T entity = (T) getEntityManager().find(getPersistentClass(), id);
        return entity;
    }
    
    /**
     * Insert an element into a table
     * @param t 
     */
    public void create(T t) {
        getEntityManager().persist(t);
    }
    
    /**
     * Remove an element from a table
     * @param t 
     */
    public void remove(T t) {
        getEntityManager().remove(t);
    }
    
    /**
     * Update table
     * @param t
     * @return 
     */
    public T update(T t) {
        T mergeEntity = getEntityManager().merge(t);
        return mergeEntity;
    }
    
    /**
     * Persist 
     * @param t
     * @return 
     */
    public T save(T t) {
        getEntityManager().persist(t);
        return t;
    }

    protected abstract EntityManager getEntityManager();
}
