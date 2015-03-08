/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author sybille
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Paragraph.findByChapter", query = "SELECT p FROM Paragraph p WHERE p.chapter = :chapter")
})
public class Paragraph extends Element {
    
    @ManyToOne
    @JoinColumn(name="chapter_id", nullable=false)
    private Chapter chapter;

    public Paragraph() {
    }

    public Paragraph(Chapter chapter, String name, String creator, String lastEditor, boolean lock, Timestamp editStamp, String path, Maturity maturity, Organisation organisation, Users userLockId) {
        super(name, creator, lastEditor, lock, editStamp, path, maturity, organisation, userLockId);
        this.chapter = chapter;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
