/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

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
    private boolean session;
    private Long workSpaceID;
    @NotNull
    private Timestamp editStamp;
    
    public Element() {
        
    }

    public Element(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        this.name = Objects.requireNonNull(name);
        this.creator = Objects.requireNonNull(creator);
        this.lastEditor = Objects.requireNonNull(lastEditor);
        this.session = Objects.requireNonNull(session);
        this.workSpaceID = workSpaceID;
        editStamp = new Timestamp(new java.util.Date().getTime());
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

    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
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
        if (!(object instanceof Element)) {
            return false;
        }
        Element other = (Element) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.upem.entity.Element[ id=" + id + " ]";
    }
    
}
