/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.dao;

import java.util.List;

/**
 *
 * @author Tai
 */
public interface DAO <T> {
    public List<T> findAll();
    public T find();
    public void create(T t);
    public void remove(T t);
    public void update(T t);
}
