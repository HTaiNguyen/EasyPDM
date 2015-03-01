/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity.easypdm.more;

import fr.upem.controllers.ElementController;
import fr.upem.controllers.OrganisationController;
import fr.upem.controllers.RoleController;
import fr.upem.controllers.UserController;
import fr.upem.easypdm.dao.implement.EnterpriseDAO;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.Users;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Denis
 */
@Startup
@Singleton
public class DBSetup {
    
    ElementController elementController;
    OrganisationController organisationController;
    UserController userController;
    RoleController roleController;
    
    public DBSetup() {
        elementController = new ElementController();
        organisationController = new OrganisationController();
        userController = new UserController();
        roleController = new RoleController();
    }
    
    @PostConstruct
    public void initDB() {
        //ROLE
        roleController.setRole(new Role("Admin", ""));
        roleController.addRole();
        roleController.setRole(new Role("Book Manager", ""));
        roleController.addRole();
        roleController.setRole(new Role("Tome Manager", ""));
        roleController.addRole();
        roleController.setRole(new Role("Chapter Manager", ""));
        roleController.addRole();
        roleController.setRole(new Role("Writer", ""));
        roleController.addRole();
        
        //ORGANISATION
        organisationController.setEnterprise(null);
        organisationController.addEnterprise();
        organisationController.setDepartment(null);
        organisationController.addDepartement();
        organisationController.setService(null);
        organisationController.addService();
        organisationController.setTeam(null);
        organisationController.addTeam();
        
        //USER
        userController.setUser(new Users(null, null, null, null, null));
        userController.addUser();
        userController.setUser(new Users(null, null, null, null, null));
        userController.addUser();
        userController.setUser(new Users(null, null, null, null, null));
        userController.addUser();
        
        //BOOK
        elementController.setBook(null);
        elementController.createBook(null);
        elementController.setTome(null);
        elementController.addTome(null);
        elementController.setChapter(null);
        elementController.addChapter(null);
        elementController.setParagraph(null);
        elementController.addParagraph(null);
    }
}
