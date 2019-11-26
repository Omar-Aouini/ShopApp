package com.api.shopapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Userroles {
    private Integer userRoleId;
    private Integer userid;
    private String authority;
    private Collection<User> usersByUserRoleId;

    @Id
    @Column(name = "user_role_id", nullable = false)
    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "authority", nullable = false, length = 100)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userroles userroles = (Userroles) o;

        if (userRoleId != null ? !userRoleId.equals(userroles.userRoleId) : userroles.userRoleId != null) return false;
        if (userid != null ? !userid.equals(userroles.userid) : userroles.userid != null) return false;
        if (authority != null ? !authority.equals(userroles.authority) : userroles.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId != null ? userRoleId.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userrolesByRoleid")
    public Collection<User> getUsersByUserRoleId() {
        return usersByUserRoleId;
    }

    public void setUsersByUserRoleId(Collection<User> usersByUserRoleId) {
        this.usersByUserRoleId = usersByUserRoleId;
    }
}
