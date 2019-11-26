package com.api.shopapp.model;

import javax.persistence.*;

@Entity
public class Payment {
    private Integer paymentId;
    private String paymentDetails;
    private Integer userid;
    private String paymentMethod;
    private String cardType;
    private User userByUserid;

    @Id
    @Column(name = "Payment_id", nullable = false)
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "payment_details", nullable = false, length = 100)
    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
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
    @Column(name = "payment_method", nullable = false, length = 100)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "card_type", nullable = true, length = 100)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (paymentId != null ? !paymentId.equals(payment.paymentId) : payment.paymentId != null) return false;
        if (paymentDetails != null ? !paymentDetails.equals(payment.paymentDetails) : payment.paymentDetails != null)
            return false;
        if (userid != null ? !userid.equals(payment.userid) : payment.userid != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(payment.paymentMethod) : payment.paymentMethod != null)
            return false;
        if (cardType != null ? !cardType.equals(payment.cardType) : payment.cardType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId != null ? paymentId.hashCode() : 0;
        result = 31 * result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "user_id")
    public User getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(User userByUserid) {
        this.userByUserid = userByUserid;
    }
}
