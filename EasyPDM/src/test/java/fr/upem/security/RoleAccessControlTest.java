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
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
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
    
    private UseRole useRole1;
    private UseRole useRole2;
    private UseRole useRole3;
    private UseRole useRole4;
    private UseRole useRole5;
    private UseRole useRole6;
    
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
        Users user1  = new Users();
        user1.setId(0L);
        Users user2  = new Users();
        user2.setId(1L);
        org1 = new Enterprise("enterprise", "");
        org1.setId(1L);
        org2 = new Department(org1, "department", "");
        org2.setId(2L);

        book = new Book("livre", "livre1", "me", "me", false, null,"seigneur", Maturity.IN_PROGRESS, org1, user1);
        tome = new Tome("tome", book, "tome1", "me", "me", false, null, "la nuit", Maturity.IN_PROGRESS, org1, user1);
        chapter = new Chapter("chapter", tome, "chapter1", "me", "me", true, null, "la route", Maturity.IN_PROGRESS, org2, user2);
        paragraph = new Paragraph(chapter, "para1", "me", "me", false, null, null, Maturity.RELEASE, org2, user1);
        
        bookManager = new Role("Book Manager", "");
        tomeManager = new Role("Tome Manager", "");
        chapterManager = new Role("Chapter Manager","");
        writer = new Role("Writer", "");
        factory = new RACFactory();
        
        useRole1 = new UseRole(user1, org2, chapterManager);
        useRole2 = new UseRole(user1, org2, writer);
        useRole3 = new UseRole(user1, org1, bookManager);
        useRole4 = new UseRole(user1, org1, tomeManager);
        useRole5 = new UseRole(user1, org2, chapterManager);
        useRole6 = new UseRole(user1, org2, writer);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isPermitOperation method, of class RoleAccessControl.
     */
    @Test
    public void testLock() {
        RAC rac = factory.createROA(useRole1);
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.READ, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.MODIFY, chapter));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.CHAPTER, Operation.DELETE, chapter));
    }
    
    @Test
    public void testMaturity() {
        RAC rac = factory.createROA(useRole2);
        Assert.assertEquals(true, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.READ, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.MODIFY, paragraph));
        Assert.assertEquals(false, rac.isPermitOperation(EntityType.PARAGRAPH, Operation.DELETE, paragraph));
    }
    
    @Test
    public void testBookManager() {
        RAC rac = factory.createROA(useRole3);
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
        RAC rac = factory.createROA(useRole4);
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
        RAC rac = factory.createROA(useRole5);
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
        RAC rac = factory.createROA(useRole6);
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
