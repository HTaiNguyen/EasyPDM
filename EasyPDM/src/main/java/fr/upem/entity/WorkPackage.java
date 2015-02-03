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
    private Long workSpaceID;
    @NotNull
    private Timestamp editStamp;
    private Element elementwp;

    public WorkPackage() {
        
    }

    public WorkPackage(Long id, String name, long version, Maturity maturity, String creator, String lastEdit, Long workSpaceID, Timestamp editStamp, Element elementwp) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.version = Objects.requireNonNull(version);
        this.maturity = Objects.requireNonNull(maturity);
        this.creator = Objects.requireNonNull(creator);
        this.lastEdit = Objects.requireNonNull(lastEdit);
        this.workSpaceID = workSpaceID;
        this.editStamp = Objects.requireNonNull(editStamp);
        this.elementwp = elementwp;
    }
    
    public WorkPackage(String name, String creator, String lastEdit, Long workSpaceID, long version) {
        this.name = Objects.requireNonNull(name);
        this.creator = Objects.requireNonNull(creator);
        this.lastEdit = Objects.requireNonNull(lastEdit);
        this.workSpaceID = workSpaceID;
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

    public Element getElementwp() {
        return elementwp;
    }

    public void setElementwp(Element elementwp) {
        this.elementwp = elementwp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
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
