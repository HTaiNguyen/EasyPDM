/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.controller;

import fr.upem.easypdm.dao.implement.ElementDAO;
import fr.upem.easypdm.entity.Element;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Denis
 */

@Named
@RequestScoped
public class ElementManager {
 
    private ElementDAO elementDAO = new ElementDAO();
    private Element element = new Element();
    
    
    public List<Element> findAllElements() {
        return elementDAO.findAll();
    }
    
    public void doCreateElement() {
        elementDAO.create(element);
    }
    
    public void doFindElementById(long id) {
        element = elementDAO.find(id);
    }
    
    public Element getElement() {
        return element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
}
