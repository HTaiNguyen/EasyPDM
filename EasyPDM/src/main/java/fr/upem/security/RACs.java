/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Element;
import fr.upem.easypdm.entity.Organisation;
import fr.upem.easypdm.entity.UseRole;
import fr.upem.easypdm.entity.Users;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Denis
 */
public class RACs implements RAC {
    
    private HashSet<RAC> racs;

    public RACs(Set<UseRole> useRoles) {
        RACFactory racFactory = new RACFactory();
        racs = new HashSet<>();
        for(UseRole useRole : useRoles) {
            racs.add(racFactory.createROA(useRole));
        }
    }

    @Override
    public boolean isPermitOperation(EntityType type, Operation op, Element e) {
        boolean result = false;
        for(RAC rac : racs) {
            result = rac.isPermitOperation(type, op, e) || result;
        }
        return result;
    }
}
