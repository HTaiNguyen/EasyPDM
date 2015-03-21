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
import fr.upem.easypdm.dao.implement.UseRoleDAO;
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
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Denis
 */
@Named("elementController")
@RequestScoped
public class ElementController implements Serializable{
    @EJB
    private BookDAO bookDAO;
    @EJB
    private TomeDAO tomeDAO;
    @EJB
    private ChapterDAO chapterDAO;
    @EJB
    private ParagraphDAO paragraphDAO;
    @EJB
    private UseRoleDAO useRoleDAO;
    
    private Book book;
    private Tome tome;
    private Chapter chapter;
    private Paragraph paragraph;
    
    private RACs racs;
    
    private Users user;
    private Path downloadDir;
    
    private Part part;
    
    public ElementController() {
        book = new Book();
        tome = new Tome();
        chapter = new Chapter();
        paragraph = new Paragraph(); 
    }
    
    @PostConstruct
    public void init() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        user = (Users) context.getSessionMap().get("userSession");
        downloadDir = Paths.get(context.getInitParameter("DOWNLOAD_DIR"));
        System.out.println(user.getId());
        
        racs = new RACs(useRoleDAO.findByUser(user));
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
        book.setOrganisation(useRoleDAO.findByUser(user).get(0).getOrganisation());
          
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
    
    public Book getBookById(Long id) {
        return bookDAO.find(id);
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
        tome.setOrganisation(useRoleDAO.findByUser(user).get(0).getOrganisation());
             
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
    
    public Tome getTomeById(Long id) {
        return tomeDAO.find(id);
    }
    
    public List<Tome> getTomes(Book book) { 
        return tomeDAO.findByBook(book);
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
        chapter.setOrganisation(useRoleDAO.findByUser(user).get(0).getOrganisation());
        
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
        return chapterDAO.findByTome(tome);
    }
    
    public Chapter getChapterById(Long id) {
        return chapterDAO.find(id);
    }
    
    public void addParagraph(Chapter chapter) {
        String ext = FilenameUtils.getExtension(part.getSubmittedFileName());
        
        if(ext.equals("doc") || ext.equals("docx")) {
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
            paragraph.setOrganisation(useRoleDAO.findByUser(user).get(0).getOrganisation());

            paragraph.setName(part.getSubmittedFileName());
            paragraph.setLock(false);


            //Sol1 : add in database and create Word File

            //Sol2 : add in database and Upload the file (Rename + Verify extension)
            if(!racs.isPermitOperation(EntityType.BOOK, Operation.CREATE, book)){
                return;
            }

            Path chapterPath = Paths.get(chapter.getPath());
            paragraph.setPath(uploadFile(part, part.getSubmittedFileName(), chapterPath).toString());
            paragraphDAO.create(paragraph);
            paragraph = new Paragraph();
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "The document must be in word's format !", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return;
        }
    }
    
    public void editParagraph(Paragraph paragraph) {
        String ext = FilenameUtils.getExtension(part.getSubmittedFileName());
        
        if(ext.equals("doc") || ext.equals("docx")) {
            //TODO FIND A WAY TO NAME THE FILES OR DIRECTORIES
            //add in datbase
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            paragraph.setEditStamp(new Timestamp(now.getTime()));
            paragraph.setLastEditor(user.getFirstname() + " " + user.getLastname());
            paragraph.setLock(false);

            //Sol1 : add in database and create Word File

            //Sol2 : add in database and Upload the file (Rename + Verify extension)
            if(!racs.isPermitOperation(EntityType.BOOK, Operation.MODIFY, book)){
                return;
            }

            Path path = Paths.get(paragraph.getPath());
            uploadFile(part, path.getFileName().toString(), path.getParent());
            paragraphDAO.update(paragraph);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "The document must be in word's format !", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            return;
        }
    }

    public Paragraph getParagraphById(long id) {
        return paragraphDAO.find(id);
    }
    
    private Path uploadFile(Part part, String filename, Path dest){
        
            Path uploadPath = dest.resolve(filename);
        try {  
            Files.copy(part.getInputStream(), uploadPath, REPLACE_EXISTING);
        } catch (IOException ex) {
            // nothing to do
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
        return paragraphDAO.findByChapter(chapter);
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

    public void setBook(Book book) {
        this.book = book;
    }

    public void setTome(Tome tome) {
        this.tome = tome;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
