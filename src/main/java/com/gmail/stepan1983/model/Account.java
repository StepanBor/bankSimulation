package com.gmail.stepan1983.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "Account1")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private double monneyAmmount;

    public Account(User user, Currency currency, double monneyAmmount) {
        this.user = user;
        this.currency = currency;
        this.monneyAmmount = monneyAmmount;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getMonneyAmmount() {
        return monneyAmmount;
    }

    public void setMonneyAmmount(double monneyAmmount) {
        this.monneyAmmount = monneyAmmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
