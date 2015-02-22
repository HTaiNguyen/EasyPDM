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

    private static ElementDAO elementDAO = new ElementDAO();
    private static Element element = new Element();
    
 
    public void createElement(Element element) {
        elementDAO.create(element);
    }
    
    public void findElementById(long id) {
        element = elementDAO.find(id);
    }
    
    public List<Element> findAllElements() {
        return elementDAO.findAll();
    }
    
    public Element getElement() {
        return element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
}
