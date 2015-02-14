/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sybille
 */
@Entity
public class Department extends Organisation {
    @ManyToOne
    @JoinColumn(name="entreprise_id", nullable=false)
    private Enterprise enterprise;

    @OneToMany(cascade=ALL, mappedBy="department")
    Set<Service> services;
    
    public Department() {
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Department(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Department(String name, String description) {
        super(name, description);
    }

    public Department(Enterprise company, String name, String description) {
        super(name, description);
        this.enterprise = company;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
