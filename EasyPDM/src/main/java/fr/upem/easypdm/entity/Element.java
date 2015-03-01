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
import javax.persistence.OneToOne;
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
    @NotNull
    private String path;
    
    @Enumerated(EnumType.STRING)
    private Maturity maturity;

    @ManyToOne
    @JoinColumn(name="organisation_id", nullable=false)
    private Organisation organisation;

    @OneToOne
    @JoinColumn(name="users_lock_id", nullable=false)
    private Users userLockId;  
    
    public Element() {
        
    }

    public Element(String name, String creator, String lastEditor, boolean lock, Timestamp editStamp, String path, Maturity maturity, Organisation organisation, Users userLockId) {
        this.name = name;
        this.creator = creator;
        this.lastEditor = lastEditor;
        this.lock = lock;
        this.editStamp = editStamp;
        this.path = path;
        this.maturity = maturity;
        this.organisation = organisation;
        this.userLockId = userLockId;
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

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Users getUserLockId() {
        return userLockId;
    }

    public void setUserLockId(Users userLockId) {
        this.userLockId = userLockId;
    }
 
    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element other = (Element) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
