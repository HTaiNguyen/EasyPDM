/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controllers;

import fr.upem.easypdm.dao.implement.BookDAO;
import fr.upem.easypdm.dao.implement.ChapterDAO;
import fr.upem.easypdm.dao.implement.ParagraphDAO;
import fr.upem.easypdm.dao.implement.TomeDAO;
import fr.upem.easypdm.entity.Book;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Tome;
import fr.upem.easypdm.entity.Users;
import fr.upem.entity.easypdm.more.Maturity;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RACs;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Denis
 */
@Named("elementController")
@RequestScoped
public class ElementController {
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
    
    private Users user;
    private Path downloadDir;
    
    private Part part;
    
    public ElementController() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        user = (Users) context.getSessionMap().get("userSession");
        downloadDir = Paths.get(context.getInitParameter("DOWNLOAD_DIR"));
        
        racs = new RACs(user.getUseRoles());
        
        book = new Book();
        tome = new Tome();
        chapter = new Chapter();
        paragraph = new Paragraph();
    }
    
    public void createBook(Organisation org) {
        //TODO FIND A WAY TO NAME THE FILES OR DIRECTORIES
        book.setCreator(user.getFirstname()+" "+user.getLastname());
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        book.setEditStamp(new Timestamp(now.getTime()));
        book.setLastEditor(user.getFirstname()+" "+user.getLastname());
        book.setLock(false);
        book.setMaturity(Maturity.RELEASE);
        
        if(!racs.isPermitOperation(EntityType.BOOK, Operation.CREATE, book)){
            return;
        }
        
        try {
            Path bookPath = Files.createDirectory(downloadDir.resolve(book.getName()));
            book.setPath(bookPath.toString());
        } catch (IOException ex) {
        }
        
        bookDAO.create(book);
    }
    
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }
    
    public void addTome(Book book) {
        //TODO FIND A WAY TO NAME THE FILES OR DIRECTORIES
        tome.setCreator(user.getFirstname()+" "+user.getLastname());
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        tome.setEditStamp(new Timestamp(now.getTime()));
        tome.setLastEditor(user.getFirstname()+" "+user.getLastname());
        tome.setLock(false);
        tome.setMaturity(Maturity.RELEASE);
        tome.setBook(book);
                
        if(!racs.isPermitOperation(EntityType.TOME, Operation.CREATE, tome)){
            return;
        }
        
        try {
            Path bookPath = Paths.get(book.getPath());
            Path tomePath = Files.createDirectory(bookPath.resolve(tome.getName()));
            tome.setPath(tomePath.toString());
        } catch (IOException ex) {
        }

        tomeDAO.create(tome);
    }
    public void removeTome(Tome tome) {
        if(!racs.isPermitOperation(EntityType.TOME, Operation.DELETE, tome)){
            return;
        }
        
        Path tomePath = Paths.get(tome.getPath());
        
        try {
            FileUtils.deleteDirectory(tomePath.toFile());
        } catch (IOException ex) {
        }
        
        tomeDAO.remove(tome);
    }
    
    public List<Tome> getTomes(Book book) {
        //TODO DAOTome getByBook() 
        return null;
    }
    
    public void addChapter(Tome tome) {
        chapter.setCreator(user.getFirstname()+" "+user.getLastname());
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        chapter.setEditStamp(new Timestamp(now.getTime()));
        chapter.setLastEditor(user.getFirstname()+" "+user.getLastname());
        chapter.setLock(false);
        chapter.setMaturity(Maturity.RELEASE);
        chapter.setTome(tome);
        
        if(!racs.isPermitOperation(EntityType.CHAPTER, Operation.CREATE, chapter)){
            return;
        }
        
        try {
            Path tomePath = Paths.get(tome.getPath());
            Path chapterPath = Files.createDirectory(tomePath.resolve(chapter.getName()));
            chapter.setPath(chapterPath.toString());
        } catch (IOException ex) {
        }
        
        chapterDAO.create(chapter);
    }
    public void removeChapter(Chapter chapter) {
        if(!racs.isPermitOperation(EntityType.TOME, Operation.DELETE, chapter)){
            return;
        }
        
        Path chapterPath = Paths.get(chapter.getPath());
        
        try {
            FileUtils.deleteDirectory(chapterPath.toFile());
        } catch (IOException ex) {
        }
        
        chapterDAO.remove(chapter);
    }
    public List<Chapter> getChapters(Tome tome) {
        //TODO DAOChapter getByTome()
        return null;
    }
    
    public void addParagraph(Chapter chapter) {
        //TODO FIND A WAY TO NAME THE FILES OR DIRECTORIES
        //add in datbase
        paragraph.setCreator(user.getFirstname()+" "+user.getLastname());
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        paragraph.setEditStamp(new Timestamp(now.getTime()));
        paragraph.setLastEditor(user.getFirstname()+" "+user.getLastname());
        paragraph.setLock(false);
        paragraph.setMaturity(Maturity.RELEASE);
        paragraph.setChapter(chapter);
        //Sol1 : add in database and create Word File
        
        //Sol2 : add in database and Upload the file (Rename + Verify extension)
        if(!racs.isPermitOperation(EntityType.BOOK, Operation.CREATE, book)){
            return;
        }
        
        Path chapterPath = Paths.get(chapter.getPath());
        uploadFile(part, paragraph.getName(), chapterPath);
        
        paragraphDAO.create(paragraph);
    }
    
     private Path uploadFile(Part part, String filename, Path dest){
        Path uploadPath = dest.resolve(filename); 
        File file = uploadPath.toFile();
        try(InputStream is = part.getInputStream(); OutputStream os = new FileOutputStream(file)) {
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
        } catch (IOException ex) {
            
        }
        
        return uploadPath;
    }
    
    public void removeParagraph(Paragraph paragraph) {
        if(!racs.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph)){
                return;
        }

        Path chapterPath = Paths.get(paragraph.getPath());

        try {
            Files.delete(chapterPath);
        } catch (IOException ex) {
        }

        paragraphDAO.remove(paragraph);
    }
    public List<Paragraph> getParagraphs(Chapter chapter) {
        //TODO DAOParagraph getByChapter()
        return null;
    }

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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    
}