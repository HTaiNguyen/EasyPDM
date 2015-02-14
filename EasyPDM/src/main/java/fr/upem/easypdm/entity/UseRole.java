/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tai
 */
@Entity
public class UseRole implements Serializable {
    
    @Embeddable
    public static class Pk implements Serializable{
        @Column(name="role_id",nullable = false, updatable = false)
        private Long roleId;
        @Column(name="user_id",nullable = false, updatable = false)
        private Long userId;
        @Column(name="organisation_id",nullable = false, updatable = false)
        private Long organisationId;
        
        public Pk() {
        }
        
        public Pk(Long roleId, Long userId, Long organisationId) {
            this.roleId = roleId;
            this.userId = userId;
            this.organisationId = organisationId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getOrganisationId() {
            return organisationId;
        }

        public void setOrganisationId(Long organisationId) {
            this.organisationId = organisationId;
        }
        
    }
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private Pk pk;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="role_id",insertable = false, updatable = false)
    private Role role;
    @NotNull
    @ManyToOne
    @JoinColumn(name="user_id",insertable = false, updatable = false)
    private Users user;
    @NotNull
    @ManyToOne
    @JoinColumn(name="organisation_id",insertable = false, updatable = false)
    private Organisation organisation;
    
    public UseRole() {
        
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Pk getPk() {
        return pk;
    }

    public void setPk(Pk pk) {
        this.pk = pk;
    }
}
