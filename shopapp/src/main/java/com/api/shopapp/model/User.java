package com.api.shopapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private Integer userId;
    private String userName;
    private Integer userPhoneNumber;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userCity;
    private String userCountry;
    private Integer userPostalcode;
    private Integer roleid;
    private Byte enabled;
    private Collection<Payment> paymentsByUserId;
    private Collection<Review> reviewsByUserId;
    private Userroles userrolesByRoleid;

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_phone_number", nullable = false)
    public Integer getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Basic
    @Column(name = "user_email", nullable = false, length = 45)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 45)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_address", nullable = false, length = 45)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "user_city", nullable = false, length = 45)
    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Basic
    @Column(name = "user_country", nullable = false, length = 45)
    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    @Basic
    @Column(name = "user_postalcode", nullable = false)
    public Integer getUserPostalcode() {
        return userPostalcode;
    }

    public void setUserPostalcode(Integer userPostalcode) {
        this.userPostalcode = userPostalcode;
    }

    @Basic
    @Column(name = "roleid", nullable = true)
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPhoneNumber != null ? !userPhoneNumber.equals(user.userPhoneNumber) : user.userPhoneNumber != null)
            return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userAddress != null ? !userAddress.equals(user.userAddress) : user.userAddress != null) return false;
        if (userCity != null ? !userCity.equals(user.userCity) : user.userCity != null) return false;
        if (userCountry != null ? !userCountry.equals(user.userCountry) : user.userCountry != null) return false;
        if (userPostalcode != null ? !userPostalcode.equals(user.userPostalcode) : user.userPostalcode != null)
            return false;
        if (roleid != null ? !roleid.equals(user.roleid) : user.roleid != null) return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (userCity != null ? userCity.hashCode() : 0);
        result = 31 * result + (userCountry != null ? userCountry.hashCode() : 0);
        result = 31 * result + (userPostalcode != null ? userPostalcode.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<Payment> getPaymentsByUserId() {
        return paymentsByUserId;
    }

    public void setPaymentsByUserId(Collection<Payment> paymentsByUserId) {
        this.paymentsByUserId = paymentsByUserId;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<Review> getReviewsByUserId() {
        return reviewsByUserId;
    }

    public void setReviewsByUserId(Collection<Review> reviewsByUserId) {
        this.reviewsByUserId = reviewsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "user_role_id")
    public Userroles getUserrolesByRoleid() {
        return userrolesByRoleid;
    }

    public void setUserrolesByRoleid(Userroles userrolesByRoleid) {
        this.userrolesByRoleid = userrolesByRoleid;
    }
}
