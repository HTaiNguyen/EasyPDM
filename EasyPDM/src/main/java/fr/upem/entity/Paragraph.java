/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sybille
 */
@Entity
public class Paragraph extends Element implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String creator;
    private String lastEditor;
    private boolean session;
    private Long workSpaceID;
    private Timestamp editStamp;
    private Chapter chapter;

    public Paragraph() {
    }

    public Paragraph(String name, String creator, String lastEditor, boolean session, Long workSpaceID) {
        super(name, creator, lastEditor, session, workSpaceID);
    }

    public Paragraph(Long id, String name, String creator, String lastEditor, boolean session, Long workSpaceID, Timestamp editStamp, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.lastEditor = lastEditor;
        this.session = session;
        this.workSpaceID = workSpaceID;
        this.editStamp = editStamp;
        this.chapter = chapter;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public String getCreator() {
        return super.getCreator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCreator(String creator) {
        super.setCreator(creator); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Timestamp getEditStamp() {
        return super.getEditStamp(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEditStamp(Timestamp editStamp) {
        super.setEditStamp(editStamp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastEditor() {
        return super.getLastEditor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLastEditor(String lastEditor) {
        super.setLastEditor(lastEditor); //To change body of generated methods, choose Tools | Templates.
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getWorkSpaceID() {
        return super.getWorkSpaceID(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWorkSpaceID(Long workSpaceID) {
        super.setWorkSpaceID(workSpaceID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSession() {
        return super.isSession(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSession(boolean session) {
        super.setSession(session); //To change body of generated methods, choose Tools | Templates.
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
        if (!(object instanceof Paragraph)) {
            return false;
        }
        Paragraph other = (Paragraph) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.upem.entity.Paragraph[ id=" + id + " ]";
    }
    
}
