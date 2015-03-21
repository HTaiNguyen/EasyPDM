/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controllers;

import fr.upem.easypdm.dao.implement.DepartmentDAO;
import fr.upem.easypdm.dao.implement.EnterpriseDAO;
import fr.upem.easypdm.dao.implement.ServiceDAO;
import fr.upem.easypdm.dao.implement.TeamDAO;
import fr.upem.easypdm.dao.implement.UseRoleDAO;
import fr.upem.easypdm.entity.Department;
import fr.upem.easypdm.entity.Enterprise;
import fr.upem.easypdm.entity.Service;
import fr.upem.easypdm.entity.Team;
import fr.upem.easypdm.entity.Users;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RACs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Denis
 */
@Named("organisationController")
@SessionScoped
public class OrganisationController implements Serializable {
    @EJB
    private EnterpriseDAO enterpriseDAO;
    
    @EJB
    private DepartmentDAO departmentDAO;
    
    @EJB
    private ServiceDAO serviceDAO;
    
    @EJB
    private TeamDAO teamDAO;
    
    private Enterprise enterprise;
    private Department department;
    private Service service;
    private Team team;
    
    private RACs racs;
    
    @EJB
    private UseRoleDAO useRoleDAO;
    
    public OrganisationController() {
        enterprise = new Enterprise();
        department = new Department();
        service = new Service();
        team = new Team();
    }
    
    @PostConstruct
    public void init() {
        Users user = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("userSession");
        racs = new RACs(useRoleDAO.findByUser(user)); 
    }
    
    /* Enterprise Manager */
    public void addEnterprise() {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.CREATE, null)) {
            enterpriseDAO.create(enterprise);
        }
    }
    
    public void removeEnterprise(Enterprise enterprise) {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            enterpriseDAO.remove(enterprise);
        }
    }
    
    public void updateEnterprise() {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            enterpriseDAO.update(enterprise);
        }
    }
    
    public List<Enterprise> getAllEnterprise() {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.READ, null)) {
            return enterpriseDAO.findAll();
        }
        return new ArrayList<>();
    }
    
    /* Department Manager */
    public void addDepartement() {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création de département
            departmentDAO.create(department);
        }
    }
    
    public void removeDepartment(Department department) {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            departmentDAO.remove(department);
        }
    }
    
    public void updateDepartment(Department department) {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            departmentDAO.update(department);
        }
    }
    
    public List<Department> getAllDepartment() {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.READ, null)) {
            return departmentDAO.findAll();
        }
        return new ArrayList<>();
    }
    
    /* Service Manager */
    public void addService() {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création de service
            serviceDAO.create(service);
        }
    }
    
    public void removeService(Service service) {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            serviceDAO.remove(service);
        }
    }
    
    public void updateService() {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            serviceDAO.update(service);
        }
    }
    
    public List<Service> getAllService() {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.READ, null)) {
            return serviceDAO.findAll();
        }
        return new ArrayList<>();
    }
    
    /* Team Manager */
    public void addTeam() {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création d'équipe
            teamDAO.create(team);
        }
    }
    
    public void removeTeam(Team team) {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            teamDAO.remove(team);
        }
    }
    
    public void updateTeam(Team team) {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            teamDAO.update(team);
        }
    }
    
    public List<Team> getAllTeam() {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.READ, null)) {
            return teamDAO.findAll();
        }
        return new ArrayList<>();
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
}
