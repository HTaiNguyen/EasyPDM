/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author sybille
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Chapter extends Element { 
    
    private Tome tome;

    public Chapter() {
    }

    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     */
    public Chapter(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
    }

    /**
     *
     * @param tome
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     */
    public Chapter(Tome tome, String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
        this.tome = tome;
    }

    public Tome getTome() {
        return tome;
    }

    public void setTome(Tome tome) {
        this.tome = tome;
    }
}
