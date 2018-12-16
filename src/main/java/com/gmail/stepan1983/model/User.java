package com.gmail.stepan1983.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="User1")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> userAccounts;

    public User(String name, List<Account> userAccounts) {
        this.name = name;
        this.userAccounts = userAccounts;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<Account> userAccounts) {
        this.userAccounts = userAccounts;
    }
}
