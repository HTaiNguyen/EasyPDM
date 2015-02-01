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
public class Departement extends Organisation {
    private Entreprise company;

    public Departement() {
    }

    public Departement(Entreprise company) {
        this.company = company;
    }

    public Departement(String name, String description) {
        super(name, description);
    }

    public Departement(Entreprise company, String name, String description) {
        super(name, description);
        this.company = company;
    }

    public Entreprise getCompany() {
        return company;
    }

    public void setCompany(Entreprise company) {
        this.company = company;
    }
}
