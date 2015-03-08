/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.easypdm.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tai
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UseRole.findByUser", query = "SELECT ur FROM UseRole ur WHERE ur.user = :user")
})
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

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Objects.hashCode(this.roleId);
            hash = 23 * hash + Objects.hashCode(this.userId);
            hash = 23 * hash + Objects.hashCode(this.organisationId);
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
            final Pk other = (Pk) obj;
            if (!Objects.equals(this.roleId, other.roleId)) {
                return false;
            }
            if (!Objects.equals(this.userId, other.userId)) {
                return false;
            }
            if (!Objects.equals(this.organisationId, other.organisationId)) {
                return false;
            }
            return true;
        }
    }
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private Pk pk;
    
    @ManyToOne
    @JoinColumn(name="role_id",insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="user_id",insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name="organisation_id",insertable = false, updatable = false)
    private Organisation organisation;
    
    public UseRole() {
    }
    
    public UseRole(Users user, Organisation organisation, Role role) {
        this.pk = new Pk(role.getId(), user.getId(), organisation.getId());
        this.user = user;
        this.organisation = organisation;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.pk.setRoleId(role.getId());
        this.role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.pk.setUserId(user.getId());
        this.user = user;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.pk.setOrganisationId(organisation.getId());
        this.organisation = organisation;
    }

    public Pk getPk() {
        return pk;
    }

    public void setPk(Pk pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.pk);
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
        final UseRole other = (UseRole) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }
    
    
}
