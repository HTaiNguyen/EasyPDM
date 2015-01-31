/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import fr.upem.entity.more.Maturity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tai
 */
@Entity
@Table(name="WORKPACKAGE")
public class WorkPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long version;
    private Maturity maturity;
    private String creator;
    private String lastEdit;
    private Long workSpaceID;
    private Timestamp editStamp;

    public WorkPackage(String name, String creator, String lastEdit, Long workSpaceID, long version) {
        this.name = Objects.requireNonNull(name);
        this.creator = Objects.requireNonNull(creator);
        this.lastEdit = lastEdit;
        this.workSpaceID = workSpaceID;
        this.version = version;
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

    public Long getWorkSpaceID() {
        return workSpaceID;
    }

    public void setWorkSpaceID(Long workSpaceID) {
        this.workSpaceID = workSpaceID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkPackage)) {
            return false;
        }
        WorkPackage other = (WorkPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.upem.entity.WorkPackage[ id=" + id + " ]";
    }
    
}
