/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author sybille
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Book extends Element {

    public Book() {
    }
    
    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     */
    public Book(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
        
    }
}
