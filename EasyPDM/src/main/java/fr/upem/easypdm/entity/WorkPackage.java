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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tai
 */
@Entity
public class WorkPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private long version;
    @NotNull
    private Maturity maturity;
    @NotNull
    private String creator;
    @NotNull
    private String lastEdit;
    @NotNull
    private Timestamp editStamp;
    
    @ManyToOne
    @JoinColumn(name="organisation_id")
    private Organisation organisation;

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public WorkPackage() {
        
    }

    public WorkPackage(Long id, String name, long version, Maturity maturity, String creator, String lastEdit, Timestamp editStamp) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.version = Objects.requireNonNull(version);
        this.maturity = Objects.requireNonNull(maturity);
        this.creator = Objects.requireNonNull(creator);
        this.lastEdit = Objects.requireNonNull(lastEdit);
        this.editStamp = Objects.requireNonNull(editStamp);
    }
    
    public WorkPackage(String name, String creator, String lastEdit, Long workSpaceID, long version) {
        this.name = Objects.requireNonNull(name);
        this.creator = Objects.requireNonNull(creator);
        this.lastEdit = Objects.requireNonNull(lastEdit);
        this.version = Objects.requireNonNull(version);
        editStamp = new Timestamp(new java.util.Date().getTime());
        maturity = Maturity.IN_PROGRESS;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }

    public Timestamp getEditStamp() {
        return editStamp;
    }

    public void setEditStamp(Timestamp editStamp) {
        this.editStamp = editStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
