/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author sybille
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Team extends Organisation {
    @OneToOne
    private Service service;

    public Team() {
    }

    public Team(Service service) {
        this.service = service;
    }

    public Team(String name, String description) {
        super(name, description);
    }

    public Team(Service service, String name, String description) {
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
