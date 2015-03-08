/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import fr.upem.entity.easypdm.more.Maturity;
import java.sql.Timestamp;
import java.util.List;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author sybille
 */
@Entity
public class Book extends Element {

    private String title;
    
    @CascadeOnDelete
    @OneToMany(cascade=REMOVE, fetch = LAZY, mappedBy="book", orphanRemoval = true)
    private List<Tome> tomes;
    
    public Book() {
    }

    public Book(String title, String name, String creator, String lastEditor, boolean lock, Timestamp editStamp, String path, Maturity maturity, Organisation organisation, Users userLockId) {
        super(name, creator, lastEditor, lock, editStamp, path, maturity, organisation, userLockId);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public List<Tome> getTomes() {
        return tomes;
    }

    public void setTomes(List<Tome> tomes) {
        this.tomes = tomes;
    }
    
    
    
    
}
