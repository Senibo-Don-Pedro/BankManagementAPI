package com.senibo.bank_management_api.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity

//@Table(name = "account"). This is useful if you want to give your table another name in the database
@Table
public class Account {

    //Fields
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "accountNumberGenerator")
    @GenericGenerator(
            name = "accountNumberGenerator",
            strategy = "com.senibo.bank_management_api.Generator.AccountNumberGenerator"
    )
    private Long account_number;


//    @Column(name = "accountName"). This is useful if you want to give your column another name
    @Column
    private String account_holder_name;

    @Column
    private Double account_balance;



    //Constructors

    public Account() {
    }

    public Account(String account_holder_name, Double account_balance) {

        this.account_holder_name = account_holder_name;
        this.account_balance = account_balance;
    }


    //Getters and setters

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }
}
