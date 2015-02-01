/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import javax.persistence.Entity;

/**
 *
 * @author sybille
 */
@Entity
public class Service extends Organisation {
    private Departement department;

    public Service() {
    }

    public Service(Departement department) {
        this.department = department;
    }

    public Service(String name, String description) {
        super(name, description);
    }

    public Service(Departement department, String name, String description) {
        super(name, description);
        this.department = department;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }
}
