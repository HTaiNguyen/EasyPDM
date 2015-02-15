/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity.easypdm.more;

/**
 *
 * @author Tai
 */
public enum Maturity {
    RELEASE, IN_PROGRESS;
    
    public boolean isReadable() {
        return IN_PROGRESS.equals(this) || RELEASE.equals(this);
    }
    
    public boolean isWritable() {
        return IN_PROGRESS.equals(this);
    }
    
    public boolean isDeletable() {
        return IN_PROGRESS.equals(this);
    }
}
