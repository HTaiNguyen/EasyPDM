/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sybille
 */
@Entity
public class Entreprise extends Organisation {

    public Entreprise() {
    }

    public Entreprise(String name, String description) {
        super(name, description);
    }    
}
