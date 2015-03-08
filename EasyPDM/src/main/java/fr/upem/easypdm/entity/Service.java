/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author sybille
 */
@Entity
public class Service extends Organisation {
    
    @ManyToOne
    @JoinColumn(name="departement_id", nullable=false)
    private Department department;
    
    @CascadeOnDelete
    @OneToMany(cascade=REMOVE, fetch = LAZY, mappedBy="service", orphanRemoval = true)
    private Set<Team> teams;

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
    
    public Service() {
    }

    public Service(Department department) {
        this.department = department;
    }

    public Service(String name, String description) {
        super(name, description);
    }

    public Service(Department department, String name, String description) {
        super(name, description);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
