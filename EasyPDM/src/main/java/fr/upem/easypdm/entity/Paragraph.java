/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sybille
 */
@Entity
public class Paragraph extends Element {
    
    private String path;
    
    @ManyToOne
    @JoinColumn(name="chapter_id", nullable=false)
    private Chapter chapter;

    public Paragraph() {
    }

    public Paragraph(String name, String creator, String lastEditor, boolean session, Chapter chapter, String path, Maturity maturity, Organisation organisation) {
        super(name, creator, lastEditor, session, maturity, organisation);
        this.chapter = chapter;
        this.path = path;
    } 

    public Chapter getChapter() {
        return chapter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
