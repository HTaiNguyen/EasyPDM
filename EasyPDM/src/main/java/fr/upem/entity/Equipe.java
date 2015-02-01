/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author sybille
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Equipe extends Organisation {
    private Service service;

    public Equipe() {
    }

    public Equipe(Service service) {
        this.service = service;
    }

    public Equipe(String name, String description) {
        super(name, description);
    }

    public Equipe(Service service, String name, String description) {
        super(name, description);
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
