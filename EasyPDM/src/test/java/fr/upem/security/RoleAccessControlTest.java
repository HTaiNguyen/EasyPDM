/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Book;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Department;
import fr.upem.easypdm.entity.Enterprise;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.Tome;
import fr.upem.entity.easypdm.more.Maturity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Denis
 */
public class RoleAccessControlTest {
    
    private Enterprise org1;
    private Department org2;
    private Book book;
    private Tome tome;
    private Chapter chapter;
    private Paragraph paragraph;
    private RACFactory factory;
    
    private Role bookManager;
    private Role tomeManager;
    private Role chapterManager;
    private Role writer;
    
    
    public RoleAccessControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        org1 = new Enterprise("enterprise", "");
        org1.setId(1);
        org2 = new Department(org1, "department", "");
        org2.setId(2);
        
        book = new Book("livre", "me", "me", false, "seigneur", Maturity.IN_PROGRESS, org1);
        tome = new Tome("tome1", "me", "me", false, book, "la nuit", Maturity.IN_PROGRESS,org1);
        chapter = new Chapter(tome, "chap1", "me", "me", true, "la route", Maturity.IN_PROGRESS, org2);
        paragraph = new Paragraph("para1", "me", "me", false, chapter, "/stockage/", Maturity.RELEASE, org2);
        
        bookManager = new Role("Book Manager", "");
        tomeManager = new Role("Tome Manager", "");
        chapterManager = new Role("Chapter Manager","");
        writer = new Role("Writer", "");
        factory = new RACFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isPermitOperation method, of class RoleAccessControl.
     */
    @Test
    public void testLock() {
        RoleAccessControl rac = factory.createROA(chapterManager, org2);
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));
    }
    
    @Test
    public void testMaturity() {
        RoleAccessControl rac = factory.createROA(writer, org2);
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));
    }
    
    @Test
    public void testBookManager() {
        RoleAccessControl rac = factory.createROA(bookManager, org1);
        Assert.assertEquals(true, EntityType.BOOK.isElement());
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.BOOK, Operation.READ, book));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.BOOK, Operation.MODIFY, book));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.BOOK, Operation.DELETE, book)); 
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.BOOK, Operation.CREATE, book));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.READ, tome));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.MODIFY, tome));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.DELETE, tome)); 
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.CREATE, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.CREATE, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.CREATE, paragraph));
    }
    
    @Test 
    public void testTomeManager() {
        RoleAccessControl rac = factory.createROA(tomeManager, org1);
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.BOOK, Operation.READ, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.MODIFY, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.DELETE, book)); 
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.CREATE, book));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.READ, tome));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.MODIFY, tome));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.DELETE, tome)); 
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.TOME, Operation.CREATE, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.CREATE, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.CREATE, paragraph));
    }
    
    @Test 
    public void testChapterManager() {
        RoleAccessControl rac = factory.createROA(chapterManager, org2);
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.READ, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.MODIFY, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.DELETE, book)); 
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.CREATE, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.READ, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.MODIFY, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.DELETE, tome)); 
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.CREATE, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.CREATE, chapter));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));  
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.CREATE, paragraph));
    }
    
    @Test 
    public void testParagraphManager() {
        RoleAccessControl rac = factory.createROA(writer, org2);
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.READ, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.MODIFY, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.DELETE, book)); 
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.BOOK, Operation.CREATE, book));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.READ, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.MODIFY, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.DELETE, tome)); 
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.TOME, Operation.CREATE, tome));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));  
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.CREATE, chapter));
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));  
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.CREATE, paragraph));
    }

}