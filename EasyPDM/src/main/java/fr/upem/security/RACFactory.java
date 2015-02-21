/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.Role;
import fr.upem.easypdm.entity.UseRole;
import java.util.List;

/**
 *
 * @author Denis
 */
public class RACFactory {
    
    public RAC createROA(UseRole useRole) {
        switch(useRole.getRole().getName()) {
            case "Admin":
                return new RACAdmin();
            case "Book Manager":
                return new RACBookManager(useRole.getOrganisation(), useRole.getUser());
            case "Tome Manager":
                return new RACTomeManager(useRole.getOrganisation(), useRole.getUser());
            case "Chapter Manager":
                return new RACChapterManager(useRole.getOrganisation(), useRole.getUser());
            case "Writer":
                return new RACWriter(useRole.getOrganisation(), useRole.getUser());
            default:
                throw new IllegalArgumentException("No such a role");
        }
    }
}
