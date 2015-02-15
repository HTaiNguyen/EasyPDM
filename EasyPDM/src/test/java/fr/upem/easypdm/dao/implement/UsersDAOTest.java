/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import static org.mockito.Mockito.mock;

import fr.upem.easypdm.entity.Users;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @Test
    public void testCreate() {

        UsersDAO dao = mock(UsersDAO.class);
        Users user = new Users("tai", "nguyen", "tai.nguyen@free.fr", "tai", "taitai");
        dao.create(user);
        dao.save(user);
        
        user = dao.find(1);
        assertEquals(user.getEmail(),"tai.nguyen@free.fr");
    }
    
}
