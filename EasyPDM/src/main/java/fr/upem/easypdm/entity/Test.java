/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mgomes02
 */
public class Test {
    @PersistenceContext(unitName = "EasyPDMPU")
    private  EntityManager em;
}
