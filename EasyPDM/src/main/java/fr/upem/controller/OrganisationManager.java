/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.OrganisationDAO;
import fr.upem.easypdm.entity.Department;
import fr.upem.easypdm.entity.Enterprise;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Service;
import fr.upem.security.EntityType;
import fr.upem.security.Operation;
import fr.upem.security.RACs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class OrganisationManager {
    
    private static final OrganisationDAO organisationDAO = new OrganisationDAO();
    private final RACs racs;
    
    public OrganisationManager(AuthenticateBean session) {
        racs = new RACs(session.getUser().getUseRoles());
    }
    
    /* Enterprise Manager */
    public void addEnterprise(Organisation enterprise) {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.CREATE, null)) {
            organisationDAO.create(enterprise);
        }
    }
    
    public void removeEnterprise(Organisation enterprise) {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            //organisationDAO.remove(enterprise);
        }
    }
    
    public void updateEnterprise(Organisation enterprise) {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            //organisationDAO.update(enterprise);
        }
    }
    
    /* Department Manager */
    public void addDepartement(Organisation department, Enterprise parentOrg) {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création de département
        }
    }
    
    public void removeDepartment(Organisation department) {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            //organisationDAO.remove(enterprise);
        }
    }
    
    public void updateDepartment(Organisation department) {
        if(racs.isPermitOperation(EntityType.DEPARTMENT, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            //organisationDAO.update(enterprise);
        }
    }
    
    /* Service Manager */
    public void addService(Organisation service, Department parentOrg) {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création de service
        }
    }
    
    public void removeService(Organisation service) {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            //organisationDAO.remove(enterprise);
        }
    }
    
    public void updateService(Organisation service) {
        if(racs.isPermitOperation(EntityType.SERVICE, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            //organisationDAO.update(enterprise);
        }
    }
    
    /* Team Manager */
    public void addTeam(Organisation team, Service parentOrg) {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.CREATE, null)) {
            //Ajouter la DAO pour la création d'équipe
        }
    }
    
    public void removeTeam(Organisation team) {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.DELETE, null)) {
            //DAO pour suppression récursive des organisations
            //organisationDAO.remove(enterprise);
        }
    }
    
    public void updateTeam(Organisation team) {
        if(racs.isPermitOperation(EntityType.TEAM, Operation.MODIFY, null)) {
            //DAO pour update sans perte de hierarchie
            //organisationDAO.update(enterprise);
        }
    }
    
    public List<Organisation> getAllOrganisations() {
        if(racs.isPermitOperation(EntityType.ENTERPRISE, Operation.READ, null)
                && racs.isPermitOperation(EntityType.DEPARTMENT, Operation.READ, null)
                && racs.isPermitOperation(EntityType.SERVICE, Operation.READ, null)
                && racs.isPermitOperation(EntityType.TEAM, Operation.READ, null)) {
            return organisationDAO.findAll();
        }
        return new ArrayList<>();
    }
    
    public Organisation getOrganisation(long id) {
        if(racs.isPermitOperation(EntityType.USERS, Operation.CREATE, null)) {
            return organisationDAO.find(id);
        }
        return new Organisation();
    }
}
