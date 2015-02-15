/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tai
 */
public class Permission {
    
    EntityType entityType;
    private EnumSet<Operation> ops;
    
    public Permission(EntityType entityType, Operation...ops) {
        this.entityType = entityType;
        this.ops = EnumSet.of(null, ops);
    }
    
    public boolean isPermitOperation(Operation op) {
        return ops.contains(op);
    }
    
}
