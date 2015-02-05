/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.dao.implement;

import fr.upem.easypdm.dao.DAO;
import fr.upem.easypdm.entity.WorkPackage;

/**
 *
 * @author Tai
 */
public class WorkPackageDAO extends DAO <WorkPackage> {
    
    public WorkPackageDAO() {
        super(WorkPackage.class);
    }

    @Override
    public void create(WorkPackage t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(WorkPackage t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}