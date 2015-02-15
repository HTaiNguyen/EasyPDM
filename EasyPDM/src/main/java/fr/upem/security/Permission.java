/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

import java.util.EnumSet;
/**
 *
 * @author Tai
 */
public class Permission {
    
    EntityType entityType;
    private EnumSet<Operation> ops;
    
    public Permission(EntityType entityType, Operation op, Operation...ops) {
        this.entityType = entityType;
        this.ops = EnumSet.of(op, ops);
    }
    
    public boolean isPermitOperation(Operation op) {
        return ops.contains(op);
    }
    
}
