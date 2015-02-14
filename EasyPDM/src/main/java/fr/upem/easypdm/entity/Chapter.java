/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sybille
 */
@Entity
public class Chapter extends Element { 
    
    private String title;
    
    @OneToMany(cascade=ALL, mappedBy="chapter")
    Set<Paragraph> paragraphs;
    
    @ManyToOne
    @JoinColumn(name="tome_id")
    private Tome tome;

    public Chapter() {
    }
    
    /**
     *
     * @param tome
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param title
     */
    public Chapter(Tome tome, String name, String creator, String lastEditor, boolean session, String title) {
        super(name, creator, lastEditor, session);
        this.tome = tome;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tome getTome() {
        return tome;
    }

    public void setTome(Tome tome) {
        this.tome = tome;
    }
    
    public Set<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(Set<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    
}
