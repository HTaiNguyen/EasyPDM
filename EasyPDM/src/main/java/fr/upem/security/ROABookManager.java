/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import fr.upem.easypdm.entity.Element;
import fr.upem.easypdm.entity.Organisation;
import java.util.HashMap;
import static fr.upem.security.Operation.*;
import static fr.upem.security.EntityType.*;
/**
 *
 * @author Denis
 */
public class ROABookManager implements RoleAccessControl{
    
    final private static HashMap<EntityType, Permission> permissions;
    
    static {
        permissions = new HashMap<>();
        permissions.put(BOOK, new Permission(BOOK,READ,MODIFY,CREATE,DELETE));
        permissions.put(TOME, new Permission(TOME,READ,MODIFY,CREATE,DELETE));
        permissions.put(CHAPTER, new Permission(CHAPTER,READ,MODIFY,CREATE,DELETE));
        permissions.put(PARAGRAPH, new Permission(PARAGRAPH,READ,MODIFY,CREATE,DELETE));
    }
    
    private Organisation org;
    
    public ROABookManager(Organisation org) {
        this.org = org;
    }
    
    @Override
    public boolean isPermitOperation(EntityType type, Operation op, Element e) {
        Permission permission = permissions.get(type);
        if(permission == null) {
            return false;
        }
        
        if(!permission.isPermitOperation(op)) {
            return false;
        }
        /* Si op sur un Element et element not null */
        if(e != null && type.isElement()) {
            
            if(org.getId().equals(e.getOrganisation().getId())) {
                return false;
            }
            
            if(e.isLock()) {
                return false;
            }
            
            switch(op) {
                case DELETE:
                    if(!e.getMaturity().isDeletable()) {
                        return false;
                    }
                    break;
                case READ:
                    if(!e.getMaturity().isReadable()) {
                        return false;
                    }
                    break;
                case MODIFY:
                    if(!e.getMaturity().isWritable()) {
                        return false;
                    }
                    break;
            }
        }
        
        return true;
    }
    
}
