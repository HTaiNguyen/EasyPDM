/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.ElementDAO;
import fr.upem.easypdm.entity.Element;


/**
 *
 * @author Denis
 */
public class ElementManager {
    
    private static final ElementDAO elementDAO = new ElementDAO();
    
    public static void createElement(Element element) {
        elementDAO.create(element);
    }
    
}
