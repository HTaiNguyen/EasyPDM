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
public class RACFactory {
    
    public RoleAccessControl createROA(Role role, Organisation org) {
        switch(role.getName()) {
            case "Admin":
                return new RACAdmin();
            case "Book Manager":
                return new RACBookManager(org);
            case "Tome Manager":
                return new RACTomeManager(org);
            case "Chapter Manager":
                return new RACChapterManager(org);
            case "Writer":
                return new RACWriter(org);
            default:
                throw new IllegalArgumentException("No such a role");
        }
    }
}
