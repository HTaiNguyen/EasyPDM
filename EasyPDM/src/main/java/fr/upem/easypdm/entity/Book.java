/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author sybille
 */
@Entity
public class Book extends Element {

    private String title;
    
    @OneToMany(cascade=ALL, mappedBy="book")
    Set<Tome> tomes;
    
    public Book() {
    }
    
    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param title
     */
    public Book(String name, String creator, String lastEditor, boolean session, String title) {
        super(name, creator, lastEditor, session);
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Set<Tome> getTomes() {
        return tomes;
    }

    public void setTomes(Set<Tome> tomes) {
        this.tomes = tomes;
    }
}
