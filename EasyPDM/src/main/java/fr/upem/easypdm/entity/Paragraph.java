/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author sybille
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Paragraph extends Element {
    @OneToOne
    private Chapter chapter;

    public Paragraph() {
    }

    public Paragraph(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
    }

    public Paragraph(String name, String creator, String lastEditor, boolean session, Long workSpaceID, Chapter chapter) {
        super(name, creator, lastEditor, session, workSpaceID);
        this.chapter = chapter;
    } 

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
