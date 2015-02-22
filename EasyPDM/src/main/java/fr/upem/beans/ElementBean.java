/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.beans;

import fr.upem.easypdm.dao.implement.BookDAO;
import fr.upem.easypdm.dao.implement.ChapterDAO;
import fr.upem.easypdm.dao.implement.ParagraphDAO;
import fr.upem.easypdm.dao.implement.TomeDAO;
import fr.upem.easypdm.entity.Book;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Tome;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.RACs;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("elementBean")
@RequestScoped
public class ElementBean {
    @EJB
    private BookDAO bookDAO;
    @EJB
    private TomeDAO tomeDAO;
    @EJB
    private ChapterDAO chapterDAO;
    @EJB
    private ParagraphDAO paragraphDAO;
    
    private Book book;
    private Tome tome;
    private Chapter chapter;
    private Paragraph paragraph;
    
    private final RACs racs;
    
    public ElementBean() {
        Users user = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("userSession");
        racs = new RACs(user.getUseRoles());
        
        book = new Book();
        tome = new Tome();
        chapter = new Chapter();
        paragraph = new Paragraph();
    }
    
    public void createBook() {
        //TODO add in database and create Directory
    }
    
    public void addTome() {
        //TODO add in database and create Directory
    }
    public void removeTome(Tome tome) {
        //TODO remove in database and delete directory
    }
    public List<Tome> getTomes(Book book) {
        //TODO DAOTome getByBook()
        
        return null;
    }
    
    public void addChapter() {
        //TODO add in database and create Directory
    }
    public void removeChapter(Chapter chapter) {
        //TODO remove in database and delete directory
    }
    public List<Chapter> getChapters(Tome tome) {
        //TODO DAOChapter getByTome()
        return null;
    }
    
    public void addParagraph() {
        //TODO 
        //Sol1 : add in database and create Word File
        //Sol2 : add in database and Upload the file (Rename + Verify extension) 
    }
    public void removeParagraph(Paragraph paragraph) {
        //TODO remove in database and delete WordFile
    }
    public List<Paragraph> getParagraphs(Chapter chapter) {
        //TODO DAOParagraph getByChapter()
        return null;
    }
    
    //public void upload()
    //public void download()

    public Book getBook() {
        return book;
    }

    public Tome getTome() {
        return tome;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }
}
