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
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sybille
 */
@Entity
public class Tome extends Element {
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;
        
    @OneToMany(cascade=REMOVE, fetch = LAZY, mappedBy="tome")
    Set<Chapter> chapters;
    
    /**
     *
     */
    public Tome() {
    }

    public Tome(String title, Book book, String name, String creator, String lastEditor, boolean lock, Timestamp editStamp, String path, Maturity maturity, Organisation organisation, Users userLockId) {
        super(name, creator, lastEditor, lock, editStamp, path, maturity, organisation, userLockId);
        this.title = title;
        this.book = book;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }    
    
    
    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }
}
