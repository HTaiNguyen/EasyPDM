/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Role;
import java.util.List;

/**
 *
 * @author Denis
 */
public class ROAFactory {
    
    public RoleAccessControl createROA(Role role, Organisation org) {
        switch(role.getName()) {
            case "Admin":
                return new ROAAdmin();
            case "Book Manager":
                return new ROABookManager(org);
            case "Tome Manager":
                return new ROATomeManager(org);
            case "Chapter Manager":
                return new ROAChapterManager(org);
            case "Writer":
                return new ROAWriter(org);
            default:
                throw new IllegalArgumentException("No such a role");
        }
    }
}
