/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.entity.Users;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis
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

    /**
     * Test of setEntityManager method, of class UsersDAO.
     */
    @Test
    public void testSetEntityManager() throws Exception {
        System.out.println("setEntityManager");
        EntityManager entityManager = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        instance.setEntityManager(entityManager);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersistentClass method, of class UsersDAO.
     */
    @Test
    public void testGetPersistentClass() throws Exception {
        System.out.println("getPersistentClass");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        Class<Users> expResult = null;
        Class<Users> result = instance.getPersistentClass();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersistentClass method, of class UsersDAO.
     */
    @Test
    public void testSetPersistentClass() throws Exception {
        System.out.println("setPersistentClass");
        Class<Users> persistentClass = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        instance.setPersistentClass(persistentClass);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UsersDAO.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        List<Users> expResult = null;
        List<Users> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UsersDAO.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        Users expResult = null;
        Users result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UsersDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Users t = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        instance.create(t);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UsersDAO.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Users t = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        instance.remove(t);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UsersDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Users t = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        Users expResult = null;
        Users result = instance.update(t);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UsersDAO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Users t = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UsersDAO instance = (UsersDAO)container.getContext().lookup("java:global/classes/UsersDAO");
        Users expResult = null;
        Users result = instance.save(t);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}