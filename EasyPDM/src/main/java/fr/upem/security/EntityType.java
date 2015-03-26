/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.security;

/**
 *
 * @author Denis
 */
public enum EntityType {
    BOOK,TOME,CHAPTER,PARAGRAPH,ORGANISATION,ENTERPRISE,DEPARTMENT,SERVICE,TEAM,ROLE,USERS,USEROLE;
    
    public boolean isElement() {
        return BOOK.equals(this) || TOME.equals(this) || CHAPTER.equals(this) || PARAGRAPH.equals(this);
    }
}
