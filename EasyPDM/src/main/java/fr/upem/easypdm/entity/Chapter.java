/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
import java.sql.Timestamp;
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
    @JoinColumn(name="tome_id", nullable=false)
    private Tome tome;

    public Chapter() {
    }

    public Chapter(String title, Tome tome, String name, String creator, String lastEditor, boolean lock, Timestamp editStamp, String path, Maturity maturity, Organisation organisation, Users userLockId) {
        super(name, creator, lastEditor, lock, editStamp, path, maturity, organisation, userLockId);
        this.title = title;
        this.tome = tome;
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
