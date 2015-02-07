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

 /*@Override
    public void create(WorkPackage t) {
         String values = "('" + t.getId() 
                + "','" + t.getCreator() + "','"  + t.getEditStamp() + "','" 
                + t.getLastEdit()+ "','" + t.getMaturity()
                + "','" + t.getName() + "','" + t.getVersion() 
                + "','" + t.getWorkSpaceID() + "')";
        
        getEntityManager()
                .createQuery("insert into " + WorkPackage.class 
                        + "(ID, CREATOR, EDITSTAMP, LASTEDIT, MATURITY, NAME, VERSION, WORKSPACEID) values" 
                        + values);
    }*/
}