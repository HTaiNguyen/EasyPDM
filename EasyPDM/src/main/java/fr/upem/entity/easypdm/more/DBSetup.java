/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity.easypdm.more;

import fr.upem.easypdm.dao.implement.BookDAO;
import fr.upem.easypdm.dao.implement.ChapterDAO;
import fr.upem.easypdm.dao.implement.DepartmentDAO;
import fr.upem.easypdm.dao.implement.EnterpriseDAO;
import fr.upem.easypdm.dao.implement.ParagraphDAO;
import fr.upem.easypdm.dao.implement.RoleDAO;
import fr.upem.easypdm.dao.implement.ServiceDAO;
import fr.upem.easypdm.dao.implement.TeamDAO;
import fr.upem.easypdm.dao.implement.TomeDAO;
import fr.upem.easypdm.dao.implement.UseRoleDAO;
import fr.upem.easypdm.dao.implement.UsersDAO;
import fr.upem.easypdm.entity.Book;
import fr.upem.easypdm.entity.Chapter;
import fr.upem.easypdm.entity.Department;
import fr.upem.easypdm.entity.Enterprise;
import fr.upem.easypdm.entity.Paragraph;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.Tome;
import fr.upem.easypdm.entity.Service;
import fr.upem.easypdm.entity.Team;
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
    @EJB
    private UsersDAO userDAO;
    @EJB
    private RoleDAO roleDAO;
    @EJB
    private EnterpriseDAO entDAO;
    @EJB
    private ServiceDAO serDAO;
    @EJB
    private DepartmentDAO deptDAO;
    @EJB
    private TeamDAO teamDAO;
    @EJB
    private BookDAO bookDAO;
    @EJB 
    private TomeDAO tomeDAO;
    @EJB
    private ChapterDAO chapterDAO;
    @EJB
    private ParagraphDAO paragraphDAO;
    @EJB
    private UseRoleDAO useRoleDAO;
    
    public DBSetup() {
    }
    
    
    @PostConstruct
    public void initDB() {
        Role roleAdmin = new Role("Admin", "");
        roleDAO.create(roleAdmin);
        Role roleBM = new Role("Book Manager", "");
        roleDAO.create(roleBM);
        Role roleTM = (new Role("Tome Manager", ""));
        roleDAO.create(roleTM);
        Role roleCM = new Role("Chapter Manager", "");
        roleDAO.create(roleCM);
        Role roleW = new Role("Writer", "");
        roleDAO.create(roleW);
        
        Users admin = new Users("Admin", "Admin", "admin@EasyPDM.com", "admin", encodePasswordSHA1("admin"));
        Enterprise adminOrg = new Enterprise("Admin", "");
        userDAO.create(admin);
        entDAO.create(adminOrg);
        useRoleDAO.create(new UseRole(admin, adminOrg, roleAdmin));
   
        
        //ORGANISATION
        Enterprise enterprise = new Enterprise("UPEM", "Université Paris-Est Marne-la-vallée");
        entDAO.create(enterprise);
        Department department  = new Department(enterprise,"Département IT", "Département informatique");
        deptDAO.create(department);
        Service service = new Service(department, "service IT", "service informatique");
        serDAO.create(service);
        Team team = new Team(service, "Groupe C", "EasyPDM Groupe C");
        teamDAO.create(team);
        
        
        //USER (String firstname, String lastname, String email, String login, String password)
        Users tai = new Users("tai", "nguyen", "tai@free.fr", "tai", encodePasswordSHA1("tai"));
        userDAO.create(tai);
        Users denis = new Users("denis", "tea", "denis@free.fr", "denis", encodePasswordSHA1("denis"));
        userDAO.create(denis);
        Users jey = new Users("jérôme", "couturier", "jerome@free.fr", "jey", encodePasswordSHA1("jey"));
        userDAO.create(jey);

        //BOOK
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Timestamp time = new Timestamp(now.getTime());
        Path path = Paths.get(".");
        Book book = new Book("EasyPDM", "livre1", "jey", "jey", false, time,".", Maturity.IN_PROGRESS, enterprise, jey);
        Tome tome = new Tome("Specification", book, "jey", "jey", "jey", false, time, ".", Maturity.IN_PROGRESS, service, jey);
        Chapter chapter = new Chapter("SFG", tome, "chapter1", "tai", "tai", false, time, ".", Maturity.IN_PROGRESS, department, tai);
        Paragraph paragraph = new Paragraph(chapter, "paragraph1", "denis", "denis", false, time, ".", Maturity.RELEASE, team, denis);
        
        bookDAO.create(book);
        tomeDAO.create(tome);
        chapterDAO.create(chapter);
        paragraphDAO.create(paragraph);

    }
    
    private static String encodePasswordSHA1(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(key.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            // handle error case to taste
        }
        
        return null;
    }
}
