/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.entity.Organisation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tai
 */
public class OrganisationDAOTest {
    
    public OrganisationDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class OrganisationDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Organisation t = null;
        OrganisationDAO instance = new OrganisationDAO();
        instance.create(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class OrganisationDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Organisation t = null;
        OrganisationDAO instance = new OrganisationDAO();
        instance.remove(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
