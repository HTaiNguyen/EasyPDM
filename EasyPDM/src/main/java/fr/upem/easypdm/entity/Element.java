/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tai
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Element implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String creator;
    @NotNull
    private String lastEditor;
    @NotNull
    private boolean lock;
    @NotNull
    private Timestamp editStamp;
    
    @Enumerated(EnumType.STRING)
    private Maturity maturity;

    @ManyToOne
    @JoinColumn(name="organisation_id", nullable=false)
    private Organisation organisation;

    
    public Element() {
        
    }

    public Element(String name, String creator, String lastEditor, boolean lock, Maturity maturity, Organisation organisation) {
        this.name = Objects.requireNonNull(name);
        this.creator = Objects.requireNonNull(creator);
        this.lastEditor = Objects.requireNonNull(lastEditor);
        this.lock = Objects.requireNonNull(lock);
        editStamp = new Timestamp(new java.util.Date().getTime());
        this.organisation = organisation;
        this.maturity = maturity;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Timestamp getEditStamp() {
        return editStamp;
    }

    public void setEditStamp(Timestamp editStamp) {
        this.editStamp = editStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
