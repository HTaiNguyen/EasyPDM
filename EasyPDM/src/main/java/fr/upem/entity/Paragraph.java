/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import javax.persistence.Entity;

/**
 *
 * @author sybille
 */
@Entity
public class Paragraph extends Element {
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
