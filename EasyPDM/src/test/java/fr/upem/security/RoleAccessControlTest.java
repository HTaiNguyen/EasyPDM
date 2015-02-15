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
import fr.upem.easypdm.entity.Tome;
import fr.upem.entity.easypdm.more.Maturity;
import org.junit.After;
import org.junit.AfterClass;
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
        org2 = new Department(org1, "department", "");
        
        book = new Book("livre", "me", "me", false, "seigneur", Maturity.IN_PROGRESS, org1);
        tome = new Tome("tome1", "me", "me", false, book, "la nuit", Maturity.IN_PROGRESS,org1);
        chapter = new Chapter(tome, "chap1", "me", "me", false, "la route", Maturity.IN_PROGRESS, org2);
        paragraph = new Paragraph("para1", "me", "me", false, chapter, "/stockage/", Maturity.RELEASE, org2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isPermitOperation method, of class RoleAccessControl.
     */
    @Test
    public void testLock() {
    }
    
    @Test
    public void testMaturity() {
    }
    
    @Test
    public void testBookManager() {
    }
    
    @Test 
    public void testTomeManager() {
    }
    
    @Test 
    public void testChapterManager() {
    }
    
    @Test 
    public void testParagraphManager() {
    }

}
