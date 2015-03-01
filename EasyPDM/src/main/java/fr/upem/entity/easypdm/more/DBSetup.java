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
import fr.upem.easypdm.dao.implement.OrganisationDAO;
import fr.upem.easypdm.dao.implement.RoleDAO;
import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Book;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.Tome;
import fr.upem.easypdm.entity.Service;
import fr.upem.easypdm.entity.Team;
import fr.upem.easypdm.entity.Users;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
    
    @EJB
    private UsersDAO userDAO;
    @EJB
    private RoleDAO roleDAO;
    @EJB
    private OrganisationDAO orgDAO;
    
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
        Enterprise enterprise = new Enterprise("UPEM", "Université Paris-Est Marne-la-vallée");
        organisationController.setEnterprise(enterprise);
        organisationController.addEnterprise();
        
        Department department  = new Department(enterprise,"Département IT", "Département informatique");
        organisationController.setDepartment(department);
        organisationController.addDepartement();
        
        Service service = new Service(department, "service IT", "service informatique");
        organisationController.setService(service);
        organisationController.addService();
        
        Team team = new Team(service, "Groupe C", "EasyPDM Groupe C");
        organisationController.setTeam(team);
        organisationController.addTeam();
        
        //USER (String firstname, String lastname, String email, String login, String password)
        userController.setUser(new Users("tai", "nguyen", "tai@free.fr", "tai", "tai"));
        userController.addUser();
        userController.setUser(new Users("denis", "tea", "denis@free.fr", "denis", "denis"));
        userController.addUser();
        userController.setUser(new Users("jérôme", "couturier", "jerome@free.fr", "jey", "jey"));
        userController.addUser();
        
        //BOOK
        elementController.setUser(user);
        Book book = new Book("livre", "livre1", "", "", false, null,"EasyPDM", Maturity.IN_PROGRESS, org1, user1);
        Tome tome = new Tome("tome", book, "tome1", "", "", false, null, "Specification", Maturity.IN_PROGRESS, org1, user2);
        Chapter chapter = new Chapter("chapter", tome, "chapter1", "", "", false, null, "SFG", Maturity.IN_PROGRESS, org2, user3);
        Paragraph paragraph = new Paragraph(chapter, "paragraph1", "", "", false, null, null, Maturity.RELEASE, org2, user1);
        
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
