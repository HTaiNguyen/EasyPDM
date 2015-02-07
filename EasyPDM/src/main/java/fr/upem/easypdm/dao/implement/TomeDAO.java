/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.Tome;

/**
 *
 * @author Tai
 */
public class TomeDAO extends DAO <Tome> {
    
    public TomeDAO() {
        super(Tome.class);
    }
}