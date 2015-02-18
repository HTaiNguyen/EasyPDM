/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
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
public class Tome extends Element {
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;
        
    @OneToMany(cascade=ALL, mappedBy="tome")
    Set<Chapter> chapters;
    
    /**
     *
     */
    public Tome() {
    }

    /**
     *
     * @param name
     * @param creator
     * @param lastEditor
     * @param session
     * @param workSpaceID
     * @param book
     * @param title
     * @param organisation
     * @param maturity
     */
    public Tome(String name, String creator, String lastEditor, boolean session, Long workSpaceID, Book book, String title, Maturity maturity, Organisation organisation) {
        super(name, creator, lastEditor, session, maturity, organisation);
        this.book = book;
        this.title = title;
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
