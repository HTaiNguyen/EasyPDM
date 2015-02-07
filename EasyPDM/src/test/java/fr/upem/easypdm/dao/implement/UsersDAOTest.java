/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.entity.Users;
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
public class UsersDAOTest {
    
    public UsersDAOTest() {
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

    @Test
    public void findAll() {
        System.out.println("findAll");
        UsersDAO instance = new UsersDAO();
        System.out.println(instance.findAll());
    }
    
    /**
     * Test of create method, of class UsersDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Users t = new Users("Tai", "Nguyen", "tai.nguyen@free.fr", "tai", "taitai");
        UsersDAO instance = new UsersDAO();
        instance.create(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UsersDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Users t = null;
        UsersDAO instance = new UsersDAO();
        instance.remove(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
