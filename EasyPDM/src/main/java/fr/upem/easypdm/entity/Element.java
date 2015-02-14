/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
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
    private boolean session;
    private Long workSpaceID;
    @NotNull
    private Timestamp editStamp;
    
    @ManyToOne
    @JoinColumn(name="workpackage_id")
    WorkPackage workPackage;
    
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
    
}
