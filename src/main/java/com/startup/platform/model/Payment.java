package com.startup.platform.model;

import java.math.BigDecimal;

public class Payment {

    private long id;
    private BigDecimal amount;
    private long payerId;
    private long recipientId;

    public Payment() {
    }

    public Payment(BigDecimal amount, long payerId, long recipientId) {
        this.amount = amount;
        this.payerId = payerId;
        this.recipientId = recipientId;
    }

    public Payment(long id, BigDecimal amount, long payerId, long recipientId) {
        this.id = id;
        this.amount = amount;
        this.payerId = payerId;
        this.recipientId = recipientId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPayerId() {
        return payerId;
    }

    public void setPayerId(long payerId) {
        this.payerId = payerId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", payerId=" + payerId +
                ", recipientId=" + recipientId +
                '}';
    }
}
