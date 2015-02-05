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
public abstract class DAO <T> {
    private EntityManager entityManager;
    private Class<T> persistentClass;

    
    public DAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    public List<T> findAll() {
        return getEntityManager()
                .createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
                .getResultList();
    }
    
    public T find(long id) {
        T entity = (T) getEntityManager().find(getPersistentClass(), id);
        return entity;
    }
    
    public abstract void create(T t);
    public abstract void remove(T t);
    
    public T update(T t) {
        T mergeEntity = getEntityManager().merge(t);
        return mergeEntity;
    }
    
    public T save(T t) {
        getEntityManager().persist(t);
        return t;
    }
}
