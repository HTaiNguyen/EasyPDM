/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Element;

/**
 *
 * @author Denis
 */
public class RACAdmin implements RoleAccessControl{
    
    @Override
    public boolean isPermitOperation(EntityType type, Operation op, Element e) {
       return true;
    }
}
