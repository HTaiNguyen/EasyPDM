/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sybille
 */
@Entity
public class Team extends Organisation {
    
    @ManyToOne
    @JoinColumn(name="service_id")
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
