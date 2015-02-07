/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Users;

/**
 *
 * @author Tai
 */
public class UsersDAO extends DAO <Users> {

    public UsersDAO() {
        super(Users.class);
    }

    @Override
    public void create(Users t) {
        String values = "('" + t.getId() 
                + "','" + t.getEmail() + "','" +t.getFirstname() + "','" 
                + t.getLastname() + "','" + t.getLogin() 
                + "','" + t.getPassword() + "')";
        
        getEntityManager()
                .createQuery("insert into " + Users.class 
                        + "(ID, EMAIL, FIRSTNAME, LASTNAME, LOGIN, PASSWORD) values" 
                        + values);
    }

    @Override
    public void remove(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
