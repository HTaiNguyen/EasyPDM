/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.OrganisationDAO;
import fr.upem.easypdm.entity.Organisation;
import java.util.List;

/**
 *
 * @author Denis
 */
public class OrganisationManager {
    
    private static final OrganisationDAO organisationDAO = new OrganisationDAO();
    
    public static void addOrganisation(Organisation org) {
        organisationDAO.create(org);
    }
    
    public static void removeOrganisation(Organisation org) {
        organisationDAO.remove(org);
    }
    
    public static void updateOrganisation(Organisation org) {
        organisationDAO.update(org);
    }
    
    public static List<Organisation> getAllOrganisations() {
        return organisationDAO.findAll();
    }
    
    public static Organisation getOrganisation(long id) {
        return organisationDAO.find(id);
    }
}
