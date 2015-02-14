/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author sybille
 */
@Entity
public class Department extends Organisation {
    @ManyToOne
    @JoinColumn(name="entreprise_id")
    private Enterprise company;

    public Department() {
    }

    public Department(Enterprise company) {
        this.company = company;
    }

    public Department(String name, String description) {
        super(name, description);
    }

    public Department(Enterprise company, String name, String description) {
        super(name, description);
        this.company = company;
    }

    public Enterprise getCompany() {
        return company;
    }

    public void setCompany(Enterprise company) {
        this.company = company;
    }
}
