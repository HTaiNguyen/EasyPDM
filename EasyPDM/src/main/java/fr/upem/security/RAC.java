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

/**
 *
 * @author Denis
 */
public interface RAC { 
    
    public boolean isPermitOperation(EntityType type, Operation op, Element e);
 
}
