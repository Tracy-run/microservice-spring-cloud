package com.bus.provideruser.microservicespringprovideruser.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private String age;
    @Column
    private BigDecimal balance;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
